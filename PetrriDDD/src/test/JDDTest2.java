package test;

import java.util.Map;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.Hom;
import net.hostettler.jdd.dd.ddd.DDDImpl;
import net.hostettler.jdd.dd.ddd.SimplePropagationDDDHomImpl;

public class JDDTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DD<String, Integer> dd1 = 
				DDDImpl.create("a",1, 
						DDDImpl.create("b",2,
								DDDImpl.create("c",3)));
		System.out.println(dd1);
		System.out.println();
		
		DD<String, Integer> dd2 = 
				DDDImpl.create("a",1, 
						DDDImpl.create("b",2,
								DDDImpl.create("c",3)));
		System.out.println(dd2);
		System.out.println();
		
		
		DD<String, Integer> dd3 = dd1.union(dd2);
		System.out.println(dd3);
		System.out.println(dd3.getStates());

		System.out.println();
		
		Hom<String, Integer> filter = new SimplePropagationDDDHomImpl<String, Integer>() {
			
			@Override
			protected DD<String, Integer> phi(String e, Integer x, Map<Integer, DD<String, Integer>> alpha,
					Object... args){
				String var = (String) args[0];
				Integer val = (Integer) args[1];
				
				if(e.contentEquals(var)&& x.equals(val)) {
					return (DD<String, Integer> ) DDDImpl.DDD_FALSE;
				}else {
					return DDDImpl.create(e, x, phi(alpha.get(x), args));
				}
			}
		};
		
		DD<String, Integer> res = filter.phi(dd3,  "c", 3);
		System.out.println(res);
		System.out.println(res.equals(dd2));
		System.out.println(res == dd2);
		
		//h+,h-
		
		
		
		Hom<String, Integer> hp = new SimplePropagationDDDHomImpl<String, Integer>() {

			@Override
			protected DD<String, Integer> phi(String e, Integer x, Map<Integer, DD<String, Integer>> alpha,//implementa hijos de una variable
					Object... args) {
				String var =(String) args[0];
				int val=(Integer) args[1];
				if(e.contentEquals(var)) {
					return (DD<String, Integer>) DDDImpl.create(e, x+val,phi(alpha.get(x),args));
				}else {
					return DDDImpl.create(e, x,phi(alpha.get(x),args));
				}
				
			}
			
		}; //quita caminos del ddd que tiene cierta variable y cierto valor 
		
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
			
		}; //quita caminos del ddd que tiene cierta variable y cierto valor 
		DD<String,Integer> hSuma =hp.phi(dd3,new Object[] {"b",4});// variable,valor x asociado a variable,cantidad a sumar
		DD<String,Integer> hResta =hn.phi(dd3,new Object[] {"b",2});// variable,valor x asociado a variable,cantidad a restar
		System.out.println("h+");
		System.out.println(hSuma);
		System.out.println("______________");
		System.out.println("h-");
		System.out.println(hResta);
		System.out.println("______________");
		System.out.println();
		hp.compose(hp.compose(hn));
		
		
		
		
		
		
		
	}

}
