
public class Keyword {
	public String name;
    public int count;
    public double weight;
    
    public Keyword(String name,int count){
		this.name = name;
		this.count =count;
    }
    public Keyword(String name,double weight){
		this.name = name;
		this.weight = weight;
	}

    @Override
    public String toString(){
    	return "["+name+","+count+"]";
    }
}
