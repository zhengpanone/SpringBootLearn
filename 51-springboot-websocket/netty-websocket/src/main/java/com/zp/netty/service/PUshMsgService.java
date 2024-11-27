package com.zp.netty.service;

/**
 * Author : zhengpanone
 * Date : 2024/3/8 15:18
 * Version : v1.0.0
 * Description: 推送消息接口
 */
public interface PUshMsgService {
    /**
     * 推送消息给指定用户
     *
     * @param userId
     * @param msg
     */
    void pushMsgToOne(String userId, String msg);

    /**
     * 推送给所有用户
     * @param msg
     */
    void pushMsgToAll(String msg);
}
