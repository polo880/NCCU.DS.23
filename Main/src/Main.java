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
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		try {
//			System.out.println(new GoogleQuery("NCCU").query());
			GoogleQuery g =new GoogleQuery("NCCU");
		//	g.query();
			for ( String key : g.query().keySet() ) {
			    //System.out.println( g.query().get(key).substring(7) );
			    WebPage rootPage = new WebPage(g.query().get(key).substring(7), g.query().keySet().toString());	
			    WebTree tree=new WebTree(rootPage);
			    
			    //while還有子頁面,addchild
			    
			    
		    	//掃過一次原始碼抓子網頁:
		    	Scanner scanner = new Scanner(System.in);
		    	//  2 NCCU 1.5 school 1.2
		    	// keyword可以改成事先輸入的
				
				while(scanner.hasNextLine()){
					int numOfKeywords = scanner.nextInt();//2
					ArrayList<Keyword> keywords = new ArrayList<Keyword>();
						
					for(int i =0;i<numOfKeywords;i++)
					{
						String name = scanner.next();//Yu
						double weight = scanner.nextDouble();//1.2
						Keyword k = new Keyword(name, weight);//store key
						keywords.add(k);
					}
				//計算並輸出
					tree.setPostOrderScore(keywords);
					tree.eularPrintTree();
				}
				scanner.close();
				
			    
			    
			   
		//	    System.out.print(retVal);			 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//排序
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

	

