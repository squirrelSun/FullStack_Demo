package InterpreterMethod;

import java.util.HashMap;

// 抽象类表达式，通过HashMap 键值对，获取到变量的值
public abstract class Expression {
	// 解释公式和数值, key 就是公式(表达式) 参数[a,b,c], value是具体值
	// a + b - c		HashMap {a=10, b=20}
	public abstract int interpreter(HashMap<String, Integer> var);
	
}
