/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.event;

import org.socis.event.message.MessageEvent;

public interface EventListener {
    void callEvent(MessageEvent event);
}
