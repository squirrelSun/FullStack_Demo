package ProxyMethod.staticProxy;

//代理类，静态代理
public class TeacherDaoProxy implements ITeacherDao {

	private ITeacherDao target; // 目标对象，通过接口来聚合

	// 构造器
	public TeacherDaoProxy(ITeacherDao target) {
		this.target = target;
	}

	@Override
	public void teach() {
		// TODO Auto-generated method stub
		System.out.println("开始代理");// 方法
		target.teach();
		System.out.println("结束代理");// 方法
	}

}
