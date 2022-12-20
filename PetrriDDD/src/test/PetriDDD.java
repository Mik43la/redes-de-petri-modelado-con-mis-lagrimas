package test;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.Hom;
import net.hostettler.jdd.dd.ddd.DDDIdHom;
import net.hostettler.jdd.dd.ddd.DDDImpl;

public class PetriDDD {
	
	private ArrayList<Hom<String, Integer>> tr = new ArrayList<Hom<String, Integer>>();
	
	public DD<String, Integer> initialMarking(PetriNet p) {
		
		Set<Place> initialMarking = p.getStructure();
		DD<String, Integer> initial = (DD<String, Integer>) DDDImpl.DDD_TRUE;

		for (Place place : initialMarking) {
			initial = DDDImpl.create(place.getName(), place.getMarks(), initial);
		}
		return initial;
	}
	
	
	
	
	
	public void createTransitionRelation(PetriNet p) {
		
		//TODO
		Set<Transicion> transicionsSet  = p.getTransicions();
		
		Hom<String, Integer> aux = new DDDIdHom<>();
		
		for (Transicion transicion: transicionsSet) {
			
			
			for(String pre: transicion.getPre().keySet()) {
				aux = aux.compose(new Hmenos(pre, transicion.getPre().get(pre)));
			}
			
			for(String post: transicion.getPost().keySet()) {
				aux = aux.compose(new Hmas(post, transicion.getPost().get(post)));
			}
			tr.add(aux);
		}
		
		
		
	}
	
	public DD<String, Integer> createTransitionHom(PetriNet p) {
		DD<String, Integer> marking  = initialMarking(p);
		createTransitionRelation(p);
		
		
		DD<String, Integer> res = (DD<String, Integer>) DDDImpl.DDD_FALSE;
        DD<String, Integer> initialMarking = marking;
        
        while (marking != res)
        {
            marking = initialMarking;
            for(Hom<String, Integer> homoToUnion: tr ){
                res = res.union(homoToUnion.phi(marking));
            }
            res = res.union(marking);
            initialMarking = res;
        }
        return res;

	}
}
