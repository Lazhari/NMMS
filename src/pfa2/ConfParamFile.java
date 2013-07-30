/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * Permet de recupérer les paramétre de configuration à partir de fichier de
 * config
 *
 * @author dark
 */
public class ConfParamFile {

    private float poidsName;
    private float poidsType;
    private float alpha;
    private float beta;

    public ConfParamFile() {
        try {
            SAXBuilder build = new SAXBuilder();
            Document doc = build.build(new File(".conf.xml"));
            Element racine = doc.getRootElement();
            this.poidsName = Float.parseFloat(racine.getChild("poidsName").getText());
            this.poidsType = Float.parseFloat(racine.getChild("poidsType").getText());
            this.alpha = Float.parseFloat(racine.getChild("alpha").getText());
            this.beta = Float.parseFloat(racine.getChild("beta").getText());
        } catch (JDOMException | IOException e) {
        }
    }
    
    public float getPoidsName() {
        return poidsName;
    }
    public float getPoidsType() {
        return poidsType;
    }
    public float getAlpha() {
        return alpha;
    }
    public float getBeta() {
        return beta;
    }
    
    public static void changeConf(float poidsName,float poidsType,float alpha,float beta) {
        try {
            SAXBuilder build = new SAXBuilder();
            Document doc = build.build(new File(".conf.xml"));
            Element racine = doc.getRootElement();
            racine.getChild("poidsName").setText(String.valueOf(poidsName));
            racine.getChild("poidsType").setText(String.valueOf(poidsType));
            racine.getChild("alpha").setText(String.valueOf(alpha));
            racine.getChild("beta").setText(String.valueOf(beta));
            //Enregistrement de fichier 
            XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());
            sortie.output(doc, new FileOutputStream(".conf.xml"));
        } catch (JDOMException | IOException e) {
        }
    }

}
