package ProxyMethod.staticProxy;

//被代理类
public class TeacherDao implements ITeacherDao {

	@Override
	public void teach() {
		// TODO Auto-generated method stub
		System.out.println(" 老师授课中  。。。。。");
	}

}