package team.view;

import team.domain.Employee;
import team.domain.Programmer;
import team.service.NameListService;
import team.service.TeamException;
import team.service.TeamService;

public class TeamView {

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {
		boolean flag=true;
		while (flag) {
			char menu = 0;
			listAllEmployee();
			if (menu != '1') {				
				System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员  4-退出    请选择（1-4）：");
			}
			menu = TSUility.readMenuSelection();
			switch(menu) {
				case '1':
					getTeam();
					break;
				case '2':
					addMember();
					break;
				case '3':
					deleteMember();
					break;
				case '4':
					System.out.print("确认是否退出（Y/N）:");
					char isExit = TSUility.readConfirmSelection();
					if (isExit == 'Y') {
						flag=false;
					}
					break;
			}
		}
	}

	//显示所有的员工信息
	private void listAllEmployee() {
		System.out.println("--------------------------------开发团队软件--------------------------------\n");
		Employee[] Employees =listSvc.getAllEmployees();
		if (Employees == null || Employees.length == 0) {
			System.out.println("没有任何员工信息");
		}else {
			System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
			for (int i = 0 ; i < Employees.length ; i++) {
				System.out.println(Employees[i].toString());
			}
			System.out.println("----------------------------------------------------------------------\n");
		}
	}

	//查看团队列表
	private void getTeam() {
		System.out.println("--------------------------------团队成员列表--------------------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("开发团队目前没有成员");
		}else {
			System.out.print("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
			for (int i = 0 ; i < team.length ; i++) {
				System.out.println(team[i].getDeatailsForTeam());
			}
		}
		System.out.println("----------------------------------------------------------------------\n");
	}

	//添加团队成员
	private void addMember() {
		System.out.println("--------------------------------添加成员--------------------------------\n");
		System.out.print("请输入要添加的成员ID：");
		int id = TSUility.readInt();
		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("添加成功");
		} catch (TeamException e){
			System.out.println("添加失败，原因：" + e.getMessage());
		}
		TSUility.readReturn();
	}

	//删除团队成员
	private void deleteMember() {
		System.out.println("--------------------------------删除成员--------------------------------\n");
		System.out.print("请输入要删除的成员ID：");
		int memberId = TSUility.readInt();
		System.out.print("确认是否删除（Y/N）:");
		char isDelete = TSUility.readConfirmSelection();
		if (isDelete == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败，原因：" + e.getMessage());
		}
		TSUility.readReturn();
	}

	public static void main(String[] args) {
		TeamView tv = new TeamView();
		tv.enterMainMenu();
	}
}
