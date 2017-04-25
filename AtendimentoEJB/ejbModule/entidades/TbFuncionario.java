/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Suelem
 */
@Entity
@Table(name = "tb_funcionario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbFuncionario.findAll", query = "SELECT t FROM TbFuncionario t")
    , @NamedQuery(name = "TbFuncionario.findByPkFuncionario", query = "SELECT t FROM TbFuncionario t WHERE t.pkFuncionario = :pkFuncionario")
    , @NamedQuery(name = "TbFuncionario.findByFuncao", query = "SELECT t FROM TbFuncionario t WHERE t.funcao = :funcao")})
public class TbFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_funcionario")
    private Integer pkFuncionario;
    @Basic(optional = false)
    @Column(name = "funcao")
    private String funcao;
    @JoinColumn(name = "fk_pessoa_funcionario", referencedColumnName = "cpf")
    @ManyToOne(optional = false)
    private TbPessoa fkPessoaFuncionario;

    public TbFuncionario() {
    }

    public TbFuncionario(Integer pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public TbFuncionario(Integer pkFuncionario, String funcao) {
        this.pkFuncionario = pkFuncionario;
        this.funcao = funcao;
    }

    public Integer getPkFuncionario() {
        return pkFuncionario;
    }

    public void setPkFuncionario(Integer pkFuncionario) {
        this.pkFuncionario = pkFuncionario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public TbPessoa getFkPessoaFuncionario() {
        return fkPessoaFuncionario;
    }

    public void setFkPessoaFuncionario(TbPessoa fkPessoaFuncionario) {
        this.fkPessoaFuncionario = fkPessoaFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkFuncionario != null ? pkFuncionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TbFuncionario)) {
            return false;
        }
        TbFuncionario other = (TbFuncionario) object;
        if ((this.pkFuncionario == null && other.pkFuncionario != null) || (this.pkFuncionario != null && !this.pkFuncionario.equals(other.pkFuncionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbFuncionario[ pkFuncionario=" + pkFuncionario + " ]";
    }
    
}
