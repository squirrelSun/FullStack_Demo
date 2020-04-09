package ResponsibilitychainMethod;

public class Client {

	public static void main(String[] args) {
		// 创建一个请求
		PurchaseRequest purchaseRequest1 = new PurchaseRequest(1, 31000, 1);
		PurchaseRequest purchaseRequest2 = new PurchaseRequest(1, 1000, 2);

		// 创建相关的审批人
		DepartmentApprover departmentApprover = new DepartmentApprover("主任");
		CollegeApprover collegeApprover = new CollegeApprover("院长");
		ViceSchoolMasterApprover viceSchoolMasterApprover = new ViceSchoolMasterApprover("副校");
		SchoolMasterApprover schoolMasterApprover = new SchoolMasterApprover("校长");
		// 需要将各个审批级别的下一个设置好 （构建职责链）
		departmentApprover.setApprover(collegeApprover);
		collegeApprover.setApprover(viceSchoolMasterApprover);
		viceSchoolMasterApprover.setApprover(schoolMasterApprover);
		schoolMasterApprover.setApprover(departmentApprover);

		
		departmentApprover.processRequest(purchaseRequest1);
		viceSchoolMasterApprover.processRequest(purchaseRequest2);
	}

}
