/**
 * Created by naijun on 2022/02/16
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.api.author;

import com.google.gson.JsonObject;

/**
 * Message Author
 * @author naijun
 */
public class MessageAuthor {

    private final JsonObject packet;

    public MessageAuthor(JsonObject packet) {
        this.packet = packet;
    }

    public String getName() {
        return packet.get("data").getAsJsonObject().get("sender").getAsString();
    }

    public String getProfileBase64() {
        return packet.get("data").getAsJsonObject().get("profileImage").getAsString();
    }

}
