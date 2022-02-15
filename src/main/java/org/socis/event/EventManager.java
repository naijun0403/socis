/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.event;

import org.socis.event.message.MessageEvent;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private static final List<EventListener> listeners = new ArrayList<>();

    public static void register(Object listener) {
        if (!(listener instanceof EventListener)) {
            throw new IllegalArgumentException("Listener must be EventListener");
        }

        listeners.add((EventListener) listener);
    }

    public static void unregister(Object listener) {
        if (!(listener instanceof EventListener)) {
            System.out.println("[ERROR] An error occurred while removing the event listener.");
        }

        listeners.remove(listener);
    }

    public static void handle(MessageEvent event) {
        for (EventListener listener : listeners) {
            listener.callEvent(event);
        }
    }
}
