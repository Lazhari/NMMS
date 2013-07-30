/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

import java.util.ArrayList;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Permet de créer des arbre JTree à partir des schema 
 * @author lazhari
 */
public class SchemaViewer {

    /**
     * Liste des schéma
     */
    /*ArrayList<Schema> listSchema = new ArrayList();
    
     public ArrayList<Schema> getListSchema() {
     return listSchema;
     }
     public void addSchema(Schema s) {
     listSchema.add(s);
     }
     */
    /**
     * Préseantation d'une liste des schémas
     *
     * @param listSchema : liste des schéma
     * @return DefaultMutableTreeNode
     */
    public static DefaultMutableTreeNode getTreeSchema(ArrayList<Schema> listSchema) {
        //Racine de l'arbre 
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("schema");
        //Parcours de liste des schéma 
        for (int i = 0; i < listSchema.size(); i++) {
            //Nom de Schema 
            DefaultMutableTreeNode sh = new DefaultMutableTreeNode(listSchema.get(i).getNomSchema());
            if (!listSchema.get(i).getListElement().isEmpty()) {
                //Noeud contient tous les elements de schéma 
                DefaultMutableTreeNode element = new DefaultMutableTreeNode("Les élements :");
                for (Elements e : listSchema.get(i).getListElement()) {
                    DefaultMutableTreeNode elet = new DefaultMutableTreeNode(e.getNomElement() + " [" + e.getTypeElement() + "]");
                    element.add(elet);

                }
                sh.add(element);
            }
            if (!listSchema.get(i).getListAttribut().isEmpty()) {
                //Noeud Contient les attributs d'un schema 
                DefaultMutableTreeNode attributs = new DefaultMutableTreeNode("Les attributs :");
                for (Attribut att : listSchema.get(i).getListAttribut()) {
                    DefaultMutableTreeNode elet = new DefaultMutableTreeNode(att.getNomElement() + " [" + att.getTypeElement() + "]");
                    attributs.add(elet);

                }
                sh.add(attributs);
            }
            racine.add(sh);
        }
        return racine;
    }
    /**
     * Présenter une schéma 
     * @param schema
     * @return  DefaultMutableTreeNode racine de l'arbre JTree
     */
    public static DefaultMutableTreeNode getTreeSchema(Schema schema) {
        //Racine de l'arbre 
        DefaultMutableTreeNode racine = new DefaultMutableTreeNode("schema");
        if (schema !=null) {
            //Parcours de liste des schéma 
            //Nom de Schema 
            DefaultMutableTreeNode sh = new DefaultMutableTreeNode(schema.getNomSchema());
            if (!schema.getListElement().isEmpty()) {
                //Noeud contient tous les elements de schéma 
                DefaultMutableTreeNode element = new DefaultMutableTreeNode("Les élements :");
                for (Elements e : schema.getListElement()) {
                    DefaultMutableTreeNode elet = new DefaultMutableTreeNode(e.getNomElement() + " [" + e.getTypeElement() + "]");
                    element.add(elet);

                }
                sh.add(element);
            }
            if (!schema.getListAttribut().isEmpty()) {
                //Noeud Contient les attributs d'un schema 
                DefaultMutableTreeNode attributs = new DefaultMutableTreeNode("Les attributs :");
                for (Attribut att : schema.getListAttribut()) {
                    DefaultMutableTreeNode elet = new DefaultMutableTreeNode(att.getNomElement() + " [" + att.getTypeElement() + "]");
                    attributs.add(elet);

                }
                sh.add(attributs);
            }
            racine.add(sh);
        }
        
        
        return racine;
    }
}
