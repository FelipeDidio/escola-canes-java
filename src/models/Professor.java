/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author 180701103
 */
public class Professor extends Pessoa{
    private int codigo;
    
    public Professor(String nome, String cpf, String fone, String email, String endereco, String nascimento){
        super(nome, cpf, fone, email, endereco, nascimento);
        this.codigo = codigo;
    
}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void cadastrar(){
        String sql = "INSERT INTO professor (nome, cpf, fone, email, endereco, nascimento) VALUES ("
                    + " ' "+ this.getNome()+ "' , "
                    + " ' "+ this.getCpf()+ "' , "
                    + " ' "+ this.getFone()+ "' , "
                    + "' "+ this.getEmail()+ "' , "
                    + "' "+ this.getEndereco()+ "' , "
                    + "' "+ this.getNascimento()+ " )";
        System.out.println(sql);
        Conexao.executar(sql);
    }
    
    public void editar(){
        String sql = "UPDATE professor SET "
                    + "nome = ' " + this.getNome() + "' , "
                    + "cpf = ' " + this.getCpf() + "' , "
                    + "fone = ' " + this.getFone() + "' , "
                    + "email = ' " + this.getEmail() + "' , "
                    + "endereco = ' " + this.getEndereco() + "' , "
                    + "nascimento = ' " + this.getNascimento() + "' ,"
                    + "WHERE codigo = " + this.getId();
        Conexao.executar(sql);
    }
    
    public static void excluir(int idProfessor){
        String sql = "DELETE FROM professor WHERE idProfessor = " + idProfessor;
        Conexao.executar(sql);
    }
    
    public static ArrayList<Professor> getProfessores(){
        ArrayList<Professor> lista = new ArrayList<>();
        String sql = "SELECT idProfessor, nome, cpf, fone, email, endereco, nascimento FROM ORDER BY nome";
        ResultSet rs = Conexao.consultar(sql);
        if (rs != null){
            try{
                while(rs.next() ){
                    String nome = rs.getString(1);
                    String cpf = rs.getString(2);
                    String fone = rs.getString("fone");
                    String email = rs.getString(4);
                    String endereco = rs.getString("endereco");
                    String nascimento = rs.getString(6);
                    
                    Professor prof = new Professor(nome, cpf, fone, email, endereco, nascimento);
                    prof.setId(rs.getInt("idProfessor"));
                    lista.add(prof);
                }
            }catch(Exception e){
            }
        }
        return lista;
    }
}
    
