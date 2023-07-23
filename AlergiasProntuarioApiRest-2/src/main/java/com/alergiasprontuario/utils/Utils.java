package com.alergiasprontuario.utils;


import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class Utils {
	
	@PersistenceContext
	EntityManager em;
			  
    public  Object getDateTime(){
    jakarta.persistence.Query q =  em.createNamedQuery("DateTime.getDateTime");      
	      	   return q.getSingleResult();
	
    } 
             /*****Convertido pelo ChatGpt******/
    public static String f_CalculateHash_SHA256(String Valor) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(Valor.getBytes(StandardCharsets.UTF_8));
            
            StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
           
        }
        return null;
    }  
}
