package book;
import java.util.Scanner;


public class Menu {
     Scanner scan=new Scanner(System.in);
     Admain admain=new Admain();
     Data data=new Data();
     Book[] books=new Book[50];
     Book[] browsers = new Book[50];
 	 int iddown = 0;

public void chuanData(){
	 books=data.init();
}
     
public void welcome(){
	System.out.println("\t欢迎来到 MIUI图书管理系统\n");
	System.out.println("--------------------------------\n");
	System.out.println("\t1. 登  录  系  统\n");
	System.out.println("\t2. 退  出\n");
	System.out.println("--------------------------------\n");
	System.out.println("请输入数字：\n");
	int ok=scan.nextInt();
	for (int i = 0; i < 1; i--) {
	switch (ok) {
	case 1:
		this.login();
		break;
    case 2:
    	System.out.println("谢谢使用 MIUI图书管理系统 ");
		System.exit(0);
		break;
	default:
		System.out.println("输入错误，请重新输入编号");
		ok=scan.nextInt();
	}
  }
}


public void login(){
	int count=3;
	boolean flag=true;
	do {
		System.out.println("\t欢迎来到 MIUI图书管理系统--登陆界面\n");
		System.out.println("-------------------------------------------------\n");
		System.out.println("请输入用户名:");
		String uname=scan.next();
		System.out.println("请输入密码：");
		String upass=scan.next();
		if (uname.equals(admain.userName)&&upass.equals(admain.password)) {
			this.admainMenu();
			flag=false;
			break;
		} else {
                count--;
                if (count==0) {
					System.out.println("您今日登录次数已达上限，请明天再试！");
					System.exit(0);
				} else {
                    System.out.println("您今日输入机会还剩"+count+ "次机会!\n");
				}
		}
	} while (flag);
}

public void admainMenu(){
	System.out.println("\t欢迎 MIUI图书管理系统 >> 主菜单\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("\t\t1. 浏  览  图  书\n");
	System.out.println("\t\t2. 借  阅  图  书\n");
	System.out.println("\t\t3. 归  还  图  书\n");
	System.out.println("\t\t4. 填  加  图  书\n");
	System.out.println("\t\t5. 查  找  图  书\n");
	System.out.println("\t\t6. 借  阅  明  细\n");
	System.out.println("\t\t7. 删  除  图  书\n");
	System.out.println("\t\t8. 修  改  图  书\n");
	System.out.println("\t\t9. 退             出\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("请选择，输入数字 ：\n");
	int MIUI = scan.nextInt();

	switch (MIUI) {
	case 1:this.readBook();
		break;
	case 2:this.getBook();
		break;
	case 3:this.backBook();
		break;
	case 4:this.addBook();
		break;
	case 5:this.findBook();
		break;
	case 6:this.Borrow();
		break;
	case 7:this.removeBook();
		break;
	case 8:this.amendBook();
		break;
	case 9:
		System.out.println("谢谢使用 MIUI图书管理系统 ");
		System.exit(0);
		break;
	default:
		System.out.println("输入错误，请重新输入编号");
		this.admainMenu();
	}
  }
//1
public void readBook(){
    
	
	System.out.println("\t欢迎 MIUI图书管理系统 >> 浏览图书\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("图书编号\t\t图书名称\t\t图书状态\n");
	for (int i = 0; i < books.length; i++) {
	    if(books[i] != null) {
		      System.out.println(books[i].toString());
	    }  
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("按任意键返回上一级：");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//2
public void getBook(){
	System.out.println("\t欢迎 MIUI图书管理系统 >> 借阅图书\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("请输入借阅图书编号：\n");
	int id=scan.nextInt();
	boolean flag = true;
	for (int i = 0; i < books.length; i++) {			
        if ( books[i]!=null) {
			if (books[i].id == id) {
				if (books[i].state == 1) {
					System.out.println("借阅 《" + books[i].name + "》成功!");
					books[i].state = 0;
					browsers[iddown++] = books[i];
					flag = false;
					break;
				}
				else {
					flag = false;
					System.out.println("该《" + books[i].name + "》已被借出，当前不可借阅!");
					break;
				}

			}
		}			
	}
	if (flag) {

		System.out.println("抱歉！该书不存在，无法借阅！");
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("按任意键返回主界面：");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//3
public void backBook(){
	System.out.println("\t欢迎 MIUI图书管理系统 >> 归还图书\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("请输入归还图书编号：\n");
	int id=scan.nextInt();
	boolean flag = true;
	for (int i = 0; i < books.length; i++) {			
        if ( books[i]!=null) {
			if (books[i].id == id) {
				if (books[i].state == 0) {
					System.out.println("归还 《" + books[i].name + "》成功!");
					books[i].state = 1;
					browsers[iddown++] = books[i];
					flag = false;
					break;
				}
				else {
					flag = false;
					System.out.println("该《" + books[i].name + "》尚未被借阅，无需归还!");
					break;
				}

			}
		}			
	}
	if (flag) {
		System.out.println("抱歉！该书不存在");
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("按任意键返回主界面：");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//4
public void addBook(){
	System.out.println("\t欢迎 MIUI图书管理系统 >> 添加图书\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("请输入新添加图书名称：");
	String bookName=scan.next();
	System.out.println("请选择新图书状态：( 0.不可借阅    1.可借阅   )\n");
	int state = scan.nextInt();
	for (int i = 0; i < books.length; i++) {
		if (books[i]==null) {
			Book book=new Book();
			book.name=bookName;
			book.state=state;
			book.id=i+1;
			books[i]=book;
			System.out.println("添加新图书《" + book.name + "》成功!");
			break;
		}
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("按任意键返回主界面：");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//5
public void findBook(){
	System.out.println("\t欢迎 MIUI图书管理系统 >> 查找图书\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("\t请输入所查图书名称：");
	String bookName=scan.next();
	for (int i = 0; i < books.length;i++) {
	    if(books[i] == null) {
		      break;
	    }  
	    if (bookName.equals(books[i].name)) {
		      System.out.println("图书编号\t\t图书名称\t\t图书状态\n");
		      System.out.println(books[i].toString());
		      break;
	    } else {
              System.out.println("查无此书，查询失败！");
              break;
	    }
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("按任意键返回主界面：");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//6
public void Borrow(){
	System.out.println("\t欢迎 MIUI图书管理系统 >> 借阅明细\n");
	System.out.println("----------------------------------------------\n");
	boolean flag = true;
	for (int i = 0; i < books.length; i++) {
	    if(books[i] == null) {
		      break;
	    }
	    if (books[i].state == 0) {
			System.out.println("\t\t已借阅图书：\n");
			System.out.println("图书编号\t\t图书名称\t");
			System.out.println(books[i].toStrings());
			flag = false;
			break;
	    }
	}  
	if (flag) {
		System.out.println("暂无图书借阅记录！");
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("按任意键返回主界面：");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//7
public void removeBook(){
	System.out.println("\t欢迎 MIUI图书管理系统 >> 删除图书\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("\t请输入删除图书名称：");
	String bookName=scan.next();
	for (int i = 0; i < books.length; i++) {
	    if(books[i] == null) {
		      break;
	    }  
	    if (bookName.equals(books[i].name)) {
		      System.out.println("图书编号\t\t图书名称\t\t图书状态\n");
		      System.out.println(books[i].toString()+"\n");
		      System.out.println("确定删除《"+books[i].name+"》?\n");
		      System.out.println("\t1.确认"+"\t2.取消\n");
		      int b=scan.nextInt();
		      switch (b) {
			case 1:
				if (books[i].state == 1) {
					System.out.println("删除《" + books[i].name + "》成功");
					books[i] = null;
					break;
				} else {
					System.out.println("该书《" + books[i].name+ "》正在借阅中，无法删除！");
                    break;
				}
            case 2:
				System.out.println("放弃删除《"+books[i].name+"》，自动返回上一级");
				this.removeBook();
				break;
			default:
				System.out.println("删除失败，自动返回上一级");
				this.removeBook();
				break;
			}
		      break;
	    } else {
              System.out.println("查无此书，删除失败！");
              break;
	    }
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("按任意键返回主界面：");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//8
public void amendBook(){
	System.out.println("\t欢迎 MIUI图书管理系统 >> 修改图书\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("请输入修改图书编号：");
	int ids=scan.nextInt();
	int i = 0;
	for (  ; i < books.length; i++) {
	    if(books[i] == null) {
		    break;
	    }  
	    if (ids==books[i].id) {
			System.out.println("所选图书当前信息为：\n");
			System.out.println("图书编号\t\t图书名称\t\t图书状态\n");
			System.out.println(books[i].toString()+"\n");
			System.out.println("请选择修改信息：(1.图书名称      2.图书状态)");
			int b=scan.nextInt();
			switch (b) {
			case 1:
				this.amendBookNAame();
				break;
            case 2:
            	System.out.println("请选择新的图书状态：( 0.不可借阅    1.可借阅   )\n");
            	int state = scan.nextInt();
            	books[i].state=state;
            	System.out.println("修改成功！");
				break;
			default:
				System.out.println("输入错误选项编号，默认返回主界面！");
				this.admainMenu();
				break;
			}
		}
	}
  }
public void amendBookNAame(){
	int i = 0;
	for (  ; i < books.length; i++) {
	    if(books[i] == null) {
		    break;
	    } 
	System.out.println("请输入新的图书名称：");
	String newName=scan.next();
	for ( int j = 0; j < books.length; j++) {
	    if(newName.equals(books[i].name)) {
		   System.out.println("新输入图书名称与原有图书名称重复，修改失败！");
		   this.admainMenu();
		   break;
	    } else{
	    	i++;
	    	break;
	      }
	    }
	    books[i].name=newName;
		System.out.println("书名修改成功！");
		System.out.println("图书当前信息为：\n");
		System.out.println("图书编号\t\t图书名称\t\t图书状态\n");
		System.out.println(books[i].toString()+"\n");
		System.out.println("----------------------------------------------\n");
		System.out.println("按任意键返回主界面：");
		String a=scan.next();
		if (a!=null) {
			this.admainMenu();
		}
	}
  }
}