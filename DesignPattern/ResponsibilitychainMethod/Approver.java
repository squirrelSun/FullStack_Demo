package ResponsibilitychainMethod;

//抽象处理者
public abstract class Approver {

	Approver approver; // 后继处理者对象
	String name; // 当前处理者名字

	public Approver(String name) {
		this.name = name;
	}

	public void setApprover(Approver approver) {
		this.approver = approver;
	}

	// 处理审批请求的方法，得到一个请求，处理是子类完成，
	public abstract void processRequest(PurchaseRequest purchaseRequest);

}
