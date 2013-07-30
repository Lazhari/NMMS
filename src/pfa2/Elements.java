/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

/**
 *
 * @author lazhari
 */
class Elements {
    /**
     * Les attributs 
     */
    private String nomElement;
    private String typeElement;
    
    
    public Elements() {
        
    }
    /**
     * Construction de l'objet Elements
     * @param nom :nom de l'élément
     * @param type : le type de l'élément
     */
    public Elements(String nom,String type) {
        nomElement = nom;
        typeElement = type;
    }
    /**
     * setNom 
     * @param nom : nom de l'élement
     */
    public void setNomElement(String nom) {
        nomElement = nom;
    }
    /**
     * SetType
     * @param type :type d'élément (String,int,float...)
     */
    public void setTypeElement(String type) {
        typeElement = type;
    }
    /**
     * 
     * @return nom de l'élément
     */
    public String getNomElement(){
        return nomElement;
    }
    /**
     * 
     * @return type de l'élément
     */
    public String getTypeElement(){
        return typeElement;
    }
    
    @Override
    public String toString(){
        String chaine = "[Element : "+nomElement+" ,type :"+typeElement+" ]";
        return chaine;              
    }
}
