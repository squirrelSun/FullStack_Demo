package CommandMethod;

public class Client {

	public static void main(String[] args) {
		// 需要一个遥控器
		RemoteController remoteController = new RemoteController();
		
		System.out.println("=========使用遥控器操作电灯==========");
		// 创建电灯的对象(接受者)
		LightReceiver lightReceiver = new LightReceiver();
		// 创建电灯相关的开关命令
		LightOnCommand lightOnCommand = new LightOnCommand(lightReceiver);
		LightOffCommand lightOffCommand = new LightOffCommand(lightReceiver);
		// 给遥控器设置命令
		remoteController.setCommand(0, lightOnCommand, lightOffCommand);

		System.out.println("--------按下灯的开按钮-----------");
		remoteController.onButtonWasPushed(0);
		System.out.println("--------按下灯的关按钮-----------");
		remoteController.offButtonWasPushed(0);
		System.out.println("--------按下撤销按钮-----------");
		remoteController.undoButtonWasPushed();

		System.out.println("=========使用遥控器操作电视机==========");
		TVReceiver tvReceiver = new TVReceiver();
		TVOffCommand tvOffCommand = new TVOffCommand(tvReceiver);
		TVOnCommand tvOnCommand = new TVOnCommand(tvReceiver);
		// 给遥控器设置命令
		remoteController.setCommand(1, tvOnCommand, tvOffCommand);

		System.out.println("--------按下电视机的开按钮-----------");
		remoteController.onButtonWasPushed(1);
		System.out.println("--------按下电视机的关按钮-----------");
		remoteController.offButtonWasPushed(1);
		System.out.println("--------按下撤销按钮-----------");
		remoteController.undoButtonWasPushed();

	}

}
