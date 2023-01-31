package com.orange.qqbot.handle;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author : yilantingfeng
 * @version : v1.0
 * @projectName : QQBot
 * @package : com.orange.qqbot.handle
 * @className : Handler
 * @description:
 * @date : 2023/1/31 12:49
 */
public interface Handler extends InitializingBean {

    <T extends Handler> T init(JSONObject t);

    void run();
}
