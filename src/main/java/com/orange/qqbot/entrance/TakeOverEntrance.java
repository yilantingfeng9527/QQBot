package com.orange.qqbot.entrance;

import com.alibaba.fastjson.JSONObject;
import com.orange.qqbot.core.factory.EventHandlerFactory;
import com.orange.qqbot.core.CommonHandler;
import com.orange.qqbot.core.domain.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yilantingfeng
 * @version : v1.0
 * @projectName : QQBot
 * @package : com.orange.qqbot.controller
 * @className : TakeOver
 * @description:
 * @date : 2023/1/6 13:00
 */
@RestController
@Slf4j
public class TakeOverEntrance {
    @PostMapping("/")
    public void takeOver(@RequestBody JSONObject postMessage) {
        String postType = postMessage.getString(Constants.POST_TYPE);
        CommonHandler invokeHandler = EventHandlerFactory.getInvokeHandler(postType);
        try {
            invokeHandler.init(postMessage).run();
        } catch (Exception e) {
            log.error("takeOver error", e);
        }
    }
}
