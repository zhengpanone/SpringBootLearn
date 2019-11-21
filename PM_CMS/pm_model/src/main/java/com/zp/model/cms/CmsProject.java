package com.zp.model.cms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Setter
@Getter
@ToString
@Document(collection = "cms_project")
public class CmsProject implements Serializable {
    @Id
    private String id;
    //pooling单ID
    private String poolingId;

    // 任务单名称
    private String projectName;
    // 文库号
    private String libraryName;
    // 样本名称
    private String sampleName;
    //核酸编号
    private String nucleicName;
    //文库类型
    private String libraryType;
    // I5 index
    private String indexI5;
    // I7 index
    private String indexI7;
    // 文库是否合格
    private String libraryIsTrue;
    // lane
    private String lane;
    // 数据产出
    private String output;

    //标签
    private CmsTag[] cmsTags;

}
