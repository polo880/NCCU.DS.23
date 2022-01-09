public class header {
	
	public String name;
	public String url;
    public double count;

    

    public header(String name, String url, double count){
    	// TODO Auto-generated constructor stub
		this.name = name;
		this.url = url;
		this.count =count;
    }




	@Override
    public String toString(){
    	return "["+name+","+count+"]";
    }
    
//    public void add_url(String url) {
//    	this.url = url;
//    }
}