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
@Table(name = "tb_endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbEndereco.findAll", query = "SELECT t FROM TbEndereco t")
    , @NamedQuery(name = "TbEndereco.findByPkEndereco", query = "SELECT t FROM TbEndereco t WHERE t.pkEndereco = :pkEndereco")
    , @NamedQuery(name = "TbEndereco.findByCep", query = "SELECT t FROM TbEndereco t WHERE t.cep = :cep")
    , @NamedQuery(name = "TbEndereco.findByEstado", query = "SELECT t FROM TbEndereco t WHERE t.estado = :estado")
    , @NamedQuery(name = "TbEndereco.findByCidade", query = "SELECT t FROM TbEndereco t WHERE t.cidade = :cidade")
    , @NamedQuery(name = "TbEndereco.findByBairro", query = "SELECT t FROM TbEndereco t WHERE t.bairro = :bairro")
    , @NamedQuery(name = "TbEndereco.findByRua", query = "SELECT t FROM TbEndereco t WHERE t.rua = :rua")
    , @NamedQuery(name = "TbEndereco.findByNumero", query = "SELECT t FROM TbEndereco t WHERE t.numero = :numero")
    , @NamedQuery(name = "TbEndereco.findByComplemento", query = "SELECT t FROM TbEndereco t WHERE t.complemento = :complemento")})
public class TbEndereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pk_endereco")
    private Integer pkEndereco;
    @Basic(optional = false)
    @Column(name = "cep")
    private int cep;
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
    private int numero;
    @Column(name = "complemento")
    private String complemento;
    @JoinColumn(name = "fk_pessoa_endereco", referencedColumnName = "cpf")
    @ManyToOne(optional = false)
    private TbPessoa fkPessoaEndereco;

    public TbEndereco() {
    }

    public TbEndereco(Integer pkEndereco) {
        this.pkEndereco = pkEndereco;
    }

    public TbEndereco(Integer pkEndereco, int cep, String estado, String cidade, String bairro, String rua, int numero) {
        this.pkEndereco = pkEndereco;
        this.cep = cep;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
    }

    public Integer getPkEndereco() {
        return pkEndereco;
    }

    public void setPkEndereco(Integer pkEndereco) {
        this.pkEndereco = pkEndereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public TbPessoa getFkPessoaEndereco() {
        return fkPessoaEndereco;
    }

    public void setFkPessoaEndereco(TbPessoa fkPessoaEndereco) {
        this.fkPessoaEndereco = fkPessoaEndereco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkEndereco != null ? pkEndereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TbEndereco)) {
            return false;
        }
        TbEndereco other = (TbEndereco) object;
        if ((this.pkEndereco == null && other.pkEndereco != null) || (this.pkEndereco != null && !this.pkEndereco.equals(other.pkEndereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbEndereco[ pkEndereco=" + pkEndereco + " ]";
    }
    
}
