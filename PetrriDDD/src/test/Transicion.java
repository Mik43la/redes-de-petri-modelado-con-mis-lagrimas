package test;

import java.util.HashMap;
import java.util.Map;

public class Transicion {

	//String el lugar de donde estas tomando marcas, Integer es la cantidad de marcas que estas consumiendo
	private Map<String, Integer> pre = new HashMap<String , Integer>();
	//String es el lugar a donde estas poniendo las marcas, Int la cantidad que le estas dando
	private Map<String, Integer> post  = new HashMap<String , Integer>();
	//hm.put();
	
	
	public Transicion(Map<String, Integer> pre, Map<String, Integer> post) {
		this.pre = pre;
		this.post = post;
	}


	public Map<String, Integer> getPre() {
		return pre;
	}


	public void setPre(Map<String, Integer> pre) {
		this.pre = pre;
	}


	public Map<String, Integer> getPost() {
		return post;
	}


	public void setPost(Map<String, Integer> post) {
		this.post = post;
	}

	
}
