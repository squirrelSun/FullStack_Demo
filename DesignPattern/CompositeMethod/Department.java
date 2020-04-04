package CompositeMethod;

//叶子节点
public class Department extends OrganizationComponent {

	public Department(String name, String des) {
		super(name, des);
		// TODO Auto-generated constructor stub
	}

	// 叶子节点不用写add , remove

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		return super.getDes();
	}

	@Override
	protected void print() {
		// TODO Auto-generated method stub
		System.out.println(getName());
	}

}