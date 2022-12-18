package test;

import java.util.Map;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.Hom;
import net.hostettler.jdd.dd.ddd.DDDImpl;
import net.hostettler.jdd.dd.ddd.SimplePropagationDDDHomImpl;

public class Hmas extends SimplePropagationDDDHomImpl<String, Integer>{
	String var;
	Integer val;
	 
	public Hmas(String var, Integer val) {
		this.var = var;
		this.val = val;
	}



	@Override
	protected DD<String, Integer> phi(String e, Integer x, Map<Integer, DD<String, Integer>> alpha,
			Object... args) {
		if(e.contentEquals(var)) {
			return (DD<String, Integer>) DDDImpl.create(e, x+val,phi(alpha.get(x)));
		}else {
			return DDDImpl.create(e, x,phi(alpha.get(x)));
		}
	} //quita caminos del ddd que tiene cierta variable y cierto valor 

}
