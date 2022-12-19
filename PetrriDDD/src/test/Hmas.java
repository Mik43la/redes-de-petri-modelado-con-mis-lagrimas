package test;

import java.util.Map;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.Hom;
import net.hostettler.jdd.dd.ddd.DDDImpl;
import net.hostettler.jdd.dd.ddd.SimplePropagationDDDHomImpl;

public class Hmas extends SimplePropagationDDDHomImpl<String, Integer>{
	private String var;
	private Integer val;
	 
	public Hmas(String var, Integer val) {
		this.var = var; 
		this.val = val;
	}



	@Override
	protected DD<String, Integer> phi(String e, Integer x, 
			Map<Integer, DD<String, Integer>> alpha, Object... args) {
		if(e.equals(var)) {
			return (DD<String, Integer>) DDDImpl.create(
					e, x+val,alpha.get(x));
		}else {
			if(alpha.get(x).equals(DDDImpl.DDD_TRUE)) {
				return (DD<String, Integer>)  DDDImpl.DDD_FALSE;
			}else {
				return DDDImpl.create(e, x,phi(alpha.get(x), var, val));
			}
		}
	} //quita caminos del ddd que tiene cierta variable y cierto valor 

}
/*}else if(var.equals(true)) {
			return (DD<String, Integer>)  DDDImpl.DDD_FALSE;
		}else {
			return DDDImpl.create(e, x,phi(alpha.get(x)));
		}*/