package com.zp.netty.service.impl;

import com.zp.netty.config.NettyConfig;
import com.zp.netty.service.PUshMsgService;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Author : zhengpanone
 * Date : 2024/3/8 15:21
 * Version : v1.0.0
 * Description: 推送消息实现类
 */
@Service
public class PushMsgServiceImpl implements PUshMsgService {
    /**
     * 推送消息给指定用户
     *
     * @param userId
     * @param msg
     */
    @Override
    public void pushMsgToOne(String userId, String msg) {
        Channel channel = NettyConfig.getChannel(userId);
        if (Objects.isNull(channel)) {
            throw new RuntimeException("未连接socket服务器");
        }
        channel.writeAndFlush(new TextWebSocketFrame(msg));

    }

    /**
     * 推送给所有用户
     *
     * @param msg
     */
    @Override
    public void pushMsgToAll(String msg) {
        NettyConfig.getChannelGroup().writeAndFlush(new TextWebSocketFrame(msg));
    }
}
