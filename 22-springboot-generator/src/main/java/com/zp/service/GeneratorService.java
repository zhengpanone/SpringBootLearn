package com.zp.service;

import com.zp.vo.ColumnInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/20 14:29.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@Service
public class GeneratorService {
    @PersistenceContext
    private EntityManager em;

    public List<ColumnInfo> getColumns(String tableName) {
        StringBuilder sql = new StringBuilder("SELECT t.COLUMN_NAME,t.DATA_TYPE,t.IS_NULLABLE,t.COLUMN_COMMENT,t.COLUMN_KEY,t.EXTRA " +
                "FROM information_schema.`COLUMNS` as t " +
                "WHERE t.TABLE_SCHEMA=(SELECT DATABASE()) ");
        if (!ObjectUtils.isEmpty(tableName)) {
            sql.append("AND t.TABLE_NAME='").append(tableName).append("' ");
        }
        sql.append("ORDER BY t.ORDINAL_POSITION;");
        Query query = em.createNativeQuery(sql.toString());
        List result = query.getResultList();
        List<ColumnInfo> columnInfos = new ArrayList<>();
        for (Object o : result) {
            Object[] obj = (Object[]) o;
            columnInfos.add(new ColumnInfo(obj[0], obj[1], obj[2], obj[3], obj[4], obj[5]));
        }
        return columnInfos;
    }


}
