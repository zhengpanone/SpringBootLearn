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
@Document(collection = "cms_pooling")
public class CmsPooling implements Serializable {
    @Id
    private String id;
    //pooling单名称
    private String poolingName;
    // 上机平台
    private String seqPlatform;
    //是否外包
    private Integer isOutBusiness;

    private CmsProject[] cmsProjects;
}
