import javax.net.ssl.HostnameVerifier;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	    ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		keywords.add(new Keyword("statistics", 1));
		keywords.add(new Keyword("analytics", 1));
		keywords.add(new Keyword("quantitative", 1));
		keywords.add(new Keyword("analysis", 1));
		keywords.add(new Keyword("machine learning", 1));
		keywords.add(new Keyword("BA", 0.8));
		keywords.add(new Keyword("BI", 0.8));
		keywords.add(new Keyword("R", 0.8));
		keywords.add(new Keyword("python", 0.8));
		keywords.add(new Keyword("case", 0.4));
		keywords.add(new Keyword("study", 0.4));
		keywords.add(new Keyword("self-study", 0.4));
		keywords.add(new Keyword("analytics", 0.4));
		keywords.add(new Keyword("visualization", 0.6));
		keywords.add(new Keyword("database", 0.8));
		keywords.add(new Keyword("visualization", 0.6));
		keywords.add(new Keyword("roadmap", 0.8));
		keywords.add(new Keyword("AI", 0.8));
		keywords.add(new Keyword("Tableau", 0.8));
		keywords.add(new Keyword("SQL", 0.8));
	    
	   Scanner scanner = new Scanner(System.in);
	   String searchString = scanner.nextLine();
	   scanner.close();
	   searchString = searchString.replace(" ", "+");
	
	   headerlist ans=new headerlist();
	   //System.out.print(searchString);
	   GoogleQuery g =new GoogleQuery(searchString);
	   
	   HashMap<String, String> results = g.query();
	   //System.out.print(results.size());
	
		try {
			for (  String key : results.keySet()) {
				System.out.println(key);
				//System.out.print(g.query().size());
			    System.out.println( g.query().get(key).substring(7) );
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
			    }
	
				//計算並輸出
				tree.setPostOrderScore(keywords);
				System.out.println(tree.root.nodeScore);
				ans.add(new header(key, tree.root.nodeScore));
				}
				catch(Exception e) {
					//e.printStackTrace();
					continue;
				}
				//scanner.close();
				

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		//排序
		System.out.println(ans.size());
		ans.output();
		ans.sort();
		ans.output();
		Iterator<header> iter  = ans.lst.iterator(); 
		while (iter.hasNext()) { 
	    header next = iter.next();
		System.out.print(results.get(next.name).substring(7)+"\n"); 
		}
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

	