package com;

import org.hibernate.*;
import org.hibernate.cfg.*;


public class Factory 
{
    private static SessionFactory factory;
    
    public static SessionFactory getFactory()
    {
        try
        {
            if(factory==null)
            {
                factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            }    
      
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
     
      return factory;
    }
    
}
