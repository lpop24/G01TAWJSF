/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import java.util.Locale;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Loubna Channouf Cherradi
 */
@Named(value = "idiomasBean")
@RequestScoped
public class IdiomasBean implements Serializable{
    
   
    /**
     * Creates a new instance of IdiomasBean
     */
    public IdiomasBean() {
    }
    
    
  public String changeLang(String langCode) {
       FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale (langCode));
      
       return null;
}
    
}
