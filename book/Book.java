package book;

public class Book {
	   public int id ;
	   public String name ; 
	   public int state ; 
	   
	   public  String  toString (){
		  	
			  String stateName = "";
			  if (this.state==1) {
				  stateName="�ɽ���";
			  } else {
					stateName="���ɽ���";	
				}
		return this.id +"\t\t"+this .name+"\t\t"+stateName;
	   }
	   public  String  toStrings (){
		  	
			  String stateName = "";
			  if (this.state==0) {
				  stateName="�ѽ���";
			  } else {
					stateName="δ����";	
				}
		return this.id +"\t\t"+this .name+"\t\t"+stateName;
	   }
}
