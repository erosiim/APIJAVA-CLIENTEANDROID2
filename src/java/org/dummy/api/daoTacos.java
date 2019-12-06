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
public class daoTacos implements IDAO<Taco>{
    String sql = "";
    Conection c = Conection.getInstance();
    
    @Override
    public boolean insert(Taco t) {
        sql = "INSERT INTO tacos (id_taco, nombre, precio) VALUES ('"+t.getId_taco()+"','" +t.getNombre()+"','" +t.getPrecio()+"');";
        return c.execute(sql);
    }

    @Override
    public boolean delete(Taco t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet readOne(Taco t) {
        sql ="SELECT * FROM tacos WHERE(id_taco = '" +t.getId_taco()+"');";
        return c.executeQuery(sql);
    }

    @Override
    public boolean update(Taco t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet readAll() {
        sql ="SELECT * FROM tacos;";
        return c.executeQuery(sql);
    }
    
}
