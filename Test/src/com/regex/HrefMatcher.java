package com.regex;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HrefMatcher {
	public static void main(String[] args) {
		String urlStr = "http://www.qq.com";
		try {
			InputStreamReader in = new InputStreamReader( new URL( urlStr ).openStream() );
			StringBuilder sb = new StringBuilder();
			int ch;
			while((ch = in.read())!=-1){
				sb.append( (char)ch );
			}
			String patternStr = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>])\\s*";
			Pattern p = Pattern.compile( patternStr,Pattern.CASE_INSENSITIVE );
			Matcher m = p.matcher( sb );
			while(m.find()){
				String rlt = m.group(1);
				System.out.println("===="+rlt);
				int start = m.start();
				int end = m.end();
				String match = sb.substring( start,end );
//				System.out.println( match );
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
