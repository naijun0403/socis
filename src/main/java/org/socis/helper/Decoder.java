/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.helper;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * decodeURIComponent
 * @author naijun
 */
public class Decoder {

    public static String decodeURIComponent(String data) {
        return URLDecoder.decode(data, StandardCharsets.UTF_8);
    }

}
