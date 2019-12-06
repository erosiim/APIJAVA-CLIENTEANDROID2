/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dummy.api;

import java.sql.ResultSet;

/**
 *
 * @author exkapp
 */
public interface IDAO<T> {
    public boolean insert(T t);
    public boolean delete(T t);
    public boolean update(T t);
    public ResultSet readOne(T t);
    public ResultSet readAll();
}
