package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * taken from Francisco Iacobelli, available online at: https://www.youtube.com/watch?v=xiK-DH74oJg
 * @author Francisco Iacobelli
 * @version 2016-12-01
 */
public class RSSReader {
	
	/**
	 * method to get String of RSS feeds
	 * @param urlAddress
	 * @return sourceCode
	 */
	public static String readRSS(String urlAddress) {
		String sourceCode = "";
		try {
			URL rssUrl = new URL(urlAddress);
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
				String line;
				while((line = in.readLine())!=null){
					if(line.contains("<title><![CDATA[")){
						int firstPos = line.indexOf("<title><![CDATA[");
						String temp = line.substring(firstPos);
						temp = temp.replace("<title><![CDATA[", "");
						int lastPos = temp.indexOf("]]></title>");
						temp = temp.substring(0, lastPos);
						sourceCode += temp+"\n"+"\n";
					}
				}
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sourceCode;
		
	}
}
