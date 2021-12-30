import javax.net.ssl.HostnameVerifier;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		headerlist ans=new headerlist();
		try {
//			System.out.println(new GoogleQuery("NCCU").query());
			GoogleQuery g =new GoogleQuery("NCCU");
		//	g.query();
			//String key : g.query().keySet()
			//int j=1;j<=g.query().size();j++
			HashMap<String, String> results = g.query();
			for (  String key : results.keySet()) {
				System.out.println(key);
				//System.out.print(g.query().size());
			    //System.out.println( g.query().get(key).substring(7) );
				try {
			    WebPage rootPage = new WebPage(results.get(key).substring(7),key);	
			    WebTree tree=new WebTree(rootPage);
				
			    
			    //while還有子頁面,addchild
			    Query child = new Query(results.get(key).substring(7));
			    HashMap<String, String> childmap = child.query();
			    System.out.println(childmap.size());
			    
			    for(String childkey:childmap.keySet()) {
			    	//System.out.print(childkey);
			    	tree.root.addChild(new WebNode(new WebPage(childmap.get(key),childkey)));
			    	try {
			    	//tree.root.addChild(new WebNode(new WebPage(childmap.get(key),childkey)));
			    	} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			  
			    }
			    
				
				
		    	//掃過一次原始碼抓子網頁:
		    	
		    	//  2 NCCU 1.5 school 1.2
		    	// keyword可以改成事先輸入的
			    ArrayList<Keyword> keywords = new ArrayList<Keyword>();
			    String name = "NCCU";//Yu
				double weight = 1.5;//1.2
			    Keyword k = new Keyword(name, weight);
			    keywords.add(k);
			    String nam = "school";//Yu
				double weigh = 1.2;//1.2
			    Keyword a = new Keyword(nam, weigh);
			    keywords.add(a);
//			    Scanner scanner = new Scanner(System.in);
//				while(scanner.hasNextLine()){
//					int numOfKeywords = scanner.nextInt();//2
//					ArrayList<Keyword> keywords = new ArrayList<Keyword>();
						
					
//					for(int i =0;i<numOfKeywords;i++)
//					{
//						String name = scanner.next();//Yu
//						double weight = scanner.nextDouble();//1.2
//						Keyword k = new Keyword(name, weight);//store key
//						keywords.add(k);
//					}
				
				
				//計算並輸出
				tree.setPostOrderScore(keywords);
				System.out.println(tree.root.nodeScore);
				System.out.println("\n");
				ans.add(new header(key, tree.root.nodeScore));
				}
				catch(Exception e) {
					continue;
				}
				//scanner.close();
				
				
				
							 			    
			   
		//	    System.out.print(retVal);			 
			//}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//排序
		System.out.println(ans.size());
		ans.output();
		ans.sort();
		ans.output();
	}
	
	static {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() 
        {
            public boolean verify(String hostname,SSLSession session) 
            {
                return true;
            }
        });
    }
}

	

