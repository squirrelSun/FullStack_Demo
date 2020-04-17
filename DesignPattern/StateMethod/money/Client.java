package StateMethod.money;

public class Client {

	public static void main(String[] args) {
		// 创建context 对象
		Context context = new Context();
		// 将当前状态设置为 PublishState
		context.setState(new PublishState());
		context.getCurrentState();
		
//        //publish --> not pay
		context.acceptOrderEvent(context);
//        //not pay --> paid
		context.payOrderEvent(context);
//        // 失败, 检测失败时，会抛出异常
//        try {
//        	context.checkFailEvent(context);
//        	System.out.println("流程正常..");
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//		}
	}

}