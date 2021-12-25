import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class test_main {
	public static void main(String[] args) throws IOException {
		//hw3
		System.out.println("Please type: URL Keyword");
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
		    String urlStr = sc.next();
		    String keyword = sc.next();
		   
		    WordCounter counter = new WordCounter(urlStr);
		    System.out.println(counter.countKeyword(keyword));
		}
		//hw6,作業是用事先預定好的網址,這裡應該是用google抓進來的
		Scanner scanner = new Scanner(System.in);
		
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
			
			tree.setPostOrderScore(keywords);
			tree.eularPrintTree();
		}
		scanner.close();	
		//hw8
		lst.sort();
		
		
	}

}
