
/**
 * Projeto Ammamentar / Faculdade Unijorge Materia (Projetor integrador)
 * @author Otávio Neto 
 * Classe Responsavel de fazer a coneexão entre Entity é o banco de dados
 */
package br.fuj.bean;

import br.fuj.dao.EnderecoDAO;
import br.fuj.dao.PessoaDAO;
import br.fuj.entity.Endereco;
import br.fuj.entity.Pessoa;
import br.fuj.exception.ErroSistema;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class EnderecoBean {

    /**
     * Creates a new instance of EnderecoBean
     */
    private Endereco endereco = new Endereco();
    private List<Endereco> enderecos = new ArrayList<>();
    private EnderecoDAO enderecoDAO = new EnderecoDAO();

    /**
     * faz a conexão entre a view e o Banco de dados Adicionando o endereço
     * @throws SQLException
     * @throws ErroSistema 
     */
    public void adicionar() throws SQLException, ErroSistema {
        try {
        enderecoDAO.salvar(endereco);
        endereco = new Endereco();
            adicionarMensagem("Salvo!", "Endereço salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }
    
    /**
     * Lista todos os endereço do  banco de dados Cadastrado
     * @throws ErroSistema
     * @throws SQLException 
     */
    public void listar() throws ErroSistema, SQLException {
        try {
            enderecos = enderecoDAO.buscar();
            if (enderecos == null || enderecos.size() == 0) {

                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum pessoa!", FacesMessage.SEVERITY_WARN);
            }

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     * Deleta os endereço selecionado
     * @param endereco
     * @throws ErroSistema 
     */
    public void deletar(Endereco endereco) throws ErroSistema {
        try {
            enderecoDAO.deletar(endereco.getId_endereco());

            adicionarMensagem("Deletado!", "Endereco deletado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void editar(Endereco e) {
        endereco = e;
    }
 public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    
    public EnderecoBean() {
    }
    
}
