package com.reges.padariareges.modelos;

public class Cliente {
    protected int id;
    protected String nome;    
    protected String documento;    
    protected String telefone;
    protected String email;
    protected Endereco endereco;

    public Cliente(int id, String nome, String documento, 
                String telefone, String email, Endereco endereco) {   
        this.id = id;
        this.nome = nome;        
        this.documento = documento;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
