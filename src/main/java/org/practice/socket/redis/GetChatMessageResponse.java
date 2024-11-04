package org.practice.socket.redis;

import lombok.Data;

@Data
public class GetChatMessageResponse {
    private ChatMessageRequest request;

    public GetChatMessageResponse(ChatMessageRequest request) {
        this.request = request;
    }
}
