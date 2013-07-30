/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

/**
 *
 * @author lazhari
 */
/**
 * Classe attribut permet de stocker les attribut trouver dans une schéma XML
 * @version 0.1
 * @author lazhari Med
 */
public class Attribut {
    /**
     * Les attributs 
     */
    // Nom de l'attribut 
    private String nomAttribut;
    // Type de l'attribut 
    private String typeAttribut;
    
    /**
     * Constructeur par défauts 
     */
    public Attribut() {
        
    }
    /**
     * Construction de l'objet Attribut
     * @param nom :nom de l'attribut
     * @param type : le type de l'attribut
     */
    public Attribut(String nom,String type) {
        nomAttribut = nom;
        typeAttribut = type;
    }
    /**
     * setNom 
     * @param nom : nom de l'attribut
     */
    public void setNomElement(String nom) {
        nomAttribut = nom;
    }
    /**
     * SetType
     * @param type :type d'attribut (String,int,float...)
     */
    public void setTypeElement(String type) {
        typeAttribut = type;
    }
    /**
     * Retourne nom de l'attribut 
     * @return nom de l'attribut
     */
    public String getNomElement(){
        return nomAttribut;
    }
    /**
     * Retourne type de l'attribut 
     * @return type de l'attribut
     */
    public String getTypeElement(){
        return typeAttribut;
    }
    /**
     * méthode toString() : permet d'afficher un attribut 
     * @return 
     */
    @Override
    public String toString(){
        String chaine = "[Attribut : "+nomAttribut+" ,type :"+typeAttribut+" ]";
        return chaine;              
    }
    
}
