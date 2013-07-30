/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

import java.util.Arrays;

/**
 *
 * @author dark
 */
public class SimilariteType {
    public static float [][] matricType = {
           { 1.0F, 0.0F ,0.1F ,0.2F ,0.0F ,0.0F,0.0F,0.0F },
           { 0.0F, 1.0F ,0.6F ,0.2F ,0.0F ,0.0F,0.0F,0.0F },
           { 0.1F, 0.6F ,1.0F ,0.3F ,0.1F ,0.1F,0.1F,0.1F },
           { 0.2F, 0.2F ,0.3F ,1.0F ,0.6F ,0.5F,0.2F,0.8F },
           { 0.0F, 0.0F ,0.1F ,0.6F ,1.0F ,0.8F,0.0F,0.3F },
           { 0.0F, 0.0F ,0.1F ,0.5F ,0.8F ,1.0F,0.8F,0.2F },
           { 0.0F, 0.0F ,0.1F ,0.2F ,0.0F ,0.8F,1.0F,0.0F },
           { 0.0F, 0.0F ,0.2F ,0.8F ,0.3F ,0.2F,0.0F,1.0F }
       };
    public static String[] typeIndex = {"boolean","float","int","string","date","date-time","time","symbole"};
    
    public static float getSimilariteType(String type1,String type2) {
        if(getIndexType(type1) !=-1 && getIndexType(type2) !=-1) {
            return matricType[getIndexType(type1)][getIndexType(type2)];
        }
        if(type1.equals(type2)) {
            return 1.0F;
        }
        else
            return 0.0F;
    }
    private static int getIndexType(String typeNom) {
        int index = -1;
        for(int i=0;i<typeIndex.length;i++) {
            if(typeIndex[i].equals(typeNom)) {
                index = i;
            }
        }
        return index;
    }
    public static String afficheConfigueTable() {
        String infos = "<html><table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" style=\"font-size:7px;text-align: center;\">\n" +
"			<tr style=\"font-weight: bold;\" bgcolor=\"green\">\n" +
"				<td></td>\n" +
"				<td>Boolean</td>\n" +
"				<td>Float</td>\n" +
"				<td>Int</td>\n" +
"				<td>String</td>\n" +
"				<td>Date</td>\n" +
"				<td>Date-time</td>\n" +
"				<td>Time</td>\n" +
"				<td>Symbole</td>\n" +
"			</tr>";
        for(int i=0;i<typeIndex.length;i++) {
            infos += "<tr><td style=\"font-weight: bold;\" bgcolor=\"#66AA\">"+typeIndex[i]+"</td>";
            for(int j=0;j<typeIndex.length;j++){
                infos += "<td>"+String.valueOf(matricType[i][j])+"</td>";
            }
            infos +="</tr>";
        }
        infos +="</table>";
        return infos;
    }
}
