package com.zp.manage_cms.dao;

import com.zp.cms.CmsPage;

import org.springframework.data.mongodb.repository.MongoRepository;

/***
 * 同Spring Data JPA一样Spring Data mongodb 也提供自定义方法的规则
 * 按照findByXXX、findByXXXAndYYY、countByXXXAndYYY等规则定义方法,实现查询操作
 */
public interface CmsPageRepository extends MongoRepository<CmsPage, String> {
    /**
     * 根据页面名称查询
     *
     * @param pageName
     * @return
     */
    CmsPage findByPageName(String pageName);

    /**
     * 根据页面名称和类型查询
     *
     * @param pageName
     * @param pageType
     * @return
     */
    CmsPage findByPageNameAndPageType(String pageName, String pageType);

    /**
     * 根据站点和页面类型查询记录数
     *
     * @param siteId
     * @param pageType
     * @return
     */
    int countBySiteIdAndPageType(String siteId, String pageType);

    /**
     * 根据站点也页面类型分页查询
     *
     * @param siteId
     * @param pageType
     * @param pageable
     * @return
     */
//    Page<CmsPage> findBySiteIdAndPageType(String siteId, String pageType, Pageable pageable);
}
