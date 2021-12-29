import java.util.ArrayList;

public class KeywordList {
	private ArrayList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new ArrayList<Keyword>();
    }
	
	public void add(Keyword keyword){
		lst.add(keyword);
//		System.out.println("Done");
    }
	
	//quick sort
	public void sort(){
		if(lst.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else 
		{
			quickSort(0, lst.size()-1);
//			System.out.println("Done");
		}

	}
	
	
	private void quickSort(int leftbound, int rightbound){
		//1. implement quickSort algorithm	
		if (leftbound>=rightbound)return;
		int pivot=rightbound;
		int j=leftbound;
		int k=rightbound-1;
		while(j<k) {
			while(lst.get(j).count<pivot) {
				j++;
			}
			while(lst.get(k).count>pivot) {
				k--;
			}
			if(j<k) {
				swap(j,k);
			}
		}
		swap(pivot,j);
		quickSort(leftbound,j-1);
		quickSort(j+1,rightbound);

	}

	
	
	private void swap(int aIndex, int bIndex){
		Keyword temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	
	public void output(){
		//TODO: write output and remove all element logic here...
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<lst.size();i++){
			Keyword k = lst.get(i);
			if(i>0)sb.append(" ");
			sb.append(k.toString());
		}
		
		System.out.println(sb.toString());	
	}
	public void find(String s){
		int maxValue = -1;
		int maxIndex = -1;
		for(int i=0; i<lst.size(); i++){
			int lcs = findLCS(lst.get(i).name, s);
//			System.out.println(lcs);
			if(lcs > maxValue){
				maxValue = lcs;
				maxIndex = i;
			}
		}
		System.out.println(s+": "+lst.get(maxIndex).toString());
	}
	
	public int findLCS(String x, String y){
		//1. fill this method
		int[][] q;
		int a=x.length();
		int b=y.length();
		q=new int[a+1][b+1];
		int i;
		int j;
		for (i=0;i<a;i++) {
			q[i][0]=0;
		}
		for(j=0;j<b;j++) {
			q[0][j]=0;
		}
		for (i=0;i<a;i++) {
			for(j=0;j<b;j++) {
				if (x.charAt(i)==y.charAt(j)){
					q[i+1][j+1]=q[i][j]+1;
				}
				else {
					q[i+1][j+1]=Math.max(q[i+1][j],q[i][j+1]);
				}
			}
		}
		return q[a][b];
	}
	
	private void printMatrix(int[][] matrix){
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				System.out.print(matrix[i][j] + " ");
				if(j==matrix[0].length-1)System.out.print("\n");
			}
		}
	}
}
