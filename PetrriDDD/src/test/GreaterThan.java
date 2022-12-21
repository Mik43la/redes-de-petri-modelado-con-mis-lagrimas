package test;

import java.util.Map;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.Hom;
import net.hostettler.jdd.dd.ddd.DDDImpl;
import net.hostettler.jdd.dd.ddd.SimplePropagationDDDHomImpl;

public class GreaterThan extends SimpleExpression{

	public GreaterThan(String var, Integer val, DD<String, Integer> ddd) {
		super(var, val, ddd);
		// TODO Auto-generated constructor stub
		setDdd(operate(var, val, ddd));
	}

	@Override
	protected DD<String, Integer> operate(String var, Integer val, DD<String, Integer> ddd) {
		// TODO Auto-generated method stub
			Hom<String, Integer> greaterThan = new SimplePropagationDDDHomImpl<String, Integer>() {
            
			@Override
            protected DD<String, Integer> phi(String e, Integer x,
            		Map<Integer, DD<String, Integer>> alpha, Object... args) {
				
                if(e.equals(var) && x > val){
                    return DDDImpl.create(e, x, id(alpha, x));
                }else if(e != var) {
                    return DDDImpl.create(e, x, phi(alpha.get(x)));
                }else{
                    return (DD<String, Integer>) DDDImpl.DDD_FALSE;
                }
            }
        };
        return greaterThan.phi(ddd);
	}

}
