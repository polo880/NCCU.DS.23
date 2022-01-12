import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.net.URL;

import java.net.URLConnection;

import java.util.HashMap;



import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class Query {

	public String url;

	public String content;

	public Query(String URL)

	{


		this.url = URL;

	}

	

	private String fetchContent() throws IOException

	{
		String retVal = "";

		URL u = new URL(url);

		URLConnection conn = u.openConnection();
		conn.setConnectTimeout(1000);
		conn.setReadTimeout(5000);
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");

		InputStream in = conn.getInputStream();

		InputStreamReader inReader = new InputStreamReader(in,"utf-8");

		BufferedReader bufReader = new BufferedReader(inReader);
		String line = null;

		while((line=bufReader.readLine())!=null)
		{
			retVal += line;

		}
		return retVal;
	}
	public HashMap<String, String> query() throws IOException

	{

		if(content==null)

		{

			content= fetchContent();

		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		
		Document doc = Jsoup.parse(content);
//		System.out.println(doc.text());
		Elements lis = doc.select("div");
//		System.out.println(lis);
	//	lis = lis.select(".kCrYT");
//		System.out.println(lis.size());
		lis = lis.select("a");
//		System.out.println(lis);
		
		int title = 0;
		
		for(Element li : lis)
		{
			try 
			{
//				System.out.println(li);
//				String citeUrl = li.select("a").get(0).attr("href");
				String citeUrl = li.attr("href");
				if (citeUrl.startsWith("http")) {
					title ++;
//					System.out.println(citeUrl);
					retVal.put(Integer.toString(title), citeUrl);
					if (title >= 10) {
						break;
					}
				}
				else {
					continue;
				}
//				System.out.println(citeUrl);
		//		String title = li.select("a").get(0).select(".vvjwJb").text();
		//		if(title.equals("")) {
		//			continue;
		//		}
		//		System.out.println(title + ","+citeUrl);

				
//				System.out.println(retVal.size());

			} catch (IndexOutOfBoundsException e) {

				e.printStackTrace();

			}

			

		}
		
		//for ( String key : retVal.keySet() ) {
		  //  System.out.println( retVal.get(key).substring(7) );
		//}

		return retVal;

	}


}
