/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Experiencialaboral;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    
}
