package InterpreterMethod;

import java.util.HashMap;

// 变量解释器
public class VarExpression extends Expression {

	private String key; 

	public VarExpression(String key) {
		this.key = key;
	}

	// 根据 变量名称，返回对应值
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(this.key);
	}
}
