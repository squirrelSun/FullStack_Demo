package BuilderMethod;

//指挥者（指定制作流程，返回产品）
public class HouseDirector {

	HouseBuilder houseBuilder = null;

	// 方式一：构造器传入 houseBuilder
	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	// 方式二：通过setter 传入 houseBuilder
	public void setHouseBuilder(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	// 指挥者处理建造房子的流程
	public House constructHouse() {
		houseBuilder.buildBasic();
		houseBuilder.buildWalls();
		houseBuilder.roofed();
		return houseBuilder.buildHouse();
	}

}
