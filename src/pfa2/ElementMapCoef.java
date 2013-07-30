/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

/**
 * Permet d'effectuer un mapping entre schéma Global et Schéma local 
 * @author dark
 */
public class ElementMapCoef {
    private String nom;
    private String type;
    
    public ElementMapCoef(String nom,String type) {
        this.nom = nom;
        this.type = type;
    }
    public String getNom() {
        return nom;
    }
    public String getType() {
        return type;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setType(String type) {
        this.type = type;
    }
}
