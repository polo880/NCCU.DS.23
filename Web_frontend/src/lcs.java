import java.util.ArrayList;

public class lcs{
	
	private ArrayList<Keyword> keywords;
	private String y;

	public lcs(ArrayList<Keyword>keywords,String y) {
		this.keywords = keywords;
		this.y = y;
	}
	
	public String rank() {
		
		 int maxValue = -1;
		 int maxIndex = -1;
		 int n=-1;
		 
	for(Keyword a  : keywords){	
		n=n+1;
		String x=a.name;
		int len1 = x.length();  
	    int len2 = y.length(); 
	    int c[][] = new int[len1+1][len2+1];  
	    for (int i = 0; i <= len1; i++) {  
	        for( int j = 0; j <= len2; j++) {  
	            if(i == 0 || j == 0) {  
	                c[i][j] = 0;  
	            } else if (x.charAt(i-1) == y.charAt(j-1)) {  
	                c[i][j] = c[i-1][j-1] + 1;  
	            } else {  
	                c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);  
	            }  
	        }  
	    }
	    int lcs = c[len1][len2];
	    if (len1 == lcs) {
//	    	System.out.println("hello");
	    	lcs = lcs-999;
	    }
	    if(lcs > maxValue){
			maxValue = lcs;
			maxIndex = n;
		}
	}
	if (maxValue == 0) {
		return("business analytics");
	}
	return keywords.get(maxIndex).name;
}
}
