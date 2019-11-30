package book;

public class Book {
	   public int id ;
	   public String name ; 
	   public int state ; 
	   
	   public  String  toString (){
		  	
			  String stateName = "";
			  if (this.state==1) {
				  stateName="¿É½èÔÄ";
			  } else {
					stateName="²»¿É½èÔÄ";	
				}
		return this.id +"\t\t"+this .name+"\t\t"+stateName;
	   }
	   public  String  toStrings (){
		  	
			  String stateName = "";
			  if (this.state==0) {
				  stateName="ÒÑ½èÔÄ";
			  } else {
					stateName="Î´½èÔÄ";	
				}
		return this.id +"\t\t"+this .name+"\t\t"+stateName;
	   }
}
