
package controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.TbSenhaFacade;
import entidades.*;
import java.util.List;
import modelo.TbPessoaFacade;

/**
 *
 * @author Suelem
 */
@ManagedBean
@SessionScoped
public class SenhaController implements Serializable {
	private static final long serialVersionUID = 1483548704182923676L;

	@EJB
	private TbSenhaFacade tbSenhaFacade;
	//private TbPessoaFacade tbPessoaFacade;
	private TbSenha s = new TbSenha();
	private TbPessoa p = new TbPessoa();
	private String tipoSenha = new String();

	char[] chars = { 'N', 'P' };
	int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	private int cont1 = 1;
	private int cont2 = 0;
	private int cont3 = 0;
	private int cont4 = 0;


	public TbSenha getS() {
		return s;
	}

	public void setS(TbSenha s) {
		this.s = s;
	}

	public SenhaController() {
		/*
		 * por convencao, javabeans precisa de um construtor vazio
		 */
	}

	public TbPessoa getP() {
		return p;
	}

	public void setP(TbPessoa p) {
		this.p = p;
	}

	public String getTipoSenha() {
		return tipoSenha;
	}

	public void setTipoSenha(String tipoSenha) {
		this.tipoSenha = tipoSenha;
	}

	public String gerarSenha() {
		// algoritmo gerador da senha numerica

		java.util.Date data = new java.util.Date();
		java.sql.Date datasql = new java.sql.Date(data.getTime());
		s.setData(datasql);

		System.out.println("ESTA É A DATA: " + datasql);
		 
		cont1++;
		if (cont1 >= 10) {
			cont1 = 0;
			cont2++;
		}

		if (cont2 >= 10) {
			cont2 = 0;
			cont3++;
		}

		if (cont3 >= 10) {
			cont3 = 0;
			cont4++;
		}

		if (cont4 >= 10) {
			cont4 = 0;
		}
		// -----------------------

		StringBuilder buffer = new StringBuilder();
		buffer.append(tipoSenha); // 'N' para normal ou 'P' para prioritaria (essa
							// parte aqui o botão vai enviar o valor 'N' ou
							// 'P',então trocamos para uma variável)
		buffer.append(nums[cont4]);
		buffer.append(nums[cont3]);
		buffer.append(nums[cont2]);
		buffer.append(nums[cont1]);

		String senha = buffer.toString();
		s.setPkSenha(senha);
		
		s.setsenhaStatus(0);		
		s.setFkSenhaPessoa(p);	
		
		this.tbSenhaFacade.create(this.s);
		this.s = new TbSenha();
		return "listaSenha";
	}

	public List<TbSenha> findAllSenha() {
		return this.tbSenhaFacade.findAllSenha();
	}

	public String add() {
		this.tbSenhaFacade.create(this.s);
		this.s = new TbSenha();
		return "index";
	}

	public String edit(TbSenha s) {
		this.s = s;
		this.s.setsenhaStatus(1);
		this.tbSenhaFacade.edit(this.s);
		return "listaSenha";
	}
}
