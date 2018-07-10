package itbootcampLocators;

import java.util.ArrayList;
import java.util.List;


public class ListExample {

	public static void main(String[] args) {
		
    	List<String> lista = new ArrayList<>();
    
    	
    	// dodavanje elemenata u listu
    	
    	lista.add("jedan");
    	lista.add("dva");
    	lista.add("tri");
    	
    	
    	System.out.println("Duzina liste je: " + lista.size());
    	
    	
    	// dohvatanje elemenata iz liste
    	
    	String prviElement = lista.get(0);
    	String treciElement = lista.get(0);
    	
    	
    	System.out.println("Ovo je prvi element liste: " + prviElement);
    	System.out.println("Ovo je treci element liste: " + treciElement);
    	
    	
    	// iteracija kroz listu - nacin prvi
    	
    	for (int i = 0; i < lista.size(); i++) {
    		String element = lista.get(i);
    		System.out.println(element);
    	}
    	
    	// iteracija kroz listu - nacin drugi
    	
    	for(String clan:lista){  
    		System.out.println(clan);  
    	}  


  
	}

}

//	if (lista.isEmpty()) {
//    	System.out.println("Lista je prazna");
//	}
//	else {
//    	System.out.println("Lista nije prazna");
//    	}


// dohvatanje elemenata iz liste
//System.out.println("Ovo je prvi element liste: " + lista.get(0));
//System.out.println("Ovo je drugi element liste: " + lista.get(1));



//	for (int i = 0; i < lista.size(); i++) {
//	    String element = lista.get(i);
//	    System.out.println(element);
//	}

//for(String s:lista){  
//	 System.out.println(s);  
//	}  

//numbers.remove(numbers.size() - 1);
//
//numbers.remove(0);