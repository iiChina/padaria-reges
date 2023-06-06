package com.reges.padariareges.rdn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.reges.padariareges.modelos.Endereco;

public class EnderecoRdn {
    public int inserirEndereco(Endereco end) {

        try {

            int linhasAfetadas = 0;

            StringBuilder str = new StringBuilder();

            str.append("INSERT INTO endereco (               ");
            str.append("            logradouro               ");
            str.append("            ,numero                  ");
            str.append("            ,uf                      ");
            str.append("            ,bairro                  ");
            str.append("            ,cep                     ");
            str.append("            ,cidade                   ");
            str.append("            ,idPessoa)               ");
            str.append("      VALUES(                        ");
            str.append("             ?                       ");
            str.append("            ,?                       ");
            str.append("            ,?                       ");
            str.append("            ,?                       ");
            str.append("            ,?                       ");
            str.append("            ,?                       ");
            str.append("            ,?                       ");
            str.append("          )                          ");

            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(str.toString());

            stmt.setString(1, end.getLogradouro());
            stmt.setString(2, end.getNumero());
            stmt.setString(3, end.getUf());
            stmt.setString(4, end.getBairro());
            stmt.setString(5, end.getCep());
            stmt.setString(6, end.getCidade());           
            
            linhasAfetadas = stmt.executeUpdate();

            return linhasAfetadas;

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return 0;
        }
    }

    public int alterarEndereco(Endereco end) {

        try {

            int linhasAfetadas = 0;

            StringBuilder str = new StringBuilder();

            str.append("UPDATE ENDERECO  SET NUMERO  = ? ");
            str.append("           ,LOGRADOURO       = ? ");
            str.append("           ,uf               = ? ");
            str.append("           ,bairro           = ? ");
            str.append("           ,cep              = ? ");
            str.append("           ,cidade           = ? ");
            str.append("WHERE IDPESSOA               = ?   ");

            Connection conn = new ConnectionFactory().getConnection();

            PreparedStatement stmt = conn.prepareStatement(str.toString());
            stmt.setString(1, end.getNumero());
            stmt.setString(2, end.getLogradouro());
            stmt.setString(3, end.getUf());
            stmt.setString(4, end.getBairro());
            stmt.setString(5, end.getCep());
            stmt.setString(6, end.getCidade());

            linhasAfetadas = stmt.executeUpdate();
            stmt.close();
            conn.close();

            return linhasAfetadas;

        } catch (SQLException ex) {

            System.out.println("Erro: " + ex.getMessage());

            return 0;

        }

    }

    public int deletarEnderecoPorPessoa(int idPessoa) {

        try {

            int linhasAfetadas;

            String str = "DELETE FROM ENDERECO WHERE IDPESSOA = ?";

            Connection conn = new ConnectionFactory().getConnection();

            PreparedStatement stmt = conn.prepareStatement(str.toString());
            stmt.setInt(1, idPessoa);
            linhasAfetadas = stmt.executeUpdate();

            stmt.close();
            conn.close();
            return linhasAfetadas;

        } catch (Exception ex) {

            System.out.println("Erro: " + ex.getMessage());

            return 0;

        }

    }

    /*public List<Endereco> obterTodos() {

        try {

            List<Endereco> lstEnd = new ArrayList<Endereco>();

            StringBuilder str = new StringBuilder();

            str.append("SELECT IDENDERECO        ");
            str.append(",LOGRADOURO              ");
            str.append(",NUMERO                  ");
            str.append(",UF                      ");
            str.append(",BAIRRO                  ");
            str.append(",CEP                     ");
            str.append(",IDPESSOA                ");
            str.append("FROM ENDERECO            ");
            str.append("WHERE IDPESSOA =  ?       ");

            Connection conn = new ConnectionFactory().getConnection();

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(str.toString());

            while (rs.next()) {

                Endereco end = new Endereco(
                        rs.getInt("IDENDERECO"),
                        rs.getString("LOGRADOURO"),
                        rs.getString("CIDADE"),
                        rs.getString("NUMERO"),
                        rs.getString("UF"),
                        rs.getString("BAIRRO"),
                        rs.getString("CEP"));

                lstEnd.add(end);

            }

            stmt.close();

            conn.close();

            return lstEnd;

        } catch (Exception ex) {

            System.out.println("Erro: " + ex.getMessage());

            return null;

        }

    }*/

    public Endereco obterPorIdPessoa(int id) {

        try {

            Endereco ret = null;

            StringBuilder str = new StringBuilder();

            str.append("SELECT  ID              ");
            str.append("        ,LOGRADOURO      ");
            str.append("        ,NUMERO          ");
            str.append("        ,UF              ");
            str.append("        ,BAIRRO          ");
            str.append("        ,CEP             ");
            str.append("        ,IDPESSOA        ");
            str.append("        ,CIDADE         ");
            str.append("        ,IDPESSOA        ");
            str.append("FROM ENDERECO            ");
            str.append("WHERE IDPESSOA = ?       ");

            Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement stmt = conn.prepareStatement(str.toString());

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                
                    Endereco end = new Endereco(
                        rs.getString("LOGRADOURO"),
                        rs.getString("CIDADE"),
                        rs.getString("NUMERO"),
                        rs.getString("UF"),
                        rs.getString("BAIRRO"),
                        rs.getString("CEP"));
                    ret = end;
                    

            }

            stmt.close();
            conn.close();
            return ret;

        } catch (Exception ex) {

            System.out.println("Erro: " + ex.getMessage());

            return null;

        }

    }
}
