package org.practice.socket.service;

import lombok.RequiredArgsConstructor;
import org.practice.socket.redis.ChatMessageRequest;
import org.practice.socket.redis.MessageType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final RedisTemplate redisTemplate;

    @Transactional
    public void sendMessage(ChatMessageRequest chatMessageRequest) {

        if (chatMessageRequest.getMessageType() == MessageType.TALK) {

        }
    }
}
