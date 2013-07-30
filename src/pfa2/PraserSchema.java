/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author lazhari
 */
public class PraserSchema {
    /**
     * Les attributs
     */
    private SAXBuilder build;
    private Document document;
    private Element elementRacine;
    //Liste des elements 
    private ArrayList<Elements> listElement = new ArrayList();
    //Liste des attribut
    private ArrayList<Attribut> listAttribut = new ArrayList();
    //private String fileName;
    //composition des element complexe 
    private String infosElementComplexe;
    
    public PraserSchema(String fileName) {
        try {
            build = new SAXBuilder();
            document = build.build(new File(fileName));
            elementRacine = document.getRootElement();
            getAllElement(elementRacine);
            getAllAttribut(elementRacine);
            afficherFils(elementRacine);
        }
        catch(JDOMException | IOException e) {
            
        }
        
    }
    /**
     * Retourner l'élement racine de schéma XML
     * @return 
     */
    public Element getElementRacine() {
        return elementRacine;
    }
    /**
     * Retourne liste des elements 
     * @return 
     */
    public ArrayList<Elements> getListElement() {
        return listElement;
    }
    /**
     * Permet de retourner liste des attributs contituant un schéma 
     * @return 
     */
    public ArrayList<Attribut> getListAttribut() {
        return listAttribut;
    }
    public String getInfosElementComplexe() {
        return infosElementComplexe;
    }
    
    /**
     * Return tous les elements d'un schema 
     * @param element 
     */
    public void getAllElement(Element element) {
        Elements elementcourant;
        if (element.getName().equals("element")) {

            if (element.getAttributeValue("name") != null & element.getAttributeValue("type") == null) {
                //System.out.println("Type Complexe :name = " + element.getAttributeValue("name")
                       // + " Type =" + element.getAttributeValue("type"));
                elementcourant = new Elements(element.getAttributeValue("name"),"ComplexType");
                listElement.add(elementcourant);
            }
            if (element.getAttributeValue("name") != null & element.getAttributeValue("type") != null) {
                //System.out.println("Type Simple :name = " + element.getAttributeValue("name")
                       // + " Type =" + element.getAttributeValue("type"));
                elementcourant = new Elements(element.getAttributeValue("name"),element.getAttributeValue("type").substring(3).trim());
                listElement.add(elementcourant);
            }
        }
        List fils = element.getChildren();
        Iterator i = fils.iterator();
        while (i.hasNext()) {
            Element elementFils = (Element) i.next();
            getAllElement(elementFils);
        }
    }
    /**
     * Permet de créer liste des attribut 
     * @param element :élément JDom courant 
     */
    public void getAllAttribut(Element element) {
        Attribut attributCourant;
        if (element.getName().equals("attribute")) {
            //System.out.println("attribut :name = " + element.getAttributeValue("name")
                    //+ " Type =" + element.getAttributeValue("type"));
            //Création de l'attribut 
            attributCourant = new Attribut(element.getAttributeValue("name"),element.getAttributeValue("type").substring(3).trim());
            listAttribut.add(attributCourant);
        }
        List fils = element.getChildren();
        Iterator i = fils.iterator();
        while (i.hasNext()) {
            Element elementFils = (Element) i.next();
            getAllAttribut(elementFils);
        }
    }
    
    public void afficherFils(Element element) {
        StringBuilder ligne = new StringBuilder();
        //ligne.append(element.getName());
        if (element.getName().equals("element")) {

            if (element.getAttributeValue("type") == null && element.getAttributeValue("name") != null) {
                infosElementComplexe+="Type Complexe :name = " + element.getAttributeValue("name")
                        + " Type =" + element.getAttributeValue("type")+"\n";
                List ComplexType = element.getChildren();
                Iterator i = ComplexType.iterator();
                while (i.hasNext()) {
                    Element courantComplex = (Element) i.next();
                    if (courantComplex.getName().equals("complexType")) {
                        List listElement = courantComplex.getChildren();
                        Iterator j = listElement.iterator();
                        while (j.hasNext()) {
                            Element sequence = (Element) j.next();
                            if (sequence.getName().equals("sequence")
                                    || sequence.getName().equals("choice")
                                    || sequence.getName().equals("all")) {
                                List ElementCourants = sequence.getChildren();
                                Iterator k = ElementCourants.iterator();
                                while (k.hasNext()) {
                                    Element elementC = (Element) k.next();
                                    if (elementC.getAttributeValue("name") != null) {
                                        infosElementComplexe+="\t Fils :name = " + elementC.getAttributeValue("name")
                                                + " Type =" + elementC.getAttributeValue("type")+"\n";
                                    }
                                    if (elementC.getAttributeValue("ref") != null) {
                                        infosElementComplexe+="\t Fils :name = " + elementC.getAttributeValue("ref")+"\n";
                                    }
                                }

                            }
                            if (sequence.getName().equals("attribute")) {
                                infosElementComplexe+="\t attribut Fils :name = " + sequence.getAttributeValue("name")
                                        + " Type =" + sequence.getAttributeValue("type")+"\n";
                            }
                        }
                    }
                }
            }
        }
        List fils = element.getChildren();
        Iterator i = fils.iterator();
        while (i.hasNext()) {
            Element elementFils = (Element) i.next();
            afficherFils(elementFils);
        }
    }
    
}
