package InterpreterMethod;

import java.util.HashMap;

//加法解释器
public class AddExpression extends SymbolExpression {

	public AddExpression(Expression left, Expression right) {
		super(left, right);
	}

	// 处理相加
	public int interpreter(HashMap<String, Integer> var) {
		// super.left.interpreter(var) ：返回 left 表达式对应的值
		// super.right.interpreter(var)：返回right 表达式对应值
		return super.left.interpreter(var) + super.right.interpreter(var);
	}
}
