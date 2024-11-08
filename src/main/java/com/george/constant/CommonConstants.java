package com.george.constant;

/**
 * @author xwq
 * @version 1.0
 * @date 2021/1/11 15:23
 * @describe 常量定义
 */
public interface CommonConstants {

    /**
     * true
     */
    boolean TRUE = true;

    /**
     * 成功标记
     */
    Integer SUCCESS = 0;

    /**
     * 失败标记
     */
    Integer FAIL = 1;

    /**
     * 订阅的bean名称
     */
    String CHANNEL_NAME_IN = "mqttInboundChannel";

    /**
     * 发布的bean名称
     */
    String CHANNEL_NAME_OUT = "mqttOutboundChannel";

    /**
     * offline
     */
    String OFFLINE = "offline";

    /**
     * willTopic
     */
    String WILL_TOPIC = "willTopic";

    /**
     * 拾音器点位编码前缀
     */
    String PICKUP_CODE_PRE = "pickup_";
}
