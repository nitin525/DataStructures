package graphProperPractice.webCrawler;

public class app {

	
	public static void main(String[] args) {
		
		WebCrawler wc = new WebCrawler();
		wc.discoverWeb("https://www.youtube.com");
	}
}
