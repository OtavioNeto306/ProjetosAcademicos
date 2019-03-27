
/**
 * Projeto Ammamentar / Faculdade Unijorge Materia (Projetor integrador)
 * @author Otávio Neto 
 * Classe Responsavel de fazer a coneexão entre Entity é o banco de dados
 */
package br.fuj.dao;

import br.fuj.conexao.ConexaoBancoOracle;
import br.fuj.entity.Endereco;
import br.fuj.entity.Pessoa;
import br.fuj.exception.ErroSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
    
    

/**
 * Salvando os registro no Banco de dados da Oracle 11g
 * @param endereco      
 * @throws SQLException     Tratamento de Erro do SQLException
 * @throws ErroSistema      Tratamento de erro da Classe exception
 */    
public void salvar(Endereco endereco) throws SQLException, ErroSistema {
        try {
            Pessoa pessoa;
            Connection conexao = ConexaoBancoOracle.getConexao();
            PreparedStatement ps;

            if (endereco.getId_endereco()== null) {
                ps = conexao.prepareStatement("INSERT INTO TB_ENDERECO (id_endereco, bairro, cidade, rua, numero, pontoreferencia, cep, estado) VALUES (SEQ_ID_ENDERECO.NEXTVAL, ?,?,?,?,?,?,? )");

            } else {
                ps = conexao.prepareStatement("update TB_ENDERECO set bairro=?, cidade=?, rua=?, numero=?, pontoreferencia=?, cep=?, estado=? where id_endereco");
                ps.setInt(9, endereco.getId_endereco());

            }

            ps.setString(1, endereco.getBairro());
            ps.setString(2, endereco.getCidade());
            ps.setString(3, endereco.getRua());
            ps.setString(4, endereco.getNumero());
            ps.setString(5, endereco.getPontoReferencia());
            ps.setString(6, endereco.getCep());
            ps.setString(7, endereco.getEstado());
            
            ps.execute();
            ConexaoBancoOracle.fecharConexao();

        } catch (SQLException ex) {

            throw new ErroSistema("Erro ao tentar Salvar", ex);
        }

    }


/**
 * Metodo Responsavel por Deletar os registro no banco de dados
 * @param idEndereco
 */
    public void deletar(Integer idEndereco) throws ErroSistema {

        try {
            Connection conexao = ConexaoBancoOracle.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from TB_ENDERECO where id_endereco =?");
            ps.setInt(1, idEndereco);
            ps.execute();

        } catch (SQLException ex) {
            throw new ErroSistema("Não foi Possivel deletar o endereco do banco", ex);
        }

    }


    /**
     * Metodo responsavel por listar os registro do banco de dados 
     */
    public List<Endereco> buscar() throws SQLException, ErroSistema {
        try {
            Connection conexao = ConexaoBancoOracle.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from tb_endereco"); 
            ResultSet resultSet = ps.executeQuery();
            List<Endereco> enderecos = new ArrayList<>();
            while (resultSet.next()) {
                Endereco endereco = new Endereco();
                endereco.setId_endereco(resultSet.getInt("id_endereco"));
                
                endereco.setBairro(resultSet.getString("bairro"));
                endereco.setEstado(resultSet.getString("estado"));
                endereco.setCidade(resultSet.getString("cidade"));
                endereco.setRua(resultSet.getString("rua"));
                endereco.setNumero(resultSet.getString("numero"));
                endereco.setPontoReferencia(resultSet.getString("PontoReferencia"));
                endereco.setCep(resultSet.getString("cep"));
               

                enderecos.add(endereco);
            }
            
            
            ConexaoBancoOracle.fecharConexao();
            return enderecos;
        }
        
        catch (SQLException ex) {
            throw new ErroSistema("Não foi Possivel buscar o registro no banco!", ex);

        }
    
    
}
}
    
