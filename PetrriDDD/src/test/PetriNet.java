package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PetriNet {
	/*Map<String, String> structure = new HashMap<String, String>(); // Lugares, transiciones que salen de los lugares
	Map<String, Integer> initialMarking   = new HashMap<String, Integer>();  //place, marks //se puede reemplazar por set 
	// con las marcas como atributo de los objetos en el set// map, key places, value transicions list?
	public PetriNet(Map<String, String> structure, Map<String, Integer> initialMarking) {
		this.structure = structure;
		this.initialMarking = initialMarking;
	}*/
	
	private Set<Place> structure = new HashSet<Place>();
	private Set<Transicion> transicions = new HashSet<Transicion>();
	
	
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
	
	
	
	
	

	 
}


//List<Transicion> transicions = new ArrayList<Transicion>();