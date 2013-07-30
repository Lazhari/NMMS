/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dark
 */
public class SimilarityAllDetail extends javax.swing.JDialog {

    /**
     * Creates new form SimilarityAllDetail
     */
    public SimilarityAllDetail(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Schema schemaGlobal = Main.getSchemaGlobal();
        ArrayList<Schema> listeSchemaSource = Main.getListeSchemaSource();
        // TODO add your handling code here:
        ArrayList<ElementMapCoef> globalMap = new ArrayList();
        ArrayList<ElementMapCoef> sourceMap = new ArrayList();

        for (Elements elet : schemaGlobal.getListElement()) {
            String nom = elet.getNomElement();
            String type = elet.getTypeElement();
            globalMap.add(new ElementMapCoef(nom, type));
        }
        for (Attribut attr : schemaGlobal.getListAttribut()) {
            String nom = attr.getNomElement();
            String type = attr.getTypeElement();
            globalMap.add(new ElementMapCoef(nom, type));
        }
        for (Schema sh : listeSchemaSource) {
            for (Elements elet : sh.getListElement()) {
                String nom = elet.getNomElement();
                String type = elet.getTypeElement();
                sourceMap.add(new ElementMapCoef(nom, type));
            }
            for (Attribut attr : sh.getListAttribut()) {
                String nom = attr.getNomElement();
                String type = attr.getTypeElement();
                sourceMap.add(new ElementMapCoef(nom, type));
            }
        }
        simAll.setText(Similarity.getAllSimHtml(globalMap, sourceMap));
        simLexLbl.setText(Similarity.getSimSemHtml(globalMap, sourceMap));
        simSemLbl.setText(Similarity.getSimLexHtml(globalMap, sourceMap));

        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        simLexLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        simSemLbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        simAll = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Details of similarity");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(2, 0));

        jPanel2.setLayout(new java.awt.GridLayout(0, 2));

        jScrollPane1.setBackground(new java.awt.Color(175, 168, 161));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lexical Similarity", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(198, 16, 16))); // NOI18N

        simLexLbl.setBackground(new java.awt.Color(255, 255, 255));
        simLexLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        simLexLbl.setText("jLabel1");
        simLexLbl.setOpaque(true);
        jScrollPane1.setViewportView(simLexLbl);

        jPanel2.add(jScrollPane1);

        jScrollPane2.setBackground(new java.awt.Color(175, 168, 161));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Semantic similarity", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(210, 21, 21))); // NOI18N

        simSemLbl.setBackground(new java.awt.Color(255, 255, 255));
        simSemLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        simSemLbl.setText("jLabel2");
        simSemLbl.setOpaque(true);
        jScrollPane2.setViewportView(simSemLbl);

        jPanel2.add(jScrollPane2);

        jPanel1.add(jPanel2);

        jPanel3.setLayout(new java.awt.GridLayout());

        jScrollPane3.setBackground(new java.awt.Color(175, 168, 161));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total similarity", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(200, 23, 23))); // NOI18N

        simAll.setBackground(new java.awt.Color(255, 255, 255));
        simAll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        simAll.setText("jLabel3");
        simAll.setOpaque(true);
        jScrollPane3.setViewportView(simAll);

        jPanel3.add(jScrollPane3);

        jPanel1.add(jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SimilarityAllDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SimilarityAllDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SimilarityAllDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SimilarityAllDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SimilarityAllDetail dialog = new SimilarityAllDetail(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel simAll;
    private javax.swing.JLabel simLexLbl;
    private javax.swing.JLabel simSemLbl;
    // End of variables declaration//GEN-END:variables
}
