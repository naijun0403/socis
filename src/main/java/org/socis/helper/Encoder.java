/**
 * Created by naijun on 2022/02/15
 * Copyright (c) naijun.
 * This code is licensed under the MIT Licensing Principles.
 */

package org.socis.helper;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * encodeURIComponent
 * @author naijun
 */
public class Encoder {

    public static String encodeURIComponent(String data) {
        return URLEncoder.encode(data, StandardCharsets.UTF_8)
                .replaceAll("\\+", "%20")
                .replaceAll("\\%21", "!")
                .replaceAll("\\%27", "'")
                .replaceAll("\\%28", "(")
                .replaceAll("\\%29", ")")
                .replaceAll("\\%7E", "~");
    }

}
