import javax.net.ssl.HostnameVerifier;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;


import java.util.ArrayList;
import java.util.HashMap;

public class Main  {
	
	public static String searchString;
	

	public Main(String searchKeyword)

	{
		Main.searchString = searchKeyword;
	}

	public static headerlist main() throws Exception {
		System.out.println("Start Searching!");
		// TODO Auto-generated method stub
	    ArrayList<Keyword> keywords = new ArrayList<Keyword>();
		keywords.add(new Keyword("statistics", 1));
		keywords.add(new Keyword("統計", 1));
		keywords.add(new Keyword("analytics", 1));
		keywords.add(new Keyword("分析", 1));
		keywords.add(new Keyword("quantitative", 1));
		keywords.add(new Keyword("量化", 1));
		keywords.add(new Keyword("analysis", 1));
		keywords.add(new Keyword("database", 1));
		keywords.add(new Keyword("資料庫", 1));
		keywords.add(new Keyword("machine learning", 1));
		keywords.add(new Keyword("python", 0.8));
		keywords.add(new Keyword("R language", 0.8));
		keywords.add(new Keyword("case", 0.4));
		keywords.add(new Keyword("個案", 0.4));
		keywords.add(new Keyword("工作", 0.4));
		keywords.add(new Keyword("job", 0.4));
		keywords.add(new Keyword("study", 0.4));
		keywords.add(new Keyword("self-study", 0.4));
		keywords.add(new Keyword("自學", 0.4));
		keywords.add(new Keyword("visualization", 0.4));
		keywords.add(new Keyword("database", 0.8));
		keywords.add(new Keyword("視覺化", 0.4));
		keywords.add(new Keyword("roadmap", 0.8));
		keywords.add(new Keyword("Tableau", 0.8));
		keywords.add(new Keyword("SQL", 0.8));


	   searchString = searchString.replace(" ", "+");
	   lcs recommend = new lcs(keywords, searchString);
	   String recommend_key = recommend.rank();
//	   System.out.println(recommend_key);
	   
	   headerlist ans=new headerlist();
	   GoogleQuery g =new GoogleQuery(searchString);
	   
	   HashMap<String, String> results = g.query();
	   
		try {
			for (  String key : results.keySet()) {
//				System.out.println(key);
//			    System.out.println( results.get(key).substring(7) );
				try {
			    WebPage rootPage = new WebPage(results.get(key).substring(7),key);	
			    WebTree tree=new WebTree(rootPage);
				
			    
			    //while還有子頁面,addchild
			    Query child = new Query(results.get(key).substring(7));
			    HashMap<String, String> childmap = child.query();
//			    System.out.println(childmap.size());
			    
			    for(String childkey:childmap.keySet()) {
			    	tree.root.addChild(new WebNode(new WebPage(childmap.get(childkey),childkey)));
			    }
			    
				//計算並輸出
				tree.setPostOrderScore(keywords);
				tree.eularPrintTree();
				//System.out.println(tree.root.nodeScore);
				ans.add(new header(key, results.get(key).substring(7), tree.root.nodeScore));
				}
				catch(Exception e) {
					continue;
				}
				

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		//排序
		System.out.println(ans.size());
//		ans.output();
		ans.sort();
		ans.addfirst(new header("Do you want to search: "+recommend_key+" ?", "http://www.google.com/search?q="+recommend_key+"&oe=utf8&num=30", 9999));
//		ans.output();
		System.out.println("Done!");
		return ans;
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