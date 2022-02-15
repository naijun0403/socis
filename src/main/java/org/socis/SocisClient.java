/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis;

import org.socis.event.EventManager;
import org.socis.network.Server;

public class SocisClient extends Thread {
    private final int port;
    private Server server;

    public SocisClient() {
        this(3000);
    }

    public SocisClient(int port) {
        this.port = port;
        this.server = null;
    }

    public void addListener(Object eventListener) {
        EventManager.register(eventListener);
    }

    public void run() {
        this.server = new Server(this.port);
        this.server.start();
    }
}
