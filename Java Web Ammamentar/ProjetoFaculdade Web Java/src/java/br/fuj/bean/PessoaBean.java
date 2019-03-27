
/**
 * Projeto Ammamentar / Faculdade Unijorge Materia (Projetor integrador)
 * @author Otávio Neto 
 */
package br.fuj.bean;

import br.fuj.dao.PessoaDAO;
import br.fuj.entity.Pessoa;
import br.fuj.exception.ErroSistema;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Classe responsavel por gerencia os controll da entity Pessoa com a view
 */
public class PessoaBean {

    private Pessoa pessoa = new Pessoa();
    private List<Pessoa> pessoas = new ArrayList<>();
    private PessoaDAO pessoaDAO = new PessoaDAO();

    /**
     * faz a conexão entre a view e o Banco de dados Adicionando o usuario
     */
    public void adicionar() throws SQLException, ErroSistema {
        try {
        pessoaDAO.salvar(pessoa);
        pessoa = new Pessoa();
            adicionarMensagem("Salvo!", "Pessoa salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }

    }
    
    /**
     * Lista todos os usuarios do  banco de dados Cadastrado na view
     */
    public void listar() throws ErroSistema, SQLException {
        try {
            pessoas = pessoaDAO.buscar();
            if (pessoas == null || pessoas.size() == 0) {

                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum pessoa!", FacesMessage.SEVERITY_WARN);
            }

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    /**
     * Deleta os cadastro selecionado 
     * @param pessoa
     */
    public void deletar(Pessoa pessoa) throws ErroSistema {
        try {
            pessoaDAO.deletar(pessoa.getIdCadastroPessoa());

            adicionarMensagem("Deletado!", "Pessoa deletado com sucesso!", FacesMessage.SEVERITY_INFO);

        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void editar(Pessoa p) {
        pessoa = p;
    }
 public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    
    
   

}
