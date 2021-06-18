package com.zp.util;

import com.zp.vo.ColumnInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

/**
 * @Author: zhengpanone
 * @Description: 将获取到的Mysql字段信息转出Java字段类型，并且获取代码生成的路径，读取 Template，并且输出成文件
 * @Date:Created in 2021/07/20 13:48.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
public class GeneratorUtil {
    private static final String TIMESTAMP = "Timestamp";
    private static final String BIGDECIMAL = "BigDecimal";
    private static final String PK = "PRI";
    private static final String EXTRA = "auto_increment";

    public static void generatorCode(List<ColumnInfo> columnInfos, String pack, String author, String tableName) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("package", pack);
        map.put("author", author);
        map.put("date", LocalDate.now().toString());
        map.put("tableName", tableName);
        String clazzName = ColumnUtil.toCapitalizeCamelCase(tableName);
        String changeClazzName = ColumnUtil.toCameCase(tableName);

        map.put("className", clazzName);
        map.put("changeName", changeClazzName);
        map.put("hasTimestamp", false);
        map.put("hasBigDecimal", false);
        map.put("auto", false);

        List<Map<String, Object>> columns = new ArrayList<>();
        for (ColumnInfo column : columnInfos) {
            Map<String, Object> listMap = new HashMap<>();
            listMap.put("columnComment", column.getColumnComment());
            listMap.put("columnKey", column.getColumnKey());
            String colType = ColumnUtil.colToJava(column.getColumnType().toString());
            String changeColumnName = ColumnUtil.colToJava(column.getColumnName().toString());
            if (PK.equals(column.getColumnKey())) {
                map.put("pkColumnType", colType);
                map.put("pkChangeColName", changeColumnName);
            }
            if (TIMESTAMP.equals(colType)) {
                map.put("hasTimestamp", true);
            }
            if (BIGDECIMAL.equals(colType)) {
                map.put("hasBigDecimal", true);
            }
            if (EXTRA.equals(column.getExtra())) {
                map.put("auto", true);
            }
            listMap.put("columnType", colType);
            listMap.put("columnName", column.getColumnName());
            listMap.put("isNullable", column.getIsNullable());
            listMap.put("changeColumnName", changeColumnName);
            columns.add(listMap);
        }
        map.put("columns", columns);
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(GeneratorUtil.class, "/template");
        Template template = configuration.getTemplate("Entity.ftl");
        String filePath = getAdminFilePath(pack, clazzName);
        File file = new File(filePath);
        System.out.println(map);
        genFile(file,template,map);

    }

    /**
     * 定义文件路径以及名称
     * @param pack
     * @param className
     * @return
     */
    private static String getAdminFilePath(String pack, String className) {
        String projectPath = System.getProperty("user.dir") + File.separator;
        String packagePath = projectPath + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator;
        if (!ObjectUtils.isEmpty(pack)) {
            packagePath += pack.replace(".", File.separator) + File.separator;
        }
        return packagePath+"entity"+File.separator+className+".java";
    }

    private static void genFile(File file, Template template, Map<String,Object> params) throws IOException {
        File parentFile = file.getParentFile();
        //创建目录
        if(parentFile!=null && !parentFile.exists()){
            parentFile.mkdirs();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        try {
            template.process(params,writer);
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }


}
