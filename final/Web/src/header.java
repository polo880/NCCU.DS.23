public class header {
	public String name;
    public double count;
    


    public header(String name,double count){
		this.name = name;
		this.count =count;
    }

    @Override
    public String toString(){
    	return "["+name+","+count+"]";
    }
}