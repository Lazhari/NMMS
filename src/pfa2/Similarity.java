/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author dark
 */
public class Similarity {
    
    public static String getAllSimHtml(ArrayList<ElementMapCoef> globalMap, ArrayList<ElementMapCoef> sourceMap) {
        ConfParamFile conf = new ConfParamFile();
        float poidsName = conf.getPoidsName();
        float poidsType = conf.getPoidsType();
        float alpha = conf.getAlpha();
        float beta = conf.getBeta();
        String simAll = "<html><table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" style=\"font-size: 8px;\">\n"
                + "		<tr>\n"
                + "			<td></td>";
        for(ElementMapCoef elet : globalMap) {
            simAll +="<td style=\"background-color: #00a9e0;text-align: center;font-weight: bold;\">"+elet.getNom()+"</td>";
        }
        simAll +="</tr>";
        for (ElementMapCoef eletSrc : sourceMap) {
            simAll+="<tr><td style=\"background-color: #67cddc;font-weight: bold;\">"+eletSrc.getNom()+"</td>";
            for (ElementMapCoef elet : globalMap) {

                float simType = SimilariteType.getSimilariteType(elet.getType(), eletSrc.getType());
                // similarité lexicale
                float simLex = SimilariteLexecal.similariteLexical(elet.getNom(), eletSrc.getNom());
                // similarité semantique synonymes
                float simSemanSyno = SimilariteSemantique.getSimSymantiqueSyno(elet.getNom().toLowerCase(), eletSrc.getNom().toLowerCase());
                // similarité semantique hypenames 
                float simSemanHyper = SimilariteSemantique.getSimSymantiqueHyper(elet.getNom().toLowerCase(), eletSrc.getNom().toLowerCase());
                float simLexical = (poidsName * simLex + poidsType * simType) / (poidsName + poidsType);
                float simSemantique = (poidsName * simSemanHyper + poidsType * simSemanSyno) / (poidsName + poidsType);
                if(Math.round((alpha * simLexical + beta * simSemantique) * 1000.0000F) / 1000.0000F >0.5F){
                    simAll+="<td style=\"background-color: #779438;\">"+String.valueOf(Math.round((alpha * simLexical + beta* simSemantique) * 1000.0000F) / 1000.0000F)+"</td>";
                }
                else if (Math.round((alpha * simLexical + beta * simSemantique) * 1000.0000F) / 1000.0000F ==0) {
                    simAll+="<td style=\"background-color: #333333;\"></td>";
                }
                else {
                    
                    simAll+="<td>"+String.valueOf(Math.round((alpha * simLexical + beta * simSemantique) * 1000.0000F) / 1000.0000F)+"</td>";
                }
            }
            simAll +="</tr>";
        }
        simAll+="</table>";
        return simAll;
    }
    public static String getSimLexHtml(ArrayList<ElementMapCoef> globalMap, ArrayList<ElementMapCoef> sourceMap) {
        ConfParamFile conf = new ConfParamFile();
        float poidsName = conf.getPoidsName();
        float poidsType = conf.getPoidsType();
        float alpha = conf.getAlpha();
        float beta = conf.getBeta();
        DecimalFormat df = new DecimalFormat("0.000");
        String simAll = "<html><table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" style=\"font-size: 8px;\">\n"
                + "		<tr>\n"
                + "			<td></td>";
        for(ElementMapCoef elet : globalMap) {
            simAll +="<td style=\"background-color: #00a9e0;text-align: center;font-weight: bold;\">"+elet.getNom()+"</td>";
        }
        simAll +="</tr>";
        for (ElementMapCoef eletSrc : sourceMap) {
            simAll+="<tr><td style=\"background-color: #67cddc;font-weight: bold;\">"+eletSrc.getNom()+"</td>";
            for (ElementMapCoef elet : globalMap) {

                float simType = SimilariteType.getSimilariteType(elet.getType(), eletSrc.getType());
                // similarité lexicale
                float simLex = SimilariteLexecal.similariteLexical(elet.getNom(), eletSrc.getNom());
                // similarité semantique synonymes
                float simLexical = (poidsName * simLex + poidsType * simType) / (poidsName + poidsType);
                if( simLexical >0.5F){
                    simAll+="<td style=\"background-color: #779438;\">"+ df.format(simLexical)+"</td>";
                }
                else if (simLexical ==0) {
                    simAll+="<td style=\"background-color: #333333;\"></td>";
                }
                else {
                    
                    simAll+="<td>"+df.format(simLexical)+"</td>";
                }
            }
            simAll +="</tr>";
        }
        simAll+="</table>";
        return simAll;
    }
    
    public static String getSimSemHtml(ArrayList<ElementMapCoef> globalMap, ArrayList<ElementMapCoef> sourceMap) {
        ConfParamFile conf = new ConfParamFile();
        float poidsName = conf.getPoidsName();
        float poidsType = conf.getPoidsType();
        float alpha = conf.getAlpha();
        float beta = conf.getBeta();
        DecimalFormat df = new DecimalFormat("0.000");
        String simAll = "<html><table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" style=\"font-size: 8px;\">\n"
                + "		<tr>\n"
                + "			<td></td>";
        for(ElementMapCoef elet : globalMap) {
            simAll +="<td style=\"background-color: #00a9e0;text-align: center;font-weight: bold;\">"+elet.getNom()+"</td>";
        }
        simAll +="</tr>";
        for (ElementMapCoef eletSrc : sourceMap) {
            simAll+="<tr><td style=\"background-color: #67cddc;font-weight: bold;\">"+eletSrc.getNom()+"</td>";
            for (ElementMapCoef elet : globalMap) {

                float simSemanSyno = SimilariteSemantique.getSimSymantiqueSyno(elet.getNom().toLowerCase(), eletSrc.getNom().toLowerCase());
                // similarité semantique hypenames 
                float simSemanHyper = SimilariteSemantique.getSimSymantiqueHyper(elet.getNom().toLowerCase(), eletSrc.getNom().toLowerCase());
                float simSemantique = (poidsName * simSemanHyper + poidsType * simSemanSyno) / (poidsName + poidsType);
                if( simSemantique >0.5F){
                    simAll+="<td style=\"background-color: #779438;\">"+ df.format(simSemantique)+"</td>";
                }
                else if (simSemantique ==0) {
                    simAll+="<td style=\"background-color: #333333;\"></td>";
                }
                else if(simSemantique >0 && simSemantique <0.5F) {
                    simAll+="<td>"+df.format(simSemantique)+"</td>";
                    
                }
                else {
                    
                    simAll+="<td style=\"background-color: #333333;\"></td>";
                }
            }
            simAll +="</tr>";
        }
        simAll+="</table>";
        return simAll;
    }
}
