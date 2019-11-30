package book;

public class Data {
      Book[] books=new Book[50];
      
      public Book[] init(){
    	  Book b1=new Book();
    	     b1.id=1;
    	     b1.name="数学分析";
    	     b1.state=1;
    	     books[0] = b1;
    	  Book b2=new Book();
    	     b2.id=2;
 	         b2.name="高等代数";
 	         b2.state=1;
 	         books[1] = b2;
    	  Book b3=new Book();
    	     b3.id=3;
 	         b3.name="解析几何";
 	         b3.state=1;
 	         books[2] = b3;
    	  Book b4=new Book();
    	     b4.id=4;
 	         b4.name="常微分方程";
 	         b4.state=1;
 	         books[3] = b4;
    	  Book b5=new Book();
    	     b5.id=5;
 	         b5.name="算法导论";
 	         b5.state=1;
 	         books[4] = b5;
    	  Book b6=new Book();
    	     b6.id=6;
 	         b6.name="粗糙集概论";
 	         b6.state=1;
 	         books[5] = b6;
 	      return books;
      }
}
