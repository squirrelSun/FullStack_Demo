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
				System.out.print("1-�Ŷ��б�  2-����Ŷӳ�Ա  3-ɾ���Ŷӳ�Ա  4-�˳�    ��ѡ��1-4����");
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
					System.out.print("ȷ���Ƿ��˳���Y/N��:");
					char isExit = TSUility.readConfirmSelection();
					if (isExit == 'Y') {
						flag=false;
					}
					break;
			}
		}
	}

	//��ʾ���е�Ա����Ϣ
	private void listAllEmployee() {
		System.out.println("--------------------------------�����Ŷ����--------------------------------\n");
		Employee[] Employees =listSvc.getAllEmployees();
		if (Employees == null || Employees.length == 0) {
			System.out.println("û���κ�Ա����Ϣ");
		}else {
			System.out.println("ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");
			for (int i = 0 ; i < Employees.length ; i++) {
				System.out.println(Employees[i].toString());
			}
			System.out.println("----------------------------------------------------------------------\n");
		}
	}

	//�鿴�Ŷ��б�
	private void getTeam() {
		System.out.println("--------------------------------�Ŷӳ�Ա�б�--------------------------------\n");
		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("�����Ŷ�Ŀǰû�г�Ա");
		}else {
			System.out.print("TID/ID\t����\t����\t����\tְλ\t����\t��Ʊ\n");
			for (int i = 0 ; i < team.length ; i++) {
				System.out.println(team[i].getDeatailsForTeam());
			}
		}
		System.out.println("----------------------------------------------------------------------\n");
	}

	//����Ŷӳ�Ա
	private void addMember() {
		System.out.println("--------------------------------��ӳ�Ա--------------------------------\n");
		System.out.print("������Ҫ��ӵĳ�ԱID��");
		int id = TSUility.readInt();
		try {
			Employee e = listSvc.getEmployee(id);
			teamSvc.addMember(e);
			System.out.println("��ӳɹ�");
		} catch (TeamException e){
			System.out.println("���ʧ�ܣ�ԭ��" + e.getMessage());
		}
		TSUility.readReturn();
	}

	//ɾ���Ŷӳ�Ա
	private void deleteMember() {
		System.out.println("--------------------------------ɾ����Ա--------------------------------\n");
		System.out.print("������Ҫɾ���ĳ�ԱID��");
		int memberId = TSUility.readInt();
		System.out.print("ȷ���Ƿ�ɾ����Y/N��:");
		char isDelete = TSUility.readConfirmSelection();
		if (isDelete == 'N') {
			return;
		}
		try {
			teamSvc.removeMember(memberId);
			System.out.println("ɾ���ɹ�");
		} catch (TeamException e) {
			System.out.println("ɾ��ʧ�ܣ�ԭ��" + e.getMessage());
		}
		TSUility.readReturn();
	}

	public static void main(String[] args) {
		TeamView tv = new TeamView();
		tv.enterMainMenu();
	}
}
