/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Login;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Usuario
 */
@Stateless
public class LoginFacade extends AbstractFacade<Login> {

    @PersistenceContext(unitName = "RedSocialG01JSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoginFacade() {
        super(Login.class);
    }
    
    public List<Login> encontrarUsuario(String nombre, String password) {
        Query q; 
        
        q = em.createQuery("select c from Login c where c.usuarioLogin like :usuario and c.password like :pass");
        q.setParameter("usuario",  nombre);
        q.setParameter("pass", password);
        return q.getResultList();
    }
    
}
