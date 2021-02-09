/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.builder.impl;

import hr.darwin.builder.impl.NamedQuery;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author darwin
 */
public class BuildQuery {
    private String persistenceName;
    private EntityManagerFactory emf;
    private EntityManager em;
    private NamedQuery query;
    private Query userQuery; 
  
    private BuildQuery() {
        
    }
    
    public static class Builder {
        //PROPS
         private String persistenceName;
         private EntityManagerFactory emf;
         private EntityManager em;
         private NamedQuery query;
         private List userList;

        public Builder(String _persistenceName) {
            this.persistenceName = _persistenceName;
            this.emf = Persistence.createEntityManagerFactory(_persistenceName);
        }

        public Builder withNamedQuery(String _className, String _whatMethod) {           
            try {
                this.em = this.emf.createEntityManager();
                this.query = new NamedQuery(this.em);
                this.userList = this.query.queryMethod(_className, _whatMethod).getResultList();
            } catch (Exception e) {
                 System.out.println(e.getMessage());
            } finally {
               if(this.em.isOpen()) {
                 this.em.close();
                } 
                this.emf.close();
            }

          return this;        
        }

        public List build() {           
            return this.userList;
        }
    }
}
