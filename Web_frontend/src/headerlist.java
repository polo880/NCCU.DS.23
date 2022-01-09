import java.util.ArrayList;

public class headerlist {
	public ArrayList<header> lst;
	
	public headerlist(){
		this.lst = new ArrayList<header>();
    }
	
	
	public void add(header header){
		lst.add(header);
//		System.out.println("Done");
    }
	
	public void addfirst(header recommend) {
		lst.add(recommend);
		for(int i=0; i<lst.size()-1;i++){
			swap(lst.size()-1-i, lst.size()-i-2);
		}
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
		  //1. implement quickSort algorith
		  if(leftbound >= rightbound) {
		   return;
		  } else {
		  double pivot = lst.get(rightbound).count;
		  int j = leftbound;
		  int k = rightbound-1;
		  
		  while(j < k) {
		   while(lst.get(j).count >= pivot & j < k) {
		    j++;
		   }
		   while(lst.get(k).count < pivot & j < k) {
		    k--;
		   }
		   swap(j, k);
		  }
		  if(lst.get(j).count < pivot) {
		  swap(j, rightbound);} else {
		  quickSort(leftbound, j);
		  quickSort(j+1, rightbound);
		  }
		  quickSort(leftbound, j-1);
		  quickSort(j+1, rightbound);
		  }
		 }




	
	
	private void swap(int aIndex, int bIndex){
		header temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}
	
	public void output(){
		//TODO: write output and remove all element logic here...
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<lst.size();i++){
			header k = lst.get(i);
			if(i>0)sb.append(" ");
			sb.append(k.toString());
		}
		
		System.out.println(sb.toString());	
	}


	public int size() {
		return this.lst.size();
	}
}
