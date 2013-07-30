package pfa2;

import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import java.util.ArrayList;

/**
 * Perment de faire de calcul Semantique à partir de wordnet
 *
 * @author lazhari
 */
public class SimilariteSemantique {

    /**
     * Calculer le coefficient semantique
     *
     * @param ch1 : mot 1
     * @param ch2 : mot 2
     * @return float coeffiecient
     */
    public static float getSimSymantiqueSyno(String ch1, String ch2) {
        ArrayList<String> synoCh1 = new ArrayList();
        synoCh1 = getSynomWord(ch1);
        ArrayList<String> synoCh2 = new ArrayList();
        synoCh2 = getSynomWord(ch2);
        ArrayList<String> interSyno = new ArrayList();
        if (ch1.equals(ch2)) {
            return 1;
        }
        //Pour déterminer les intersetion de 2 liste 
        for (int i = 0; i < synoCh1.size(); i++) {
            for (int j = 0; j < synoCh2.size(); j++) {
                if (synoCh1.get(i).equals(synoCh2.get(j))) {
                    interSyno.add(synoCh1.get(i));
                }
            }
        }

        float cof = (float) interSyno.size() / Math.max(synoCh1.size(), synoCh2.size());
        return cof;
    }
    /**
     * Calculer le coefficient semantique
     *
     * @param ch1 : mot 1
     * @param ch2 : mot 2
     * @return float coeffiecient
     */
    public static float getSimSymantiqueHyper(String ch1, String ch2) {
        ArrayList<String> synoCh1 = new ArrayList();
        synoCh1 = getHyberWord(ch1);
        ArrayList<String> synoCh2 = new ArrayList();
        synoCh2 = getHyberWord(ch2);
        ArrayList<String> interSyno = new ArrayList();
        if (ch1.equals(ch2)) {
            return 1;
        }
        //Pour déterminer les intersetion de 2 liste 
        for (int i = 0; i < synoCh1.size(); i++) {
            for (int j = 0; j < synoCh2.size(); j++) {
                if (synoCh1.get(i).equals(synoCh2.get(j))) {
                    interSyno.add(synoCh1.get(i));
                }
            }
        }

        float cof = (float) interSyno.size() / Math.max(synoCh1.size(), synoCh2.size());
        return cof;
    }

    /**
     * Permet de recupérer dans un ArrayList tous les synonyme d'un mot
     *
     * @param mot : mot a chercher
     * @return : ArrayList<String> :liste des synonymes
     */
    public static ArrayList<String> getSynomWord(String mot) {
        //Déclaration d'une liste de//se connecter à la base de données WordNet
        // si vous étes sous Windows ils faut installer wordnet 
        // et au lieu de /home/lazhari/Téléchargements/WordNet-3.0/dict donner le chemin de dictionnaire
        //  type String pour stocker les synonymes 
        ArrayList<String> syno = new ArrayList();
        /*
         * Pour charger WordNet en JAVA et accéder à ces informations avec JAWS il suffit de fixer la propriete
         * wordnet.database.dir avec l’emplacement de dictionnaire du WordNet.
         * si vous étes sous Windows ils faut installer wordnet  remplacer : 
         * System.setProperty("wordnet.database.dir", "C:\\Program Files\\WordNet\\2.1\\dict");
         */
        System.setProperty("wordnet.database.dir", "/home/dark/Téléchargements/WordNet-3.0/dict");
        //Recuperation de l'instance de fichier de base de données 
        WordNetDatabase database = WordNetDatabase.getFileInstance();

        // Déclaration d'un tableau 
        NounSynset nounSynset;
        //récupérer les définition de "mot" passer en argument de fonction de la base données 
        Synset[] synsets = database.getSynsets(mot, SynsetType.NOUN);
        //Parcourir le tableau synsets
        for (int i = 0; i < synsets.length; i++) {
            //récupérer liste de synonyme d'une définition 
            //cast en type NounSynset
            nounSynset = (NounSynset) synsets[i];
            //parcour liste des définition mot par mot 
            for (String syn : nounSynset.getWordForms()) {
                // si le mot est différent de mot passer en argument on l'ajoute 
                // à la liste des synonyme 
                if (!syn.equals(mot)) {
                    //ajouter synonyme a la liste 
                    syno.add(syn);
                }
            }
        }
        // retourner la liste des synonymes 
        return syno;
    }
    public static ArrayList<String> getHyberWord(String mot) {
        //Déclaration d'une liste de//se connecter à la base de données WordNet
        // si vous étes sous Windows ils faut installer wordnet 
        // et au lieu de /home/lazhari/Téléchargements/WordNet-3.0/dict donner le chemin de dictionnaire
        //  type String pour stocker les synonymes 
        ArrayList<String> syno = new ArrayList();
        /*
         * Pour charger WordNet en JAVA et accéder à ces informations avec JAWS il suffit de fixer la propriete
         * wordnet.database.dir avec l’emplacement de dictionnaire du WordNet.
         * si vous étes sous Windows ils faut installer wordnet  remplacer : 
         * System.setProperty("wordnet.database.dir", "C:\\Program Files\\WordNet\\2.1\\dict");
         */
        System.setProperty("wordnet.database.dir", "/home/dark/Téléchargements/WordNet-3.0/dict");
        //Recuperation de l'instance de fichier de base de données 
        WordNetDatabase database = WordNetDatabase.getFileInstance();

        // Déclaration d'un tableau 
        NounSynset nounSynset;
        //récupérer les définition de "mot" passer en argument de fonction de la base données 
        Synset[] synsets = database.getSynsets(mot, SynsetType.NOUN);
        //Parcourir le tableau synsets
        for (int i = 0; i < synsets.length; i++) {
            //récupérer liste de synonyme d'une définition 
            //cast en type NounSynset
            nounSynset = (NounSynset) synsets[i];
            for(NounSynset s : nounSynset.getHyponyms()) {
                if(s != null) {
                    for(String hyp :s.getWordForms() ) {
                        syno.add(hyp);
                    }
                }
            }
            //parcour liste des définition mot par mot 
            for (String syn : nounSynset.getWordForms()) {
                // si le mot est différent de mot passer en argument on l'ajoute 
                // à la liste des synonyme 
                if (!syn.equals(mot)) {
                    //ajouter synonyme a la liste 
                    syno.add(syn);
                }
            }
        }
        // retourner la liste des synonymes 
        return syno;
    }
    /*public static void main(String args[]) {
        int i = 0;
        for(String s : getSynomWord("fight")) {
            System.out.println(s);
            i++;
        }
        System.out.println(i);
    }*/
}
