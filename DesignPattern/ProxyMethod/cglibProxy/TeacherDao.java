package ProxyMethod.cglibProxy;

public class TeacherDao {

	public String teach() {
		System.out.println(" 老师授课中  ，cglib代理");
		return "hello";
	}

}