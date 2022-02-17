/**
 * Created by naijun on 2022/02/14
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.network;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.NonNull;
import org.socis.api.author.MessageAuthor;
import org.socis.api.channel.MessageChannel;
import org.socis.event.EventManager;
import org.socis.event.message.MessageEvent;
import org.socis.helper.Encoder;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * UDP Server
 * @author naijun
 */
public class Server {

    private InetAddress host;
    private int port;
    public DatagramSocket socket;

    public Server() {
        this(3000);
    }

    public Server(int port) {
        this.host = null;
        this.port = port;
        this.socket = null;
    }

    public void start() {
        if (this.socket != null) {
            this.socket.close();
        }
        try {
            this.socket = new DatagramSocket(this.port);
            while (true) {
                byte[] buffer = new byte[20480];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length); // ready
                socket.receive(packet);
                this.host = packet.getAddress();
                this.port = packet.getPort();
                this.pushEvent(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pushEvent(@NonNull DatagramPacket packet) {
        Objects.requireNonNull(packet);
        JsonObject json = new Gson().fromJson(new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8).replaceAll("\0", ""), JsonObject.class);
        if (json.has("event")) {
            MessageChannel channel = new MessageChannel(this, json);
            MessageAuthor author = new MessageAuthor(json);
            MessageEvent event = new MessageEvent(json, channel, author);
            EventManager.instance.handle(event);
        }
    }

    /**
     * send Packet
     * @param jsonObject
     */
    public void send(@NonNull JsonObject jsonObject) {
        try {
            String json = Encoder.encodeURIComponent(jsonObject.toString());
            DatagramPacket packet = new DatagramPacket(json.getBytes(), json.length(), this.host, this.port);
            this.socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Server{" +
                "host=" + host +
                ", port=" + port +
                ", socket=" + socket +
                '}';
    }
}
