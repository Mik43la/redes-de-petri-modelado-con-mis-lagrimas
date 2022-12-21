package test;

import net.hostettler.jdd.dd.DD;

public class Or extends ComplexExpression{

	public Or() {
		super("", 0, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression operate(Expression a, Expression b) {
		// TODO Auto-generated method stub
		setDdd(a.getDdd().union(b.getDdd()));
		return this;
	}



}
