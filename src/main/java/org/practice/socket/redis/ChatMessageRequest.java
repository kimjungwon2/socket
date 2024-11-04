package org.practice.socket.redis;

import lombok.Data;

@Data
public class ChatMessageRequest {
    private Long roomId;
    private String type;
    private String roomMessage;
}
