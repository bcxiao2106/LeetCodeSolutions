package String;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Random;

public class DesignTinyURL {

	private Hashtable<String, String> urlHt;
	public DesignTinyURL(){
		this.urlHt = new Hashtable<String, String>();
	}
	
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        Random rdm = new Random();
        StringBuilder urlStr = new StringBuilder("http://tinyurl.com/");
        char[] rdmChars = new char[6];
        rdmChars[0] = (char)('a' + rdm.nextInt(26));
        rdmChars[1] = (char)('1' + rdm.nextInt(9));
        rdmChars[2] = (char)('A' + rdm.nextInt(26));
        rdmChars[3] = (char)('1' + rdm.nextInt(9));
        rdmChars[4] = (char)('a' + rdm.nextInt(26));
        rdmChars[5] = (char)('a' + rdm.nextInt(26));
        urlStr.append(rdmChars);
        urlHt.put(urlStr.toString(), longUrl);
        return urlStr.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return this.urlHt.get(shortUrl);
    }
}
