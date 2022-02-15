/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.api.channel;

import com.google.gson.JsonObject;
import org.socis.network.Server;

import java.util.UUID;

public class MessageChannel {

    private final Server socket;
    private final JsonObject packet;

    public MessageChannel(Server socket, JsonObject packet) {
        this.socket = socket;
        this.packet = packet;
    }

    public String getChannelName() {
        return packet.get("data").getAsJsonObject().get("room").getAsString();
    }

    /**
     * send Message
     * @param text
     * @return
     */
    public boolean sendMessage(String text) {
        if (text == null)
            throw new RuntimeException("Provided text for message");

        String sessionUUID = UUID.randomUUID().toString();

        JsonObject packetData = new JsonObject();
        JsonObject body = new JsonObject();

        body.addProperty("room", this.packet.get("data").getAsJsonObject().get("room").getAsString()); // TODO(roomName)
        body.addProperty("text", text);

        packetData.addProperty("event", "sendText");
        packetData.add("data", body);
        packetData.addProperty("session", sessionUUID);

        this.socket.send(packetData);
        return true;
    }
}
