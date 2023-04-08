package com.alergiasprontuario.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class Utils {
	
	@PersistenceContext
	EntityManager em;
			  
    public  Object getDateTime(){
    jakarta.persistence.Query q =  em.createNamedQuery("DateTime.getDateTime");      
	      	   return q.getSingleResult();
	
    }
}
