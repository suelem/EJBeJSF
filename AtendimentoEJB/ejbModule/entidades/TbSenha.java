/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Suelem
 */
@Entity
@Table(name = "tb_senha")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "TbSenha.findAll", query = "SELECT t FROM TbSenha t where senhaStatus = 0")
	, @NamedQuery(name = "TbSenha.findByPkSenha", query = "SELECT t FROM TbSenha t WHERE t.pkSenha = :pkSenha")
	, @NamedQuery(name = "TbSenha.findByData", query = "SELECT t FROM TbSenha t WHERE t.data = :data")})
public class TbSenha implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "pk_senha")
	private String pkSenha;
	@Basic(optional = false)
	@Column(name = "data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	@JoinColumn(name = "fk_senha_pessoa", referencedColumnName = "cpf")
	@ManyToOne(optional = false)
	private TbPessoa fkSenhaPessoa;
	@Basic(optional = true)
	@Column(name = "senhaStatus")
	private Integer senhaStatus;

	public TbSenha() {
	}

	public TbSenha(String pkSenha) {
		this.pkSenha = pkSenha;
	}

	public TbSenha(String pkSenha, Date data) {
		this.pkSenha = pkSenha;
		this.data = data;
	}

	public String getPkSenha() {
		return pkSenha;
	}

	public void setPkSenha(String pkSenha) {
		this.pkSenha = pkSenha;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TbPessoa getFkSenhaPessoa() {
		return fkSenhaPessoa;
	}

	public void setFkSenhaPessoa(TbPessoa fkSenhaPessoa) {
		this.fkSenhaPessoa = fkSenhaPessoa;
	}

	public Integer getsenhaStatus() {
		return senhaStatus;
	}

	public void setsenhaStatus(Integer senhaStatus) {
		this.senhaStatus = senhaStatus;
	}
	
	public String getDescricao(){
		if (getsenhaStatus() == 0){
			return "Em espera";
		}else{
			return "Atendido";
		}				
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (pkSenha != null ? pkSenha.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TbSenha)) {
			return false;
		}
		TbSenha other = (TbSenha) object;
		if ((this.pkSenha == null && other.pkSenha != null) || (this.pkSenha != null && !this.pkSenha.equals(other.pkSenha))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "entidades.TbSenha[ pkSenha=" + pkSenha + " ]";
	}

}
