/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import entidades.*;
import modelo.TbFuncionarioFacade;

import java.util.List;
/**
 *
 * @author Suelem
 */
@ManagedBean
@SessionScoped
public class FuncionarioController implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8518262797799304756L;
	@EJB
	private TbFuncionarioFacade tbFuncionarioaFacade;

	public FuncionarioController() {
		/*
		 * por convencao, javabeans precisa de um construtor vazio
		 */
	}

	public List<TbFuncionario> findAll(){
		return this.tbFuncionarioaFacade.findAll();
	}
	

}



