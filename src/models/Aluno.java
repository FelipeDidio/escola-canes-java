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
public class Aluno extends Pessoa {
    private int matricula;
    
    public Aluno(String nome, String cpf, String fone, String email, String endereco, String nascimento){
        super(nome, cpf, fone, email, endereco, nascimento);
        setMatricula(matricula);
    }

    
    public Aluno(){
        
    }
    public int getMatricula(){
        return matricula;
    }
    private void setMatricula(int matricula){
        this.matricula = matricula;
    }
    
    public void cadastrar(){
        String sql = "INSERT INTO aluno (nome, cpf, fone, email, endereco, nascimento) VALUES ("
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
        String sql = "UPDATE aluno SET "
                    + "nome = ' " + this.getNome() + "' , "
                    + "cpf = ' " + this.getCpf() + "' , "
                    + "fone = ' " + this.getFone() + "' , "
                    + "email = ' " + this.getEmail() + "' , "
                    + "endereco = ' " + this.getEndereco() + "' , "
                    + "nascimento = ' " + this.getNascimento() + "' ,"
                    + "WHERE matricula = " + this.getId();
        Conexao.executar(sql);
    }
    
    public static void excluir(int matricula){
        String sql = "DELETE FROM aluno WHERE matricula = " + matricula;
        Conexao.executar(sql);
    }
    
    public static ArrayList<Aluno> getAlunos(){
        ArrayList<Aluno> lista = new ArrayList<>();
        String sql = "SELECT matricula, nome, cpf, fone, email, endereco, nascimento FROM ORDER BY nome";
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
                    
                    Aluno alu = new Aluno(nome, cpf, fone, email, endereco, nascimento);
                    alu.setId(rs.getInt("matricula"));
                    lista.add(alu);
                }
            }catch(Exception e){
            }
        }
        return lista;
    }
    
}
