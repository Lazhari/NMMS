/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

/**
 * Permet de faire de claculer les similarite lexicale entre les élément 
 * @author lazhari
 */
public class SimilariteLexecal {
    /**
     * Permet de calculer la distance de Levenshtein entre 2 chaine de caractères 
     * @param chaine1
     * @param chaine2
     * @return 
     */
    public static int distance(String chaine1,String chaine2) {
        int [][] d = new int [chaine1.length()+1][chaine2.length()+1];
	int i,j,cout;
	for (i=0;i< chaine1.length(); i++) {
            d[i][0] = i;
	}
	for (j=0;j<chaine2.length() ;j++ ) {
            d[0][j] = j;
	}
	for (i=1;i<=chaine1.length(); i++) {
            for (j=1;j<=chaine2.length() ;j++ ) {
                if(chaine1.charAt(i-1) == chaine2.charAt(j-1))
                    cout = 0;
                else
                    cout = 1;
                d[i][j] = min(d[i-1][j]+1,d[i][j-1]+1,d[i-1][j-1]+cout);
                
            }
        }
	return d[chaine1.length()][chaine2.length()];
    }
    private static int min(int a,int b,int c) {
        return Math.min(a,Math.min(b, c));
    }
    /**
     * donne la portion de la similarité lexicale 
     * @param chaine1
     * @param chaine2
     * @return 
     */
    public static float similariteLexical(String chaine1,String chaine2 ){
        return (1-(float)distance(chaine1,chaine2)/(chaine1.length()+chaine2.length()));
    } 
    /**
     * Similarité lexical type 
     * @param type1 type de l'élément 1 
     * @param type2 type élément 2 
     * @param coef coefficient définit par l'administrateur 
     * @return float coef 
     */
    public static float similariteLexicalType(String type1,String type2 ,float coef){
        if(type1.equals(type2)) {
            return 1;
        }
        return coef;
    }
}
