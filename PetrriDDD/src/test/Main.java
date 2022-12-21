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
		structure.add(new Place(0, "p3"));
		structure.add(new Place(0, "p4"));
		structure.add(new Place(0, "p5"));
		structure.add(new Place(0, "p6"));
		structure.add(new Place(0, "p7"));
		structure.add(new Place(0, "p8"));
		
		
		List<Place> temp = new ArrayList<Place>(structure);
		Collections.reverse(temp);
		structure = new LinkedHashSet<Place>(temp);
		

		transicions.add(new Transicion(
				new HashMap<String, Integer>(){{put("p1", 1);}}, 
				new HashMap<String, Integer>(){{put("p2", 1);
												put("p3", 1);}}
				));
		
		transicions.add(new Transicion(
				new HashMap<String, Integer>(){{put("p2", 1);}}, 
				new HashMap<String, Integer>(){{put("p4", 1);
												put("p5", 1);}}
				));
		
	
		
		transicions.add(new Transicion(
				new HashMap<String, Integer>(){{put("p3", 1);}}, 
				new HashMap<String, Integer>(){{put("p6", 1);
												put("p7", 1);}}
				));
		
		transicions.add(new Transicion(
				new HashMap<String, Integer>(){{put("p5", 1);
												put("p6", 1);}}, 
				new HashMap<String, Integer>(){{put("p8", 2);}}
				));
		
		
	

		PetriNet petri = new PetriNet(structure, transicions);
		
		petri.imprimir();
		
		
		PetriDDD dolor = new PetriDDD();
		
		DD<String, Integer> estadoTransiciones = dolor.createTransitionHom(petri);
	
		System.out.println(estadoTransiciones);
		
		// if p4 1
		Equals avr = new Equals("p4",1, estadoTransiciones );
		System.out.println("Respuesta 1: ");
		System.out.println(avr.getDdd().toString());
		// if p8 2
		Equals avr2 = new Equals("p8",2, estadoTransiciones );
		System.out.println("Respuesta 2: ");
		System.out.println(avr2.getDdd().toString());
		
		//if p4 = 1 AND p8 = 2
		
		And sufro = new And();
		
		System.out.println("Respuesta AND: ");
		System.out.println(sufro.operate(avr, avr2).getDdd().toString());
		
		
		// if p4 = 0
		Equals avr3 = new Equals("p4",0, estadoTransiciones );
		System.out.println("Respuesta 3: ");
		System.out.println(avr3.getDdd().toString());
		// if p8 > 2
		GreaterThan avr4 = new GreaterThan("p8",2, estadoTransiciones );
		System.out.println("Respuesta 4: ");
		System.out.println(avr4.getDdd().toString());
		
		//if p4 = 0 OR p8 > 2
		
		Or sufro2 = new Or();
		
		System.out.println("Respuesta 0R: ");
		System.out.println(sufro2.operate(avr3, avr4).getDdd().toString());
		
		
		And sufro3 = new And();
		
		System.out.println("Respuesta AND 2: ");
		System.out.println(sufro3.operate(avr3, avr4).getDdd().toString());
		
		
	}

}
