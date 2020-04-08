package PrototypeMethod.deepCopy;

public class Client {

	public static void main(String[] args) throws Exception {
		DeepProtoType p = new DeepProtoType();
		p.name = "宋江";
		p.deepCloneableTarget = new DeepCloneableTarget("大牛", "小牛");

		// 方式1 完成深拷贝
		DeepProtoType p1 = (DeepProtoType) p.clone();
		
		System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
		System.out.println("p1.name=" + p.name + "p1.deepCloneableTarget=" + p1.deepCloneableTarget.hashCode());

		// 方式2 完成深拷贝
		DeepProtoType p2 = (DeepProtoType) p.deepClone();

		System.out.println("p.name=" + p.name + "p.deepCloneableTarget=" + p.deepCloneableTarget.hashCode());
		System.out.println("p2.name=" + p.name + "p2.deepCloneableTarget=" + p2.deepCloneableTarget.hashCode());

	}

}