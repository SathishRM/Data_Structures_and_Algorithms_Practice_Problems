/*
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service.
There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL and
the tiny URL can be decoded to the original URL.
 */
package string;

import java.util.HashMap;
import java.util.Map;

public class EncodeDecodeTinyURL {
    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }

}

class Codec {
    Map<String,String> urlMapping;
    public Codec() {
        urlMapping = new HashMap<>();
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = ""+longUrl.hashCode();//urlMapping.size();
        urlMapping.put(shortUrl,longUrl);
        //System.out.println(shortUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlMapping.get(shortUrl);
    }
}
