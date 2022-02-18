package com.zp.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * ElasticsearchConfig
 * Elasticsearch 配置类
 *
 * @author zhengpanone
 * @since 2021-12-02
 */
@Configuration
public class ElasticsearchConfig {
    /**
     * 协议
     */
    @Value("${elasticsearch.schema:http}")
    private String schema;
    /**
     * 集群地址,如果有多个用“,”分隔
     */
    @Value("${elasticsearch.address}")
    private String address;
    /**
     * 连接超时时间
     */
    @Value("${elasticsearch.connectTimeout:5000}")
    private int connectTimeout;

    /**
     * Socket 连接超时时间
     */
    @Value("${elasticsearch.socketTimeout:10000}")
    private int socketTimeout;

    /**
     * 获取连接的超时时间
     */
    @Value("${elasticsearch.connectionRequestTimeout:5000}")
    private int connectionRequestTimeout;

    /**
     * 最大连接数
     */
    @Value("${elasticsearch.maxConnectNum:100}")
    private int maxConnectNum;

    /**
     * 最大路由连接数
     */
    @Value("${elasticsearch.maxConnectPerRoute:100}")
    private int maxConnectPerRoute;

    public RestHighLevelClient restHighLevelClient(){
        List<HttpHost> hostLists = new ArrayList<>();
        String[] hostList = address.split(",");
        for(String addr:hostList){
            String host = addr.split(":")[0];
            String port = addr.split(":")[1];
            hostLists.add(new HttpHost(host,Integer.parseInt(port)));
        }
        // 转换成HttpHost数组
        HttpHost[] httpHosts = hostLists.toArray(new HttpHost[]{});
        // 构建连接对象
        RestClientBuilder builder = RestClient.builder(httpHosts);
        // 异步连接延时配置
        builder.setRequestConfigCallback(requestConfigBuilder->{
            requestConfigBuilder.setConnectTimeout(connectTimeout);
            requestConfigBuilder.setSocketTimeout(socketTimeout);
            requestConfigBuilder.setConnectionRequestTimeout(connectionRequestTimeout);
            return requestConfigBuilder;
        });
        builder.setHttpClientConfigCallback(httpClientBuilder->{
            httpClientBuilder.setMaxConnTotal(maxConnectNum);
            httpClientBuilder.setMaxConnPerRoute(maxConnectPerRoute);
            return httpClientBuilder;
        });
        return new RestHighLevelClient(builder);
    }
}
