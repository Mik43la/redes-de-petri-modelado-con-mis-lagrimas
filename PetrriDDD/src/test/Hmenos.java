package test;

import java.util.Map;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.Hom;
import net.hostettler.jdd.dd.ddd.DDDImpl;
import net.hostettler.jdd.dd.ddd.SimplePropagationDDDHomImpl;

public class Hmenos {

	
	
	Hom<String, Integer> hn = new SimplePropagationDDDHomImpl<String, Integer>() {

		@Override
		protected DD<String, Integer> phi(String e, Integer x, Map<Integer, DD<String, Integer>> alpha,//implementa hijos de una variable
				Object... args) {
			String var =(String) args[0];
			int val=(Integer) args[1];
			if(e.contentEquals(var)&& x>=val) {
				return (DD<String, Integer>) DDDImpl.create(e, x-val,phi(alpha.get(x),args));
				
			}else {
				return DDDImpl.create(e, x,phi(alpha.get(x),args));
			}
			
		}
		
	};
	
	public DD recieve(DD aa) {
		
		
		return null;
	}
}
