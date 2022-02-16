/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.test;

import org.socis.SocisClient;
import org.socis.event.EventListenerService;
import org.socis.event.message.MessageEvent;

public class EventListenerTest extends EventListenerService {
    public static void main(String[] args) {
        SocisClient client = new SocisClient();
        System.out.println("ready");
        client.addListener(new EventListenerTest());
        client.start();
        System.out.println("start");
    }

    @Override
    public void onMessage(MessageEvent event) {
        if (event.getMessage().equals("!ping")) {
            event.getChannel().sendMessage("pong!");
        }

        if (event.getMessage().equals("!java")) {
            event.getChannel().sendMessage(String.class.getName());
        }

        if (event.getMessage().equals("!authorTest")) {
            event.getChannel().sendMessage(event.getAuthor().getName());
            System.out.println(event.getAuthor().getProfileBase64());
        }
    }
}
