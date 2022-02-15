/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.event.message;

import com.google.gson.JsonObject;
import org.socis.api.channel.MessageChannel;

public class MessageEvent {
    private final JsonObject packet;
    private final MessageChannel channel;

    public MessageEvent(JsonObject packet, MessageChannel channel) {
        this.packet = packet;
        this.channel = channel;
    }

    public MessageChannel getChannel() {
        return channel;
    }

    public String getMessage() {
        return packet.get("data").getAsJsonObject().get("content").getAsString();
    }

    public String getSender() {
        return packet.get("data").getAsJsonObject().get("sender").getAsString();
    }
}
