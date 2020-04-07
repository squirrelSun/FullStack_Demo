package MementoMethod.theory;

public class Client {

	public static void main(String[] args) {

		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();

		originator.setState(" 状态#1");
		// 保存了当前的状态
		caretaker.add(originator.saveStateMemento());

		originator.setState(" 状态#2");
		caretaker.add(originator.saveStateMemento());
		System.out.println("当前的状态是 =" + originator.getState());

		originator.setState(" 状态#3");
		caretaker.add(originator.saveStateMemento());
		System.out.println("当前的状态是 =" + originator.getState());

		// 希望得到状态 1, 将 originator 恢复到状态1
		originator.getStateFromMemento(caretaker.get(0));
		System.out.println("恢复到状态1*********");
		System.out.println("当前的状态是 =" + originator.getState());

	}

}
