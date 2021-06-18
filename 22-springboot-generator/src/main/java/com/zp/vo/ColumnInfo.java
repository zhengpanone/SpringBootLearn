package com.zp.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: zhengpanone
 * @Description:
 * 接收Mysql字段详细信息
 * @Date:Created in 2021/07/20 11:44.
 * @Email zhengpanone@hotmail.com
 * @Modified By:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnInfo {

    // 数据库字段名称
    private Object columnName;
    //数据库字段类型
    private Object columnType;
    // 允许空值
    private Object isNullable;
    //数据库字段注释
    private Object columnComment;
    // 数据库字段键类型
    private Object columnKey;
    // 额外字段
    private Object extra;
}
