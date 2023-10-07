/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author 180701103
 */
public class Disciplina {
    private int codigo;
    private String disciplina;
    
    public Disciplina ( String disciplina){
        this.disciplina = disciplina;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    public void cadastrar(){
        String sql = "INSERT INTO disciplina(disciplina) VALUES("
                + " ' "+ this.getDisciplina()+ "' )";
        System.out.println(sql);
        Conexao.executar(sql);
    }
    public void editar(){
        String sql = "UPDATE disciplina SET "
                    + " ' " + this.getDisciplina() + " ' )";
        Conexao.executar(sql);
    }
    
    public void excluir(String disciplina){
        String sql = "DELETE FROM disciplina WHERE disciplina = " + disciplina;
        Conexao.executar(sql);
    }
    
    public static ArrayList<Disciplina> getDisciplinas(){
     ArrayList<Disciplina> lista = new ArrayList<>();
     String sql = "SELECT disciplina FROM ORDER BY disciplina";
     ResultSet rs = Conexao.consultar(sql);
     if(rs != null){
         try{
             while (rs.next()) {
                 String disciplina = rs.getString(1);
                 
                 Disciplina discip = new Disciplina(disciplina);
                 discip.setCodigo(rs.getInt("codigo"));
                 lista.add(discip); 
             }
         }catch(Exception e){       
         }
     }
      return lista;
    }
    
}
