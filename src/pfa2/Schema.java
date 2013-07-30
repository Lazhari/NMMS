/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

import java.util.ArrayList;

/**
 * Présenation d'une schéma 
 * @author lazhari
 */
public class Schema {
    /**
     * Les attributs de schéma 
     */
    private String nomSchema;
    private String typeSchema;
    private ArrayList<Elements> listElement;
    private ArrayList<Attribut> listAttribut;
    
    /**
     * Constructeur de schema 
     * @param nom : nom de schema 
     * @param type : type de schema (globale ou source)
     */
    public Schema(String nom,String type) {
        this.nomSchema = nom;
        this.typeSchema = type;
    }
    public Schema(String nom,String type,ArrayList<Elements> liste,ArrayList<Attribut> listeAttr) {
        this.nomSchema = nom;
        this.typeSchema = type;
        listElement = liste;
        listAttribut = listeAttr;
    }
    /**
     * setNom 
     * @param nom : nom de schema
     */
    public void setNomSchema(String nom) {
        nomSchema = nom;
    }
    /**
     * setType 
     * @param type :type de schema 
     */
    public void setTypeSchema(String type) {
        typeSchema = type;
    }
    /**
     * 
     * @return nom de schema  
     */
    public String getNomSchema() {
        return nomSchema;
    }
    /**
     * 
     * @return type de schema 
     */
    public String getTypeSchema() {
        return typeSchema;
    }
    
    /**
     * Ajouter un élément à la liste des élément de schéma 
     * @param e :element à ajouter
     */
    public void addElement(Elements e) {
        listElement.add(e);
    }
    
    public ArrayList<Elements> getListElement() {
        return listElement;
    }
    
    public ArrayList<Attribut> getListAttribut() {
        return listAttribut;
    }
    
    @Override
    public String toString() {
        String s = "[ Nom Schéma : "+nomSchema+" ;Type : "+typeSchema +";\n  *Liste éléments :\n";
        for(int i =0;i<listElement.size();i++) {
            s+="\t- "+listElement.get(i).toString()+" \n";
        }
        s+="\n\t*Liste des attributs :\n";
        for(int i =0;i<listAttribut.size();i++) {
            s+="\t- "+listAttribut.get(i).toString()+" \n";
        }
        s+="]";
        
        return s;
    }
    
}
