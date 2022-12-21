package test;

import net.hostettler.jdd.dd.DD;

public abstract class SimpleExpression extends Expression {

	public SimpleExpression(String var, Integer val, DD<String, Integer> ddd) {
		super(var, val, ddd);
		// TODO Auto-generated constructor stub
	}
	protected abstract DD<String, Integer> operate(String var, Integer val, DD<String, Integer> ddd);


}
