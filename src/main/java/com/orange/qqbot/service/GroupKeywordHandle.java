package com.orange.qqbot.service;

import com.alibaba.fastjson.JSONObject;
import com.orange.qqbot.config.KeyWordHandlerFactory;
import com.orange.qqbot.core.CustomizeMessageHandle;
import com.orange.qqbot.core.annotation.EventHandler;
import com.orange.qqbot.core.annotation.GroupMessage;
import com.orange.qqbot.core.domain.constant.KeyWord;
import com.orange.qqbot.core.domain.constant.MessageType;

/**
 * @author : yilantingfeng
 * @version : v1.0
 * @projectName : QQBot
 * @package : com.orange.qqbot.service
 * @className : TestAnnotation
 * @description:
 * @date : 2023/2/1 11:06
 */
@EventHandler
public class GroupKeywordHandle implements CustomizeMessageHandle {
    @Override
    @GroupMessage
    public void handle(JSONObject postMessage) {
        KeyWordHandlerFactory.getInvokeHandler(KeyWord.KEYWORD, MessageType.GROUP).init(postMessage).run(MessageType.GROUP);
    }
}