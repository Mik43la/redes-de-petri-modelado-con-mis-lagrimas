package test;

import java.util.Map;
import java.util.Set;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.Hom;
import net.hostettler.jdd.dd.ddd.DDDIdHom;
import net.hostettler.jdd.dd.ddd.DDDImpl;

public class PetriDDD {
	
	
	public DD<String, Integer> initialMarking(PetriNet p) {
		
		Set<Place> initialMarking = p.getStructure();
		DD<String, Integer> initial = (DD<String, Integer>) DDDImpl.DDD_TRUE;

		for (Place place : initialMarking) {
			initial = DDDImpl.create(place.getName(), place.getMarks(), initial);
		}
		return initial;
	}
	
	
	public DD<String, Integer> transicion(PetriNet p){
		Set<Transicion> transicionsSet  = p.getTransicions();
		
		for (Transicion transicion: transicionsSet) {
			for(String pre: transicion.getPre().keySet()) {
				
			}
			
			for(String post: transicion.getPost().keySet()) {
				
			}
		}
	}
	
	
	public Hom<String, Integer> createTransitionRelation(PetriNet p) {
		Hom<String, Integer> tr = new DDDIdHom<String, Integer>();
		//TODO
		
		
		
		
		
		
		
		return tr;
	}
	
	public Hom<String, Integer> createTransitionHom(Transicion t) {
		//
		
		
		//
	}
}
