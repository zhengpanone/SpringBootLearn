package com.zp;

import com.zp.service.GeneratorService;
import com.zp.util.ColumnUtil;
import com.zp.util.GeneratorUtil;
import com.zp.vo.ColumnInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

/**
 * @Author: zhengpanone
 * @Description:
 * @Date:Created in 2021/07/20 14:52.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */

@SpringBootTest
public class GeneratorDomeApplicationTests {

    @Autowired
    private GeneratorService generatorService;
    @Test
    void geneTest() throws IOException {
        String tableName = "sys_settings";
        List<ColumnInfo> columnInfos = generatorService.getColumns(tableName);
        GeneratorUtil.generatorCode(columnInfos,"com.zp","zhengpanone","sys_settings");
    }
}
