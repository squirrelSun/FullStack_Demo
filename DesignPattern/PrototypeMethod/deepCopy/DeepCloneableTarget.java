package PrototypeMethod.deepCopy;

import java.io.Serializable;

//原型类的引用数据类型类
public class DeepCloneableTarget implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	private String cloneName;

	@SuppressWarnings("unused")
	private String cloneClass;

	// 构造器
	public DeepCloneableTarget(String cloneName, String cloneClass) {
		this.cloneName = cloneName;
		this.cloneClass = cloneClass;
	}

	// 类的属性都是String，使用默认的clone完成即可
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
