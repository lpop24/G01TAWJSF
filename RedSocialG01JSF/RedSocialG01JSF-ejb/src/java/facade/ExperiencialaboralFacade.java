/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Experiencialaboral;
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
public class ExperiencialaboralFacade extends AbstractFacade<Experiencialaboral> {

    @PersistenceContext(unitName = "RedSocialG01JSF-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExperiencialaboralFacade() {
        super(Experiencialaboral.class);
    }
    
    public List<Experiencialaboral> findExpLaboral(int idUsuario) {
        Query q; 
        
        q = em.createQuery("select e from Experiencialaboral e where e.expLaboralUsuarioFK.idUsuario like :idUsuario");
        q.setParameter("idUsuario", idUsuario);
        return q.getResultList();
    }
}
