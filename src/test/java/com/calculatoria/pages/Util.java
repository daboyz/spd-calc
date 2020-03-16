package com.calculatoria.pages;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;


public class Util {

    protected static final String clickScript = "arguments[0].click()";

    protected static final String cookieScript = "return document.cookie.match('zf_obspaska1').input.split('zf_obspaska1=')[1]";

    /** Handling math symbols encoding to UTF-8 in notes stored in cookie file */
    public static String decoder(String input) throws UnsupportedEncodingException {
        String output = input.replace("+", "%2B").replace("-", "%2D").replace("*", "%2A").replace("/", "%2F");
        return URLDecoder.decode(output, "UTF-8");
    }

}
