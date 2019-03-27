
/**
 * Projeto Ammamentar / Faculdade Unijorge Materia (Projetor integrador)
 * @author Otávio Neto 
 * Classe Responsavel de fazer a coneexão entre Entity é o banco de dados
 */

package br.fuj.dao;

import br.fuj.conexao.ConexaoBancoOracle;
import br.fuj.entity.Pessoa;
import br.fuj.exception.ErroSistema;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;





/**
 * Salvando os registro no Banco de dados da Oracle 11g      
 */

public class PessoaDAO {

    public void salvar(Pessoa pessoa) throws SQLException, ErroSistema {
        try {

            Connection conexao = ConexaoBancoOracle.getConexao();
            PreparedStatement ps;

            if (pessoa.getIdCadastroPessoa() == null) {
                ps = conexao.prepareStatement("INSERT INTO TB_PESSOA (idcadastropessoa, nome, cpf, rg, telefone, email, senha) VALUES (SEQ_ID_PESSOA.NEXTVAL,?,?,?,?,?,?)");

            } else {
                ps = conexao.prepareStatement("update TB_PESSOA set nome=?, cpf=?, rg=?, telefone=?, email=?, senha=? where idCadastroPessoa=?");
                ps.setInt(7, pessoa.getIdCadastroPessoa());

            }

            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpf());
            ps.setString(3, pessoa.getRg());
            ps.setString(4, pessoa.getTelefone());
            ps.setString(5, pessoa.getEmail());
            ps.setString(6, pessoa.getSenha());
            ps.execute();
            ConexaoBancoOracle.fecharConexao();

        } catch (SQLException ex) {

            throw new ErroSistema("Erro ao tentar Salvar", ex);
        }

    }

  /**
 * Metodo Responsavel por Deletar os registro no banco de dados
 */

    public void deletar(Integer idCadastro) throws ErroSistema {

        try {
            Connection conexao = ConexaoBancoOracle.getConexao();
            PreparedStatement ps = conexao.prepareStatement("delete from TB_PESSOA where idCadastroPessoa =?");
            ps.setInt(1, idCadastro);
            ps.execute();

        } catch (SQLException ex) {
            throw new ErroSistema("Não foi Possivel deletar o registro do banco", ex);
        }

    }

    /**
     * Metodo responsavel por listar os registro do banco de dados 
     */
    public List<Pessoa> buscar() throws SQLException, ErroSistema {
        try {
            Connection conexao = ConexaoBancoOracle.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from tb_pessoa"); 
            ResultSet resultSet = ps.executeQuery();
            List<Pessoa> pessoas = new ArrayList<>();
            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setIdCadastroPessoa(resultSet.getInt("idCadastroPessoa"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setCpf(resultSet.getString("cpf"));
                pessoa.setRg(resultSet.getString("rg"));
                pessoa.setTelefone(resultSet.getString("telefone"));
                pessoa.setEmail(resultSet.getString("Email"));
                pessoa.setSenha(resultSet.getString("Senha"));

                pessoas.add(pessoa);
            }
            
            
            ConexaoBancoOracle.fecharConexao();
            return pessoas;
        }
        
        catch (SQLException ex) {
            throw new ErroSistema("Não foi Possivel buscar o registro no banco!", ex);

        }
    
    
    
    }
    
//    
//    public Pessoa pesquisaUnica(Pessoa pessoa) throws SQLException, ClassNotFoundException, ErroSistema{
//       
//        Pessoa pessoaret = new Pessoa();        
//        String sql = "SELECT NOME, CPF, RG, TELEFONE, RUA, BAIRRO, ESTADO, "
//                + "NUMERO, CIDADE, CEP, PONTOREFERENCIA, EMAIL, SENHA"
//                + "FROM TB_PESSOA WHERE IDCADASTROPESSOA = ?";
//        
//        Connection conexao = ConexaoBancoOracle.getConexao();
//        PreparedStatement ps = conexao.prepareStatement(sql);
//        ps.setInt(1, pessoaret.getIdCadastroPessoa());
//        ResultSet resultSet = ps.executeQuery();
//        if ( resultSet.next() ){
//                 pessoaret.setIdCadastroPessoa(resultSet.getInt("idCadastroPessoa"));
//                pessoaret.setNome(resultSet.getString("nome"));
//                pessoaret.setCpf(resultSet.getString("cpf"));
//                pessoaret.setRg(resultSet.getString("rg"));
//                pessoaret.setTelefone(resultSet.getString("telefone"));
//                pessoaret.setRua(resultSet.getString("rua"));
//                pessoaret.setBairro(resultSet.getString("bairro"));
//                pessoaret.setEstado(resultSet.getString("estado"));
//                pessoaret.setNumero(resultSet.getString("numero"));
//                pessoaret.setCidade(resultSet.getString("cidade"));
//                pessoaret.setCep(resultSet.getString("cep"));
//                pessoaret.setPontoReferencia(resultSet.getString("Ponto de Referencia"));
//                pessoaret.setEmail(resultSet.getString("Email"));
//                pessoaret.setSenha(resultSet.getString("Senha"));
//        }
//        resultSet.close();
//        ps.close();
//        ConexaoBancoOracle.fecharConexao();
//        return pessoaret;
//    }
//    
//       
//    public List<Pessoa> pesquisaGeral(Pessoa pessoa) throws SQLException, ClassNotFoundException, ErroSistema{
//       
//        List<Pessoa> pessoasret = new LinkedList<Pessoa>();
//         String sql = "SELECT NOME, CPF, RG, TELEFONE, RUA, BAIRRO, ESTADO, "
//                + "NUMERO, CIDADE, CEP, PONTOREFERENCIA, EMAIL, SENHA"
//                + "FROM TB_PESSOA";
//        
//        Connection conexao = ConexaoBancoOracle.getConexao();
//        PreparedStatement ps = conexao.prepareStatement(sql);
//        ResultSet resultSet = ps.executeQuery();
//        
//        while ( resultSet.next() ){
//            
//            pessoasret.add(new Pessoa(resultSet.getInt("idCadastroPessoa"),
//                                        resultSet.getString("nome"),
//                                        resultSet.getString("cpf"),
//                                        resultSet.getString("rg"),
//                                        resultSet.getString("telefone"),
//                                        resultSet.getString("rua"),
//                                        resultSet.getString("bairro"),
//                                        resultSet.getString("estado"),
//                                        resultSet.getString("numero"),
//                                        resultSet.getString("cidade"),
//                                        resultSet.getString("pontodeReferencia"),
//                                        resultSet.getString("email"),
//                                        resultSet.getString("sennha")) );
//            
//            
//        resultSet.close();
//        ps.close();
//        ConexaoBancoOracle.fecharConexao();
//        return pessoasret;
//        
//        
//         d       
//        }
    }

     
        
        
        
        
        
        
        