package com.zp.bean;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * MyRoutingDataSource
 *
 * @author zhengpanone
 * @since 2021-09-22
 */

public class MyRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DBContextHolder.get();
    }
}
