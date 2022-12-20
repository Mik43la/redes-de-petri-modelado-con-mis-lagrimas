package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import net.hostettler.jdd.dd.DD;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Place> structure  = new LinkedHashSet<Place>();
		
		
		Set<Transicion> transicions = new HashSet<Transicion>();
		
		structure.add(new Place(1, "p1"));
		structure.add(new Place(0, "p2"));
		
		List<Place> temp = new ArrayList<Place>(structure);
		Collections.reverse(temp);
		structure = new LinkedHashSet<Place>(temp);
		
		Map<String, Integer> pre = new HashMap<String , Integer>();
		Map<String, Integer> post = new HashMap<String , Integer>();
		
		pre.put("p1", 1);
		
		post.put("p2", 1);
		
		transicions.add(new Transicion(pre, post));
		
		PetriNet petri = new PetriNet(structure, transicions);
		
		petri.imprimir();
		
		
		PetriDDD dolor = new PetriDDD();
		
		DD<String, Integer> estadoTransiciones = dolor.createTransitionHom(petri);
	
		System.out.println(estadoTransiciones);
		
	}

}
