/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.builder.impl;

import hr.darwin.Main;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import hr.darwin.builder.DbQuery;

/**
 *
 * @author darwin
 */
public class NamedQuery implements DbQuery {
    private final EntityManager em;
    private Query namedQuery;

    public NamedQuery(EntityManager _em) {
        this.em = _em;
    }
    
    @Override
    public Query queryMethod(String className, String whatMethod) throws Exception {
       String packageName = Main.class.getPackage().getName();
       Class<?> getClass = Class.forName(packageName+".model.impl."+className);
       this.em.getTransaction().begin();
       namedQuery = this.em.createNamedQuery(className+"."+whatMethod, getClass);
       this.em.getTransaction().commit();
         
       return namedQuery;
    }
    
}
