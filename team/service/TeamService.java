package team.service;
//���ڿ����Ŷӳ�Ա�Ĺ�����ӣ�ɾ����

import team.domain.*;

public class TeamService {

	private static int counter = 1;//��member��ֵʹ��
	private final int MAX_MEMBER = 5;//���ƿ����Ŷ�����
	private Programmer[] team = new Programmer[MAX_MEMBER];//�������濪���Ŷӳ�Ա
	private int total;//��¼�����Ŷ���ʵ�ʵ�����
	
	public TeamService() {
		super();
	}
	
	//��ȡ�����Ŷӵĳ�Ա
	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0 ; i < team.length ; i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	//���ƶ���Ա����ӵ������Ŷ���
	public void addMember(Employee e) throws TeamException {
		//��Ա����
		if (total >= MAX_MEMBER) {
			throw new TeamException("��Ա����");
		}
		//�ó�Ա���ǿ�����Ա
		if (!(e instanceof Programmer)) {
			throw new TeamException("�ó�Ա���ǿ�����Ա");
		}
		//�ó�Ա���ڿ����Ŷ���
		if (isExist(e)) {
			throw new TeamException("�ó�Ա���ڿ����Ŷ���");
		}
		//�ó�Ա����ĳ�Ŷӳ�Ա
		Programmer p = (Programmer)e;//һ����������쳣
		if ("BUSY".equalsIgnoreCase(p.getStstus().getNAME())) {
			throw new TeamException("�ó�Ա����ĳ�Ŷӳ�Ա");
		}
		//�ó�Ա�����ݼ�
		if ("VOCATION".equalsIgnoreCase(p.getStstus().getNAME())) {
			throw new TeamException("�ó�Ա�����ݼ�");
		}
		//�Ŷ������ֻ����һ���ܹ�ʦ,�������ʦ,��������Ա
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;//��ȡ��ǰ�Ŷӵĸ�������
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
				throw new TeamException("�Ŷ������ֻ����һ���ܹ�ʦ");
			}
		}else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("�Ŷ������ֻ�����������ʦ");
			}
		}else {
			if (numOfPro >= 3) {
				throw new TeamException("�Ŷ������ֻ������������Ա");
			}
		}
		
		//���������Ŷ�
		team[total++] = p;
		//�޸�p������
		p.setStstus(Status.BUSY);
		p.setMemberId(counter++);
	}
	
	//�ж��ƶ���Ա���Ƿ��Ѿ������ڿ����Ŷ�
	private boolean isExist(Employee e) {
		for (int i = 0 ; i < total ; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	
	//ɾ���Ŷӳ�Ա
	public void removeMember(int menberId) throws TeamException {
		int i = 0;
		for ( ; i < total ; i++) {
			if (team[i].getMemberId() == menberId) {
				team[i].setStstus(Status.FREE);
				break;
			}
		}
		if (i == total) {
			throw new TeamException("δ�ҵ�ָ����Ա,ɾ��ʧ��");
		}
		for (int j = i + 1 ; j < total ; j++) {
			team[j-1]=team[j];
		}
		team[--total]=null;
	}
	
}
