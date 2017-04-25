/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Suelem
 */
@Entity
@Table(name = "tb_pessoa")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "TbPessoa.findAll", query = "SELECT t FROM TbPessoa t"),
@NamedQuery(name = "TbPessoa.findByNome", query = "SELECT t FROM TbPessoa t WHERE t.nome like :nome"),
@NamedQuery(name = "TbPessoa.findByCpf", query = "SELECT t FROM TbPessoa t WHERE t.cpf = :cpf"),
@NamedQuery(name = "TbPessoa.buscar", query = "SELECT t FROM TbPessoa t WHERE t.cpf = :cpf"),
@NamedQuery(name = "TbPessoa.findByRg", query = "SELECT t FROM TbPessoa t WHERE t.rg = :rg") })
public class TbPessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "cpf")
	private String cpf;
	@Basic(optional = false)
	@Column(name = "nome")
	private String nome;
	@Basic(optional = false)
	@Column(name = "rg")
	private String rg;
	@Basic(optional = false)
	@Column(name = "cep")
	private String cep;
	@Basic(optional = false)
	@Column(name = "estado")
	private String estado;
	@Basic(optional = false)
	@Column(name = "cidade")
	private String cidade;
	@Basic(optional = false)
	@Column(name = "bairro")
	private String bairro;
	@Basic(optional = false)
	@Column(name = "rua")
	private String rua;
	@Basic(optional = false)
	@Column(name = "numero")
	private Integer numero;
	@Column(name = "complmento")
	private String complemento;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPessoaEndereco")
	private List<TbEndereco> tbEnderecoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPessoaFuncionario")
	private List<TbFuncionario> tbFuncionarioList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkSenhaPessoa")
	private List<TbSenha> tbSenhaList;

	public TbPessoa() {
	}

	public TbPessoa(String cpf) {
		this.cpf = cpf;
	}

	public TbPessoa(String cpf, String nome, String rg) {
		this.cpf = cpf;
		this.nome = nome;
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@XmlTransient
	public List<TbEndereco> getTbEnderecoList() {
		return tbEnderecoList;
	}

	public void setTbEnderecoList(List<TbEndereco> tbEnderecoList) {
		this.tbEnderecoList = tbEnderecoList;
	}

	@XmlTransient
	public List<TbFuncionario> getTbFuncionarioList() {
		return tbFuncionarioList;
	}

	public void setTbFuncionarioList(List<TbFuncionario> tbFuncionarioList) {
		this.tbFuncionarioList = tbFuncionarioList;
	}

	@XmlTransient
	public List<TbSenha> getTbSenhaList() {
		return tbSenhaList;
	}

	public void setTbSenhaList(List<TbSenha> tbSenhaList) {
		this.tbSenhaList = tbSenhaList;
	}

	/*
	 * @Override public int hashCode() { int hash = 0; hash += (pkPessoa != null
	 * ? pkPessoa.hashCode() : 0); return hash; }
	 * 
	 * @Override public boolean equals(Object object) { if (!(object instanceof
	 * TbPessoa)) { return false; } TbPessoa other = (TbPessoa) object; if
	 * ((this.pkPessoa == null && other.pkPessoa != null) || (this.pkPessoa !=
	 * null && !this.pkPessoa.equals(other.pkPessoa))) { return false; } return
	 * true; }
	 * 
	 * @Override public String toString() { return
	 * "entidades.TbPessoa[ pkPessoa=" + pkPessoa + " nome=" + nome + " cpf=" +
	 * cpf + " rg=" + rg + " ]"; }
	 */
}
