package test;

import net.hostettler.jdd.dd.DD;

public abstract class ComplexExpression extends Expression {

	public ComplexExpression(String var, Integer val, DD<String, Integer> ddd) {
		super(var, val, ddd);
		// TODO Auto-generated constructor stub
	}

	public abstract Expression operate(Expression a, Expression b);
}
