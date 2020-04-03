package BuilderMethod;

//抽象的建造者
public abstract class HouseBuilder {

	protected House house = new House();

	// 建造的流程，抽象的方法
	public abstract void buildBasic();

	public abstract void buildWalls();

	public abstract void roofed();

	// 建造完毕， 将产品(房子)返回
	public House buildHouse() {
		return house;
	}

}