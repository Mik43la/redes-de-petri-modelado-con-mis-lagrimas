package test;

import java.util.Map;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.Hom;
import net.hostettler.jdd.dd.ddd.DDDIdHom;
import net.hostettler.jdd.dd.ddd.DDDImpl;

public class PetriDDD {
	public DD<String, Integer> initialMarking(PetriNet p) {
		Map<String, Integer> initialMarking = p.initialMarking;
		DD<String, Integer> initial = (DD<String, Integer>) DDDImpl.DDD_TRUE;
		for (String place : initialMarking.keySet()) {
			initial = DDDImpl.create(place, initialMarking.get(place), initial);
		}
		return initial;
	}
	
	public Hom<String, Integer> createTransitionRelation(PetriNet p) {
		Hom<String, Integer> tr = new DDDIdHom<String, Integer>();
		//TODO
		return tr;
	}
	
	public Hom<String, Integer> createTransitionHom(Transicion t) {
		
	}
}
