package book;

public class Book {
	   public int id ;
	   public String name ; 
	   public int state ; 
	   
	   public  String  toString (){
		  	
			  String stateName = "";
			  if (this.state==1) {
				  stateName="可借阅";
			  } else {
					stateName="不可借阅";	
				}
		return this.id +"\t\t"+this .name+"\t\t"+stateName;
	   }
	   public  String  toStrings (){
		  	
			  String stateName = "";
			  if (this.state==0) {
				  stateName="已借阅";
			  } else {
					stateName="未借阅";	
				}
		return this.id +"\t\t"+this .name+"\t\t"+stateName;
	   }
}
