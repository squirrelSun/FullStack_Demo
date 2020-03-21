package JAVA.team.service;
//关于开发团队成员的管理，添加，删除等

import JAVA.team.domain.*;

public class TeamService {

	private static int counter = 1;//给member赋值使用
	private final int MAX_MEMBER = 5;//限制开发团队人数
	private Programmer[] team = new Programmer[MAX_MEMBER];//用来保存开发团队成员
	private int total;//记录开发团队中实际的人数
	
	public TeamService() {
		super();
	}
	
	//获取开发团队的成员
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0 ; i < team.length ; i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	//将制定的员工添加到开发团队中
	public void addMember(Employee e) throws TeamException {
		//成员已满
		if (total >= MAX_MEMBER) {
			throw new TeamException("成员已满");
		}
		//该成员不是开发成员
		if (!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发成员");
		}
		//该成员已在开发团队中
		if (isExist(e)) {
			throw new TeamException("该成员已在开发团队中");
		}
		//该成员已是某团队成员
		Programmer p = (Programmer)e;//一定不会出现异常
		if ("BUSY".equalsIgnoreCase(p.getStstus().getNAME())) {
			throw new TeamException("该成员已是某团队成员");
		}
		//该成员正在休假
		if ("VOCATION".equalsIgnoreCase(p.getStstus().getNAME())) {
			throw new TeamException("该成员正在休假");
		}
		//团队中最多只能有一个架构师,两个设计师,三个程序员
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;//获取当前团队的各类人数
		for (int i = 0 ; i < total ; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			}else if (team[i] instanceof Designer) {
				numOfDes++;
			}else {
				numOfPro++;
			}
		}
		if (p instanceof Architect) {
			if (numOfArch >= 1) {
				throw new TeamException("团队中最多只能有一个架构师");
			}
		}else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("团队中最多只能有两个设计师");
			}
		}else {
			if (numOfPro >= 3) {
				throw new TeamException("团队中最多只能有三个程序员");
			}
		}
		
		//加入现有团队
		team[total++] = p;
		//修改p的属性
		p.setStstus(Status.BUSY);
		p.setMemberId(counter++);
	}
	
	//判断制定的员工是否已经存在于开发团队
	private boolean isExist(Employee e) {
		for (int i = 0 ; i < total ; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	
	//删除团队成员
	public void removeMember(int menberId) throws TeamException {
		int i = 0;
		for ( ; i < total ; i++) {
			if (team[i].getMemberId() == menberId) {
				team[i].setStstus(Status.FREE);
				break;
			}
		}
		if (i == total) {
			throw new TeamException("未找到指定成员,删除失败");
		}
		for (int j = i + 1 ; j < total ; j++) {
			team[j-1]=team[j];
		}
		team[--total]=null;
	}
	
}
