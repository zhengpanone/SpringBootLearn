package com.zp.model.cms;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@ToString
@Document(collection = "cms_tag")
public class CmsTag {
    private String id;
    private String name;
    private CmsProject[] cmsProjects;
}
