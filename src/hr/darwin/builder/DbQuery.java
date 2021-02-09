/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.darwin.builder;

import javax.persistence.Query;

/**
 *
 * @author darwin
 */
public interface DbQuery {
    public Query queryMethod(String className, String whatMethod) throws Exception;
}
