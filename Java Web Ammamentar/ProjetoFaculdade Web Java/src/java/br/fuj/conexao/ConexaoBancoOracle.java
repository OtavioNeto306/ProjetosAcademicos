
/**
 * Projeto Ammamentar / Faculdade Unijorge Materia (Projetor integrador)
 * @author Otávio Neto 
 * Classe Responsavel de fazer a coneexão com o banco de dados 
 */
package br.fuj.conexao;

import br.fuj.exception.ErroSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConexaoBancoOracle {
    
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:oracle:thin:@localhost:1521:XE";
    private static final String USUARIO = "OTAVIO";
    private static final String SENHA = "123";
    
    //C - ORACLE BD - OTAVIO - S - 123
    public static Connection getConexao() throws ErroSistema {
        if(conexao == null){
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");  //"oracle.jdbc.driver.OracleDriver"
                conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
            } catch (SQLException ex) {
                throw new ErroSistema("Não foi possível conectar ao banco de dados!", ex);
            } catch (ClassNotFoundException ex) {
                throw new ErroSistema("O driver do banco de dados não foi encontrado!", ex);
            }
        }
        return conexao;
    }
    
    public static void fecharConexao() throws ErroSistema{
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                throw new ErroSistema("Erro ao fechar conexão com o banco de dados!", ex);
            }
        }
    }
    
}
