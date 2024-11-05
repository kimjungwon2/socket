package org.practice.socket.controller;

import lombok.RequiredArgsConstructor;
import org.practice.socket.redis.ChatMessageRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatMessageController {

    private final ChatMessageService chatMessageService;

    @MessageMapping("/chat/message")
    public void message(
            ChatMessageRequest chatMessageRequest
    ) {
        chatMessageService.sendMessage(chatMessageRequest, user);
    }
}