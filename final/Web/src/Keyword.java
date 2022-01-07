public class Keyword {
	public String name;
    public double weight;
    public int count;
    

    public Keyword(String name,double weight){
		this.name = name;
		this.weight = weight;
	}
    public Keyword(String name,int count){
		this.name = name;
		this.count =count;
    }

    @Override
    public String toString(){
    	return "["+name+","+weight+"]";
    }
}
