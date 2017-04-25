/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import entidades.TbFuncionario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Suelem
 */
@Stateless
public class TbFuncionarioFacade extends AbstractFacade<TbFuncionario> {

    @PersistenceContext(unitName = "Atendimento-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbFuncionarioFacade() {
        super(TbFuncionario.class);
    }
    
}
