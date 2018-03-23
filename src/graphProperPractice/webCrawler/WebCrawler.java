package graphProperPractice.webCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {

	private Queue<String> queue;
	private List<String> discoveredWebSitesList;

	public WebCrawler() {
		this.queue = new LinkedList<String>();
		this.discoveredWebSitesList = new ArrayList<String>();
	}

	public void discoverWeb(String root){

		this.queue.add(root);
		while(!queue.isEmpty()){
			String v = this.queue.remove();
			
			String rawHtml = readURL(v);
			
			String regEx = "https://(\\w+\\.)*(\\w+)";
			Pattern pattern = Pattern.compile(regEx);
			Matcher matcher = pattern.matcher(rawHtml);
			
			while(matcher.find()){
				String actualURL = matcher.group();
				if(!discoveredWebSitesList.contains(actualURL)){
					discoveredWebSitesList.add(actualURL);
					System.out.println("##"  +actualURL);
					queue.add(actualURL);
				}
					
			}
			
		}

	}

	public String readURL(String siteURL){
		String rowHtml = "";
		try {
			URL url = new URL(siteURL);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String input="";
			while((input = in.readLine()) !=null){
				rowHtml= rowHtml+input;
			} 
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowHtml;
	}

}
