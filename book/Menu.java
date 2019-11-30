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
	System.out.println("\t��ӭ���� MIUIͼ�����ϵͳ\n");
	System.out.println("--------------------------------\n");
	System.out.println("\t1. ��  ¼  ϵ  ͳ\n");
	System.out.println("\t2. ��  ��\n");
	System.out.println("--------------------------------\n");
	System.out.println("���������֣�\n");
	int ok=scan.nextInt();
	for (int i = 0; i < 1; i--) {
	switch (ok) {
	case 1:
		this.login();
		break;
    case 2:
    	System.out.println("ллʹ�� MIUIͼ�����ϵͳ ");
		System.exit(0);
		break;
	default:
		System.out.println("�������������������");
		ok=scan.nextInt();
	}
  }
}


public void login(){
	int count=3;
	boolean flag=true;
	do {
		System.out.println("\t��ӭ���� MIUIͼ�����ϵͳ--��½����\n");
		System.out.println("-------------------------------------------------\n");
		System.out.println("�������û���:");
		String uname=scan.next();
		System.out.println("���������룺");
		String upass=scan.next();
		if (uname.equals(admain.userName)&&upass.equals(admain.password)) {
			this.admainMenu();
			flag=false;
			break;
		} else {
                count--;
                if (count==0) {
					System.out.println("�����յ�¼�����Ѵ����ޣ����������ԣ�");
					System.exit(0);
				} else {
                    System.out.println("������������ỹʣ"+count+ "�λ���!\n");
				}
		}
	} while (flag);
}

public void admainMenu(){
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> ���˵�\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("\t\t1. �  ��  ͼ  ��\n");
	System.out.println("\t\t2. ��  ��  ͼ  ��\n");
	System.out.println("\t\t3. ��  ��  ͼ  ��\n");
	System.out.println("\t\t4. ��  ��  ͼ  ��\n");
	System.out.println("\t\t5. ��  ��  ͼ  ��\n");
	System.out.println("\t\t6. ��  ��  ��  ϸ\n");
	System.out.println("\t\t7. ɾ  ��  ͼ  ��\n");
	System.out.println("\t\t8. ��  ��  ͼ  ��\n");
	System.out.println("\t\t9. ��             ��\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("��ѡ���������� ��\n");
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
		System.out.println("ллʹ�� MIUIͼ�����ϵͳ ");
		System.exit(0);
		break;
	default:
		System.out.println("�������������������");
		this.admainMenu();
	}
  }
//1
public void readBook(){
    
	
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> ���ͼ��\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("ͼ����\t\tͼ������\t\tͼ��״̬\n");
	for (int i = 0; i < books.length; i++) {
	    if(books[i] != null) {
		      System.out.println(books[i].toString());
	    }  
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("�������������һ����");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//2
public void getBook(){
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> ����ͼ��\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("���������ͼ���ţ�\n");
	int id=scan.nextInt();
	boolean flag = true;
	for (int i = 0; i < books.length; i++) {			
        if ( books[i]!=null) {
			if (books[i].id == id) {
				if (books[i].state == 1) {
					System.out.println("���� ��" + books[i].name + "���ɹ�!");
					books[i].state = 0;
					browsers[iddown++] = books[i];
					flag = false;
					break;
				}
				else {
					flag = false;
					System.out.println("�á�" + books[i].name + "���ѱ��������ǰ���ɽ���!");
					break;
				}

			}
		}			
	}
	if (flag) {

		System.out.println("��Ǹ�����鲻���ڣ��޷����ģ�");
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("����������������棺");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//3
public void backBook(){
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> �黹ͼ��\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("������黹ͼ���ţ�\n");
	int id=scan.nextInt();
	boolean flag = true;
	for (int i = 0; i < books.length; i++) {			
        if ( books[i]!=null) {
			if (books[i].id == id) {
				if (books[i].state == 0) {
					System.out.println("�黹 ��" + books[i].name + "���ɹ�!");
					books[i].state = 1;
					browsers[iddown++] = books[i];
					flag = false;
					break;
				}
				else {
					flag = false;
					System.out.println("�á�" + books[i].name + "����δ�����ģ�����黹!");
					break;
				}

			}
		}			
	}
	if (flag) {
		System.out.println("��Ǹ�����鲻����");
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("����������������棺");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//4
public void addBook(){
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> ���ͼ��\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("�����������ͼ�����ƣ�");
	String bookName=scan.next();
	System.out.println("��ѡ����ͼ��״̬��( 0.���ɽ���    1.�ɽ���   )\n");
	int state = scan.nextInt();
	for (int i = 0; i < books.length; i++) {
		if (books[i]==null) {
			Book book=new Book();
			book.name=bookName;
			book.state=state;
			book.id=i+1;
			books[i]=book;
			System.out.println("�����ͼ�顶" + book.name + "���ɹ�!");
			break;
		}
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("����������������棺");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//5
public void findBook(){
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> ����ͼ��\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("\t����������ͼ�����ƣ�");
	String bookName=scan.next();
	for (int i = 0; i < books.length;i++) {
	    if(books[i] == null) {
		      break;
	    }  
	    if (bookName.equals(books[i].name)) {
		      System.out.println("ͼ����\t\tͼ������\t\tͼ��״̬\n");
		      System.out.println(books[i].toString());
		      break;
	    } else {
              System.out.println("���޴��飬��ѯʧ�ܣ�");
              break;
	    }
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("����������������棺");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//6
public void Borrow(){
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> ������ϸ\n");
	System.out.println("----------------------------------------------\n");
	boolean flag = true;
	for (int i = 0; i < books.length; i++) {
	    if(books[i] == null) {
		      break;
	    }
	    if (books[i].state == 0) {
			System.out.println("\t\t�ѽ���ͼ�飺\n");
			System.out.println("ͼ����\t\tͼ������\t");
			System.out.println(books[i].toStrings());
			flag = false;
			break;
	    }
	}  
	if (flag) {
		System.out.println("����ͼ����ļ�¼��");
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("����������������棺");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//7
public void removeBook(){
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> ɾ��ͼ��\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("\t������ɾ��ͼ�����ƣ�");
	String bookName=scan.next();
	for (int i = 0; i < books.length; i++) {
	    if(books[i] == null) {
		      break;
	    }  
	    if (bookName.equals(books[i].name)) {
		      System.out.println("ͼ����\t\tͼ������\t\tͼ��״̬\n");
		      System.out.println(books[i].toString()+"\n");
		      System.out.println("ȷ��ɾ����"+books[i].name+"��?\n");
		      System.out.println("\t1.ȷ��"+"\t2.ȡ��\n");
		      int b=scan.nextInt();
		      switch (b) {
			case 1:
				if (books[i].state == 1) {
					System.out.println("ɾ����" + books[i].name + "���ɹ�");
					books[i] = null;
					break;
				} else {
					System.out.println("���顶" + books[i].name+ "�����ڽ����У��޷�ɾ����");
                    break;
				}
            case 2:
				System.out.println("����ɾ����"+books[i].name+"�����Զ�������һ��");
				this.removeBook();
				break;
			default:
				System.out.println("ɾ��ʧ�ܣ��Զ�������һ��");
				this.removeBook();
				break;
			}
		      break;
	    } else {
              System.out.println("���޴��飬ɾ��ʧ�ܣ�");
              break;
	    }
	}
	System.out.println("----------------------------------------------\n");
	System.out.println("����������������棺");
	String a=scan.next();
	if (a!=null) {
		this.admainMenu();
	}
  }
//8
public void amendBook(){
	System.out.println("\t��ӭ MIUIͼ�����ϵͳ >> �޸�ͼ��\n");
	System.out.println("----------------------------------------------\n");
	System.out.println("�������޸�ͼ���ţ�");
	int ids=scan.nextInt();
	int i = 0;
	for (  ; i < books.length; i++) {
	    if(books[i] == null) {
		    break;
	    }  
	    if (ids==books[i].id) {
			System.out.println("��ѡͼ�鵱ǰ��ϢΪ��\n");
			System.out.println("ͼ����\t\tͼ������\t\tͼ��״̬\n");
			System.out.println(books[i].toString()+"\n");
			System.out.println("��ѡ���޸���Ϣ��(1.ͼ������      2.ͼ��״̬)");
			int b=scan.nextInt();
			switch (b) {
			case 1:
				this.amendBookNAame();
				break;
            case 2:
            	System.out.println("��ѡ���µ�ͼ��״̬��( 0.���ɽ���    1.�ɽ���   )\n");
            	int state = scan.nextInt();
            	books[i].state=state;
            	System.out.println("�޸ĳɹ���");
				break;
			default:
				System.out.println("�������ѡ���ţ�Ĭ�Ϸ��������棡");
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
	System.out.println("�������µ�ͼ�����ƣ�");
	String newName=scan.next();
	for ( int j = 0; j < books.length; j++) {
	    if(newName.equals(books[i].name)) {
		   System.out.println("������ͼ��������ԭ��ͼ�������ظ����޸�ʧ�ܣ�");
		   this.admainMenu();
		   break;
	    } else{
	    	i++;
	    	break;
	      }
	    }
	    books[i].name=newName;
		System.out.println("�����޸ĳɹ���");
		System.out.println("ͼ�鵱ǰ��ϢΪ��\n");
		System.out.println("ͼ����\t\tͼ������\t\tͼ��״̬\n");
		System.out.println(books[i].toString()+"\n");
		System.out.println("----------------------------------------------\n");
		System.out.println("����������������棺");
		String a=scan.next();
		if (a!=null) {
			this.admainMenu();
		}
	}
  }
}