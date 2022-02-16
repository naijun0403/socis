/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.event.message;

import com.google.gson.JsonObject;
import lombok.NonNull;
import org.socis.api.author.MessageAuthor;
import org.socis.api.channel.MessageChannel;

/**
 * Message Event
 * @author naijun
 */
public class MessageEvent {

    private final JsonObject packet;
    private final MessageChannel channel;
    private final MessageAuthor author;

    public MessageEvent(JsonObject packet, MessageChannel channel, MessageAuthor author) {
        this.packet = packet;
        this.channel = channel;
        this.author = author;
    }

    public @NonNull MessageChannel getChannel() {
        return channel;
    }

    public @NonNull MessageAuthor getAuthor() {
        return author;
    }

    public @NonNull String getMessage() {
        return packet.get("data").getAsJsonObject().get("content").getAsString();
    }

}
