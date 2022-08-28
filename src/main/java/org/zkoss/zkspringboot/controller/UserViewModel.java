package org.zkoss.zkspringboot.controller;

import java.util.LinkedList;
import java.util.List;


public class UserViewModel {

	List<persona> listtapersonas= getUsers();
	
	public List<persona> getUsers() {
		
		List<persona> listtapersonas = new LinkedList<persona>();
		
		listtapersonas.add(
				new persona(1,"kevin","Mosquera")
				);
		
		listtapersonas.add(
				new persona(2,"jose","ee")
				);
		
        return listtapersonas;
    }
	
	
	
	
	
	
	
}
