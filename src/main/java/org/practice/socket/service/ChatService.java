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
    public void sendMessage(ChatMessageRequest chatMessageRequest, User user) {
        ChatRoom chatRoom = chatRoomRepository.findById(chatMessageRequest.getRoomId()).orElseThrow(ChatRoomNotFoundException::new);

        //채팅 생성 및 저장
        ChatMessage chatMessage = ChatMessage.builder()
                .chatRoom(chatRoom)
                .user(user)
                .message(chatMessageRequest.getMessage())
                .build();

        chatMessageRepository.save(chatMessage);
        String topic = channelTopic.getTopic();


        chatMessageRequest.setNickName(user.getNickname());
        chatMessageRequest.setUserId(user.getId());

        if (chatMessageRequest.getType() == ChatMessageRequest.MessageType.TALK) {
            redisTemplate.convertAndSend(topic, chatMessageRequest);
        }
    }
}
