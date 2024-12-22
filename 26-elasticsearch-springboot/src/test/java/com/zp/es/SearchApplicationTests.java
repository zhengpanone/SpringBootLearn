package com.zp.es;

import com.alibaba.fastjson.JSON;
import com.zp.es.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

/**
 * Author : zhengpanone
 * Date : 2024/12/20 14:53
 * Version : v1.0.0
 * Description:
 */
@Slf4j
@SpringBootTest
public class SearchApplicationTests {
    @Qualifier("restHighLevelClient")
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Test
    public void contextLoads() {
        log.info(restHighLevelClient.toString());
    }

    @DisplayName(value = "测试存储数据到 ES")
    @Test
    public void testIndexData() throws IOException {
        IndexRequest request = new IndexRequest("users");
        // 文档ID
        request.id("1");
        // 构造User对象
        User user = User.builder().userName("zhangsan").age("18").gender("男").build();

        String jsonString = JSON.toJSONString(user);
        request.source(jsonString, XContentType.JSON);

        // 执行插入操作
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        log.info(response.toString());
    }

    @DisplayName("检索数据")
    @Test
    public void testSearchData() throws IOException {
        SearchRequest request = new SearchRequest();
        request.indices("users");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("userName", "zhangsan"));
        request.source(sourceBuilder);

        // 执行检索
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        log.info(response.toString());

        // 获取查到的数据
        SearchHits hits = response.getHits();
        for (SearchHit hit : hits.getHits()) {
            log.info(hit.getSourceAsString());
            User user = JSON.parseObject(hit.getSourceAsString(), User.class);
            log.info(user.toString());
        }
    }
}
