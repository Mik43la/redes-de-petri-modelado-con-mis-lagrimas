package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.hostettler.jdd.dd.DD;
import net.hostettler.jdd.dd.ddd.DDDImpl;

public class PetriNet {
	
	
	private Set<Place> structure = new HashSet<Place>();
	private Set<Transicion> transicions = new HashSet<Transicion>();
	private DD<String, Integer> result;
	DD<String, Integer> res = (DD<String, Integer>)  DDDImpl.DDD_TRUE;
	
	
	public PetriNet(Set<Place> structure, Set<Transicion> transicions) {
 		this.structure = structure;
		this.transicions = transicions;
	}


	public Set<Place> getStructure() {
		return structure;
	}


	public void setStructure(Set<Place> structure) {
		this.structure = structure;
	}


	public Set<Transicion> getTransicions() {
		return transicions;
	}


	public void setTransicions(Set<Transicion> transicions) {
		this.transicions = transicions;
	}
	
	
	public void imprimir() {
		
		
		List<Place> reversedSet = new ArrayList<>(structure);
        Collections.reverse(reversedSet);
        
		for(Place a: structure) {
			System.out.println("Lugar:" + a.getName() + " Cantidad de marcas: "+ a.getMarks());
			res = DDDImpl.create(a.getName().toString(), a.getMarks(), res);

		}
		
		
		result = res;
	
        System.out.println("Marcado Inicial * ");
        System.out.println("result: "+ result);
        System.out.println();
        
        
		for(Transicion a: transicions) {
			System.out.println("Transicion ");
			for(String prekeys: a.getPre().keySet()) {
				System.out.println("pre: "+prekeys+" mark amount being taken: "+ a.getPre().get(prekeys));
			}
			System.out.println();
			for(String postkeys: a.getPost().keySet()) {
				System.out.println("post: "+postkeys+" marks given: "+ a.getPost().get(postkeys));
			}
			System.out.println();
		}
		
		
	}
	
	
	
	

	 
}


//List<Transicion> transicions = new ArrayList<Transicion>();