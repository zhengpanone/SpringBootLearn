package com.zp.service;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * IndexService
 *
 * @author zhengpanone
 * @since 2021-12-02
 */
@Service
@Slf4j
public class IndexService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void createIndex() {
        try {
            // 创建 Mapping
            XContentBuilder mapping =XContentFactory.jsonBuilder()
                    .startObject().field("dynamic", true)
                    .startObject("properties")
                    .startObject("name").field("type", "text")
                    .startObject("field")
                    .startObject("keyword").field("type", "keyword")
                    .endObject().endObject().endObject().endObject().endObject();
            // 创建索引配置信息，配置
            Settings settings  = Settings.builder().put("index.number_of_shards", 1)
                    .put("index.number_of_replicas", 0)
                    .build();

            // 新建创建索引请求对象，然后设置索引类型（ES 7.0 将不存在索引类型）和 mapping 与 index 配置
            CreateIndexRequest request = new CreateIndexRequest("mydlq-user", settings);
            request.mapping("doc", mapping);
            // RestHighLevelClient 执行创建索引
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            // 判断是否创建成功
            boolean isCreated = createIndexResponse.isAcknowledged();
            log.info("是否创建成功：{}", isCreated);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
