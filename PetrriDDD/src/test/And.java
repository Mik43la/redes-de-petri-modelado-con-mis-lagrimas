package test;

import net.hostettler.jdd.dd.DD;

public class And extends ComplexExpression{
	public And() {
		super("", 0, null);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Expression operate(Expression a, Expression b) {
		// TODO Auto-generated method stub
		setDdd(a.getDdd().intersection(b.getDdd()));
		return this;
	}


}
