
package controller;

import java.io.Serializable
;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidades.TbPessoa;
import modelo.TbPessoaFacade;
/**
 *
 * @author Suelem
 */
@ManagedBean
@SessionScoped
public class PessoaController implements Serializable{
	private static final long serialVersionUID = 1483548704182923676L;

	@EJB
	private TbPessoaFacade tbPessoaFacade;
	private TbPessoa p = new TbPessoa();

	public TbPessoa getP() {
		return p;
	}

	public void setP(TbPessoa p) {
		this.p = p;
	}

	public PessoaController() {
		/*
		 * por convencao, javabeans precisa de um construtor vazio
		 */
	}

	public List<TbPessoa> findAll(){
		return this.tbPessoaFacade.findAll();
	}

	public String add(){
		this.tbPessoaFacade.create(this.p);
		this.p = new TbPessoa();
		return "index";
	}

	public void delete (TbPessoa p){
		this.tbPessoaFacade.remove(p);
	}

	public String edit (TbPessoa p){
		this.p = p;
		return "edit";			
	}

	public String edit (){
		this.tbPessoaFacade.edit(this.p);
		this.p = new TbPessoa();
		return "index";		

	}

	public List<TbPessoa> findByNome(TbPessoa p){
		return tbPessoaFacade.findByNome(this.p);
	}
	
	public String findByNome(){
		this.tbPessoaFacade.findByNome(this.p);
		return "findBtNomeResult";
	}
	
	public List<TbPessoa> findByCpf(TbPessoa p){
		return tbPessoaFacade.findByCpf(this.p);
	}
	
	public String findByCpf(){
		this.tbPessoaFacade.findByCpf(this.p);
		return "findBtCpfResult";
	}
}
