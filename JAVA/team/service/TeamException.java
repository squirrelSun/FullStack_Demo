package JAVA.team.service;
//自定义异常类
public class TeamException extends Exception{

	static final long serialVersionUID = -3387516123456229948L;
	
	public TeamException() {
		
	}
	
	public TeamException(String message) {
		super(message);
	}
}
