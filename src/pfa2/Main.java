/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pfa2;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

/**
 * Classe main de l'application
 *
 * @author lazhari Med
 * @version 0.1
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form TestUploadSchema
     */
    public Main() {
        initComponents();
        // Changement de type d'icone de JTreeGlobal 
        setIconImage(new ImageIcon("img/icon.png").getImage());
        
        ConfParamFile conf = new ConfParamFile();
        poidsName = conf.getPoidsName();
        poidsType = conf.getPoidsType();
        alpha = conf.getAlpha();
        beta = conf.getBeta();
        //zone infos de configuration 
        infosConfig.setText(SimilariteType.afficheConfigueTable());
        confPoids.setText("<html><table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\n"
                + "			<tr style=\"font-weight: bold;\" bgcolor=\"#6699\" style=\"font-size: 7px;\">\n"
                + "				<td style=\"font-weight: bold;\">Property</td>\n"
                + "				<td style=\"font-weight: bold;\">Coefficient</td>\n"
                + "				\n"
                + "			</tr>\n"
                + "			<tr>\n"
                + "				<td style=\"font-weight: bold;\" bgcolor=\"#6699\">Name</td>\n"
                + "				<td>" + poidsName + "</td>\n"
                + "			</tr>\n"
                + "			<tr>\n"
                + "				<td style=\"font-weight: bold;\" bgcolor=\"#6699\">Type</td>\n"
                + "				<td>" + poidsType + "</td>\n"
                + "			</tr>\n"
                + "		</table>");
        // ajouter les Bouton Radio globalSchemaRadio et sourceSchemaRadio 
        // à GroupRadio typeSchemaRadio
        typeSchemaRadio.add(globalSchemaRadio);
        typeSchemaRadio.add(sourceSchemaRadio);
        globalSchemaRadio.setSelected(true);

    }
    public static Schema getSchemaGlobal() {
        return schemaGlobal;
    }
    public static ArrayList<Schema> getListeSchemaSource() {
        return listeSchemaSource;
    }

    /**
     * Permet de récupérer le type d'un attribut ou un element global
     *
     * @param nomElement : nom de element
     * @return : String type de l'élément
     */
    private String getTypeOfElementGlobal(String nomElement) {
        String typeElement = "";
        if (schemaGlobal != null) {
            for (Elements e : schemaGlobal.getListElement()) {
                if (e.getNomElement().equals(nomElement)) {
                    typeElement = e.getTypeElement();
                }
            }
            for (Attribut a : schemaGlobal.getListAttribut()) {
                if (a.getNomElement().equals(nomElement)) {
                    typeElement = a.getTypeElement();
                }
            }
        }
        return typeElement;
    }

    /**
     * Permet de récupérer le type d'un attribut ou un element global
     *
     * @param nomSchema nom de schema source
     * @param nomElement nom de l'élement
     * @return type de l'élement
     */
    private String getTypeOfElementSource(String nomSchema, String nomElement) {
        String typeElement = "";
        if (!listeSchemaSource.isEmpty()) {
            for (Schema sh : listeSchemaSource) {
                if (sh.getNomSchema().equals(nomSchema)) {
                    for (Elements e : sh.getListElement()) {
                        if (e.getNomElement().equals(nomElement)) {
                            typeElement = e.getTypeElement();
                        }
                    }
                    for (Attribut a : sh.getListAttribut()) {
                        if (a.getNomElement().equals(nomElement)) {
                            typeElement = a.getTypeElement();
                        }
                    }
                }
            }
        }
        return typeElement;
    }

    /**
     * parcourir les schema et créer les combo bosxe
     */
    private void creatComboBox() {
        // initialisation glovalCombo et schemaSourceCombo
        globalCombo.removeAllItems();
        schemaSourceCombo.removeAllItems();
        // parcourir les élément de schema global 
        for (Elements e : schemaGlobal.getListElement()) {
            // ajouter nom d'élément à globalCombo 
            globalCombo.addItem(e.getNomElement());
        }
        // parourir les attributs 
        for (Attribut a : schemaGlobal.getListAttribut()) {
            globalCombo.addItem(a.getNomElement());
        }
        // parcourir liste des schema 
        for (Schema s : listeSchemaSource) {
            schemaSourceCombo.addItem(s.getNomSchema());
            /*for(Elements e : s.getListElement()) {
             eletSourceCombo.addItem(e.getNomElement());
             }*/
        }
    }

    /**
     * Creation de l'arbre JTree
     */
    private void arbre() {
        //ajouter les schema aux arbres 
        schemaTreeGlobal.setModel(new DefaultTreeModel(SchemaViewer.getTreeSchema(schemaGlobal)));
        schemaTreeSource.setModel(new DefaultTreeModel(SchemaViewer.getTreeSchema(listeSchemaSource)));
        //Gestion d'evennement
        /*schemaTreeGlobal.addTreeSelectionListener(new TreeSelectionListener() {
         public void valueChanged(TreeSelectionEvent event) {
         if (schemaTreeGlobal.getLastSelectedPathComponent() != null) {
         String s = schemaTreeGlobal.getLastSelectedPathComponent().toString();
         s = s.replaceAll("[[*]]", " ");
         System.out.println(s);
         //eletGlobalLbl.setText(schemaTreeGlobal.getLastSelectedPathComponent().toString());
         }
         }
         });
         schemaTreeSource.addTreeSelectionListener(new TreeSelectionListener() {
         public void valueChanged(TreeSelectionEvent event) {
         if (schemaTreeSource.getLastSelectedPathComponent() != null) {
         System.out.println(schemaTreeSource.getLastSelectedPathComponent().toString());
         //eletSourceLbl.setText(schemaTreeSource.getLastSelectedPathComponent().toString());
         }
         }
         });*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        typeSchemaRadio = new javax.swing.ButtonGroup();
        contentpanel = new javax.swing.JPanel();
        schemaAdd = new javax.swing.JPanel();
        erreurLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nomSchemaTfd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fileXSDUp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        validerBtn = new javax.swing.JButton();
        annulerBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        globalSchemaRadio = new javax.swing.JRadioButton();
        sourceSchemaRadio = new javax.swing.JRadioButton();
        schemaPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        schemaTreeSource = new javax.swing.JTree();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane9 = new javax.swing.JScrollPane();
        schemaTreeGlobal = new javax.swing.JTree();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        logPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infosSchema = new javax.swing.JTextArea();
        bordPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lexSimPanel = new javax.swing.JPanel();
        simBar = new javax.swing.JProgressBar();
        infosSimLex = new javax.swing.JLabel();
        semSimPanel = new javax.swing.JPanel();
        simBarSem = new javax.swing.JProgressBar();
        infosSemSym = new javax.swing.JLabel();
        totalSimPanel = new javax.swing.JPanel();
        totalSim = new javax.swing.JLabel();
        simBarSem1 = new javax.swing.JProgressBar();
        calculerBtn = new javax.swing.JButton();
        eletSourceCombo = new javax.swing.JComboBox();
        globalCombo = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        schemaSourceCombo = new javax.swing.JComboBox();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        simAll = new javax.swing.JLabel();
        simTotal = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        infosConfig = new javax.swing.JLabel();
        confPoids = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        setConfBtn = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NMMS : A New Mapping For Mediation Systems");
        setBackground(new java.awt.Color(235, 130, 26));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        contentpanel.setBackground(new java.awt.Color(255, 255, 255));

        schemaAdd.setBackground(new java.awt.Color(255, 255, 255));
        schemaAdd.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ADD A NEW SCHEMA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(218, 20, 20))); // NOI18N

        erreurLabel.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        erreurLabel.setForeground(new java.awt.Color(221, 22, 22));

        jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel1.setText("Name :");

        nomSchemaTfd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomSchemaTfdActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel2.setText("Type :");

        fileXSDUp.setBackground(new java.awt.Color(219, 119, 19));
        fileXSDUp.setFont(new java.awt.Font("Ubuntu Light", 3, 14)); // NOI18N
        fileXSDUp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileXSDUp.setIcon(new javax.swing.ImageIcon("/home/dark/NetBeansProjects/PFA2/img/addSchema.png")); // NOI18N
        fileXSDUp.setText("Upload Schema");
        fileXSDUp.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        fileXSDUp.setOpaque(true);
        fileXSDUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileXSDUpMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jLabel4.setText("Load Schema:");

        validerBtn.setIcon(new javax.swing.ImageIcon("/home/dark/NetBeansProjects/PFA2/img/valide.png")); // NOI18N
        validerBtn.setText("Submit");
        validerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validerBtnActionPerformed(evt);
            }
        });

        annulerBtn.setIcon(new javax.swing.ImageIcon("/home/dark/NetBeansProjects/PFA2/img/annuler.png")); // NOI18N
        annulerBtn.setText("Cancel");
        annulerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                annulerBtnActionPerformed(evt);
            }
        });

        clearBtn.setIcon(new javax.swing.ImageIcon("/home/dark/NetBeansProjects/PFA2/img/clear.png")); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        globalSchemaRadio.setText("Globale");
        globalSchemaRadio.setActionCommand("global");
        globalSchemaRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                globalSchemaRadioActionPerformed(evt);
            }
        });

        sourceSchemaRadio.setText("local");

        javax.swing.GroupLayout schemaAddLayout = new javax.swing.GroupLayout(schemaAdd);
        schemaAdd.setLayout(schemaAddLayout);
        schemaAddLayout.setHorizontalGroup(
            schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addGroup(schemaAddLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(schemaAddLayout.createSequentialGroup()
                        .addComponent(validerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(annulerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(schemaAddLayout.createSequentialGroup()
                        .addGroup(schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(44, 44, 44)
                        .addGroup(schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(schemaAddLayout.createSequentialGroup()
                                .addComponent(globalSchemaRadio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sourceSchemaRadio))
                            .addComponent(nomSchemaTfd, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileXSDUp, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(erreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        schemaAddLayout.setVerticalGroup(
            schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schemaAddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(erreurLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(nomSchemaTfd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2)
                    .addComponent(globalSchemaRadio)
                    .addComponent(sourceSchemaRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(fileXSDUp, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(schemaAddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annulerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validerBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        schemaPanel.setBackground(new java.awt.Color(255, 255, 255));
        schemaPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "List Schemas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(204, 34, 34))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(185, 8, 8));
        jLabel5.setText("The Global Schema:");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Schema Source");
        schemaTreeSource.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane3.setViewportView(schemaTreeSource);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(184, 22, 22));
        jLabel6.setText("Local Schemes:");

        jScrollPane9.setWheelScrollingEnabled(false);

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Schema Source");
        schemaTreeGlobal.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane9.setViewportView(schemaTreeGlobal);
        schemaTreeGlobal.expandRow(2);
        DefaultTreeCellRenderer renderer2 = new DefaultTreeCellRenderer();
        renderer2.setOpenIcon(null);
        renderer2.setClosedIcon(null);
        renderer2.setLeafIcon(null);
        schemaTreeGlobal.setCellRenderer(renderer2);

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/dark/NetBeansProjects/PFA2/img/schema.png")); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon("/home/dark/NetBeansProjects/PFA2/img/source.png")); // NOI18N

        javax.swing.GroupLayout schemaPanelLayout = new javax.swing.GroupLayout(schemaPanel);
        schemaPanel.setLayout(schemaPanelLayout);
        schemaPanelLayout.setHorizontalGroup(
            schemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schemaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(schemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, schemaPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(schemaPanelLayout.createSequentialGroup()
                        .addGroup(schemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(schemaPanelLayout.createSequentialGroup()
                                .addGroup(schemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(schemaPanelLayout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel3))
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(schemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        schemaPanelLayout.setVerticalGroup(
            schemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(schemaPanelLayout.createSequentialGroup()
                .addGroup(schemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(schemaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, schemaPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        logPanel.setBackground(new java.awt.Color(64, 54, 45));
        logPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMATION ABOUT SCHEMA LOADED ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(216, 18, 18))); // NOI18N

        infosSchema.setEditable(false);
        infosSchema.setBackground(new java.awt.Color(64, 54, 45));
        infosSchema.setColumns(20);
        infosSchema.setForeground(new java.awt.Color(29, 243, 42));
        infosSchema.setRows(5);
        jScrollPane1.setViewportView(infosSchema);

        javax.swing.GroupLayout logPanelLayout = new javax.swing.GroupLayout(logPanel);
        logPanel.setLayout(logPanelLayout);
        logPanelLayout.setHorizontalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        logPanelLayout.setVerticalGroup(
            logPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        bordPanel.setBackground(new java.awt.Color(255, 255, 255));
        bordPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SIMILARITY", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(205, 13, 13))); // NOI18N
        bordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel9.setText("Select an element of local schema");
        bordPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 17, -1, 23));

        jPanel6.setBackground(new java.awt.Color(245, 234, 224));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "SIMILARITIES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(192, 14, 14))); // NOI18N
        jPanel6.setLayout(new java.awt.GridLayout(1, 3));

        lexSimPanel.setBackground(new java.awt.Color(196, 251, 139));
        lexSimPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Lexical similarity", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        lexSimPanel.setLayout(null);
        lexSimPanel.add(simBar);
        simBar.setBounds(18, 137, 150, 20);

        infosSimLex.setBackground(new java.awt.Color(255, 255, 255));
        lexSimPanel.add(infosSimLex);
        infosSimLex.setBounds(20, 20, 150, 110);

        jPanel6.add(lexSimPanel);

        semSimPanel.setBackground(new java.awt.Color(196, 251, 139));
        semSimPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Semantic similarity", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N
        semSimPanel.setLayout(null);
        semSimPanel.add(simBarSem);
        simBarSem.setBounds(18, 136, 152, 20);

        infosSemSym.setBackground(new java.awt.Color(255, 255, 255));
        semSimPanel.add(infosSemSym);
        infosSemSym.setBounds(20, 20, 150, 110);

        jPanel6.add(semSimPanel);

        totalSimPanel.setBackground(new java.awt.Color(196, 251, 139));
        totalSimPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Total similarity", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        totalSim.setBackground(new java.awt.Color(252, 252, 252));
        totalSim.setFont(new java.awt.Font("Sofachrome", 3, 22)); // NOI18N
        totalSim.setForeground(new java.awt.Color(23, 16, 16));
        totalSim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout totalSimPanelLayout = new javax.swing.GroupLayout(totalSimPanel);
        totalSimPanel.setLayout(totalSimPanelLayout);
        totalSimPanelLayout.setHorizontalGroup(
            totalSimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalSimPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(totalSimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simBarSem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(totalSimPanelLayout.createSequentialGroup()
                        .addComponent(totalSim, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        totalSimPanelLayout.setVerticalGroup(
            totalSimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalSimPanelLayout.createSequentialGroup()
                .addComponent(totalSim, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(simBarSem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jPanel6.add(totalSimPanel);

        bordPanel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 130, 578, -1));

        calculerBtn.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        calculerBtn.setText("Calculate the similarity");
        calculerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculerBtnActionPerformed(evt);
            }
        });
        bordPanel.add(calculerBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        bordPanel.add(eletSourceCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(427, 46, 169, -1));

        bordPanel.add(globalCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 46, 207, -1));

        jLabel10.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        jLabel10.setText("Select an element of Global Schema");
        bordPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 17, -1, 23));

        schemaSourceCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                schemaSourceComboItemStateChanged(evt);
            }
        });
        schemaSourceCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                schemaSourceComboActionPerformed(evt);
            }
        });
        bordPanel.add(schemaSourceCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 46, 160, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        bordPanel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 17, -1, 62));
        bordPanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 590, 10));
        bordPanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 590, 10));

        simAll.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jScrollPane5.setViewportView(simAll);

        bordPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 590, 260));

        simTotal.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        simTotal.setText("View the similarity of all items");
        simTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simTotalActionPerformed(evt);
            }
        });
        bordPanel.add(simTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 260, -1));

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);
        bordPanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 10, 40));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "PARAMETERS: TYPES AND SIMILARITY FACTORS ", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12), new java.awt.Color(168, 17, 17))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        infosConfig.setText("jLabel11");
        jScrollPane4.setViewportView(infosConfig);

        jPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 20, 296, 210));

        confPoids.setText("jLabel11");
        jPanel7.add(confPoids, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 120, 70));

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 10, 80));

        jButton1.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jButton1.setText("Get Informations");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 160, 30));

        setConfBtn.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        setConfBtn.setIcon(new javax.swing.ImageIcon("/home/dark/NetBeansProjects/PFA2/img/conf.png")); // NOI18N
        setConfBtn.setText("Configuration");
        setConfBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setConfBtnActionPerformed(evt);
            }
        });
        jPanel7.add(setConfBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 160, 30));
        jPanel7.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 160, 10));

        jButton2.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon("/home/dark/NetBeansProjects/PFA2/img/showall.png")); // NOI18N
        jButton2.setText("Show All Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contentpanelLayout = new javax.swing.GroupLayout(contentpanel);
        contentpanel.setLayout(contentpanelLayout);
        contentpanelLayout.setHorizontalGroup(
            contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentpanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(schemaAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentpanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentpanelLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(schemaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        contentpanelLayout.setVerticalGroup(
            contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contentpanelLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(contentpanelLayout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(schemaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(contentpanelLayout.createSequentialGroup()
                        .addGroup(contentpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contentpanelLayout.createSequentialGroup()
                                .addComponent(schemaAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(contentpanelLayout.createSequentialGroup()
                                .addComponent(bordPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contentpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomSchemaTfdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomSchemaTfdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomSchemaTfdActionPerformed
    /**
     * lors de clique sur le bouton valider
     *
     * @param evt
     */
    private void validerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validerBtnActionPerformed
        // si le nom de schéma n'est pas indiqué
        if (nomSchemaTfd.getText().equals("")) {
            //chargement images error
            ImageIcon icon = new ImageIcon("img/error.png");
            erreurLabel.setIcon(icon);
            //Message d'erreur 
            erreurLabel.setText("Error: name  of Schema is required ");
        } else {
            //Réqupération nom de schéma 
            String nom = nomSchemaTfd.getText();
            //Type de schéma 
            String type = "";//= typeSchemaCombo.getSelectedItem().toString();
            if (globalSchemaRadio.isSelected()) {
                type = "Globale";
            }
            if (sourceSchemaRadio.isSelected()) {
                type = "Source";
            }
            //Chema Path de fichier chargé
            String nameFileXSD = fileXSDUp.getText();
            // Si le fichier n'est pas un schema xml
            if (!nameFileXSD.endsWith(".xsd")) {
                //Message d'erreur
                ImageIcon icon = new ImageIcon("img/error.png");
                erreurLabel.setIcon(icon);
                erreurLabel.setText("Error: The uploaded file is not an XML schema ");
            } else {
                //Création d'un objet PraserSchema 
                PraserSchema schemaFile = new PraserSchema(nameFileXSD);
                //liste = schema.getAllElement(schema.getElementRacine());
                // Création de schéma 
                Schema schema = new Schema(nom, type, schemaFile.getListElement(), schemaFile.getListAttribut());
                //System.out.println(schemaFile.getListElement().size());
                //Ajouter schema au arbreSchema
                if (type.equals("Globale")) {
                    // verification si il ya déja un schema global 
                    if (schemaGlobal != null) {
                        Object[] options = {"Yes, please",
                            "No way!"};
                        // JDialog pour informer l'utilisateur 
                        int n = JOptionPane.showOptionDialog(this,
                                "You already have a Global schema \n you want to initialize your schema?",
                                "Warning ",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                new ImageIcon("img/attention.png"), //do not use a custom Icon
                                options, //the titles of buttons
                                options[0]); //default button title
                        // si l'utilisateur vaut initialiser le schema  
                        if (n == 0) {
                            schemaGlobal = schema;
                        } // si non on conserve l'ancinne schéma 
                        else {
                            schemaGlobal = schemaGlobal;
                        }
                    } else {
                        schemaGlobal = schema;
                    }
                }
                if (type.equals("Source")) {
                    listeSchemaSource.add(schema);
                }
                // Création d'arbre 
                arbre();
                // modification de variable log qui permet de stocker des infos sur schema 
                logInfosSchema += ">>>" + schema.toString() + "\n";
                logInfosSchema += "----------------------------------------------------\n";
                logInfosSchema += schemaFile.getInfosElementComplexe();
                logInfosSchema += "_____________________________________________________________\n\n";
                infosSchema.setText(logInfosSchema);
                nomSchemaTfd.setText("");
                // rechargement des combobox 
                creatComboBox();
            }

        }
    }//GEN-LAST:event_validerBtnActionPerformed
    /**
     * Pour uploader un schema XML
     *
     * @param evt
     */
    private void fileXSDUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileXSDUpMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        erreurLabel.setIcon(null);
        erreurLabel.setText("");
        JFileChooser ch = new JFileChooser(".");
        // Ajouter un filtre :seulement les schema xsd qui s'affiche
        FileFilter schemaXSD = new FiltreSimple("XSD schema", ".xsd");
        ch.addChoosableFileFilter(schemaXSD);
        //Affichage de Boite de dialogue 
        ch.showDialog(null, "XSD schema");
        //Récupuration Path de fichier 
        fileXSDUp.setText(ch.getSelectedFile().getAbsolutePath());
        //Vérification si le nom de schéma est spécifier
        if (nomSchemaTfd.getText().equals("")) {
            //Initialisation de message d'erreur
            erreurLabel.setIcon(null);
            erreurLabel.setText("");
            String nomSchema = ch.getSelectedFile().getName().replace(".xsd", "");
            nomSchemaTfd.setText(nomSchema);
        }
    }//GEN-LAST:event_fileXSDUpMouseClicked
    /**
     * Pour effectuer les calculs semantique et lexical
     *
     * @param evt
     */
    private void calculerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculerBtnActionPerformed
        // TODO add your handling code here:
        if (schemaGlobal == null || listeSchemaSource.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "You do not have any Source",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String elementSource = eletSourceCombo.getSelectedItem().toString();
            String elementGlobal = globalCombo.getSelectedItem().toString();
            // similarité de type 
            float simType = SimilariteType.getSimilariteType(getTypeOfElementGlobal(elementGlobal), getTypeOfElementSource(schemaSourceCombo.getSelectedItem().toString(), elementSource));
            // similarité lexicale
            float simLex = SimilariteLexecal.similariteLexical(elementSource, elementGlobal);
            // similarité semantique synonymes
            float simSemanSyno = SimilariteSemantique.getSimSymantiqueSyno(elementSource.toLowerCase(), elementGlobal.toLowerCase());
            // similarité semantique hypenames 
            float simSemanHyper = SimilariteSemantique.getSimSymantiqueHyper(elementSource.toLowerCase(), elementGlobal.toLowerCase());
            if (simLex > 0.70) {
                simBar.setBackground(Color.green);
            }
            float simLexical = (poidsName * simLex + poidsType * simType) / (poidsName + poidsType);
            float simSemantique = (poidsName * simSemanHyper + poidsType * simSemanSyno) / (poidsName + poidsType);
            DecimalFormat df = new DecimalFormat("0.0000");
            infosSimLex.setText("<html><table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" style=\"font-size: 10px;\">\n"
                    + "	<tr style=\"background-color: #ADFF2F;text-align: center;green;font-weight: bold;\">\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;\">Property</td>\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;\">Value</td>\n"
                    + "		</tr>\n"
                    + "		<tr>\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;\">Name</td>\n"
                    + "			<td bgcolor=\"#FFFFFF\">" + df.format(simLex) + "</td>\n"
                    + "		</tr>\n"
                    + "		<tr>\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;\">Type</td>\n"
                    + "			<td bgcolor=\"#FFFFFF\">" + df.format(simType) + "</td>\n"
                    + "		</tr>\n"
                    + "		<tr>\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;\">Total</td>\n"
                    + "			<td bgcolor=\"#FFFFFF\">" + df.format(simLexical) + "</td>\n"
                    + "		</tr>\n"
                    + "	</table>");
            infosSemSym.setText("<html><table border=\"1\" cellpadding=\"3\" cellspacing=\"0\" style=\"font-size: 10px;\">\n"
                    + "	<tr style=\"background-color: #ADFF2F;text-align: center;\">\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;\">Property</td>\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;\">Value</td>\n"
                    + "		</tr>\n"
                    + "		<tr>\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;font-size: 8px;\">Synonym</td>\n"
                    + "			<td bgcolor=\"#FFFFFF\">" + df.format(simSemanSyno) + "</td>\n"
                    + "		</tr>\n"
                    + "		<tr>\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;font-size: 8px;\">Hypename</td>\n"
                    + "			<td bgcolor=\"#FFFFFF\">" + df.format(simSemanHyper) + "</td>\n"
                    + "		</tr>\n"
                    + "		<tr>\n"
                    + "			<td style=\"background-color: #ADFF2F;font-weight: bold;\">Total</td>\n"
                    + "			<td  bgcolor=\"#FFFFFF\">" + df.format(simSemantique) + "</td>\n"
                    + "		</tr>\n"
                    + "	</table>");
            simBar.setValue((int) ((simLexical) * 100));
            simBarSem.setValue((int) ((simSemantique) * 100));
            // affichage de résultat final : 
            totalSim.setText(df.format(alpha * simLexical + beta * simSemantique));
        }
    }//GEN-LAST:event_calculerBtnActionPerformed

    private void schemaSourceComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_schemaSourceComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_schemaSourceComboActionPerformed
    /**
     * initialisation de ComboBox lors de choix d'une schéma source
     *
     * @param evt
     */
    private void schemaSourceComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_schemaSourceComboItemStateChanged
        // TODO add your handling code here:
        String nomSchema = (String) evt.getItem();
        for (Schema s : listeSchemaSource) {
            if (s.getNomSchema().equals(nomSchema)) {
                eletSourceCombo.removeAllItems();
                for (Elements e : s.getListElement()) {
                    eletSourceCombo.addItem(e.getNomElement());
                }
                for (Attribut c : s.getListAttribut()) {
                    eletSourceCombo.addItem(c.getNomElement());
                }
            }
        }
    }//GEN-LAST:event_schemaSourceComboItemStateChanged
    /**
     * annulation de chargement de schema
     *
     * @param evt
     */
    private void annulerBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_annulerBtnActionPerformed
        // Initialisation de tout les champs 
        nomSchemaTfd.setText("");
        ImageIcon icon = new ImageIcon("img/addSchema.png");
        fileXSDUp.setIcon(icon);
        fileXSDUp.setText("Upload Schema");
    }//GEN-LAST:event_annulerBtnActionPerformed
    /**
     * Pour netoyer tout les schema
     *
     * @param evt
     */
    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        // TODO add your handling code here:
        //custom title, warning icon
        int rep = JOptionPane.showConfirmDialog(this,
                "Do you really want to remove all schema",
                "Initialization schema",
                JOptionPane.YES_NO_OPTION);
        if (rep == 0) {
            listeSchemaSource.clear();
            schemaGlobal = null;
            infosSchema.setText("");
            infosSemSym.setText("");
            infosSimLex.setText("");
            simAll.setText("");
            totalSim.setText("");
            arbre();
            creatComboBox();
        }
    }//GEN-LAST:event_clearBtnActionPerformed

    private void globalSchemaRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_globalSchemaRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_globalSchemaRadioActionPerformed

    private void simTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simTotalActionPerformed
        // TODO add your handling code here:
        ArrayList<ElementMapCoef> globalMap = new ArrayList();
        ArrayList<ElementMapCoef> sourceMap = new ArrayList();
        if (schemaGlobal == null || listeSchemaSource.isEmpty()) {
            if (schemaGlobal == null && !listeSchemaSource.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "You do not have a global schema",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (listeSchemaSource.isEmpty() && schemaGlobal != null) {
                JOptionPane.showMessageDialog(this,
                        "You do not have any Source schema",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "You do not have any Source",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
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
        }


    }//GEN-LAST:event_simTotalActionPerformed

    private void setConfBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setConfBtnActionPerformed
        // TODO add your handling code here:
        new PropConfig(this,true);
        ConfParamFile conf = new ConfParamFile();
        poidsName = conf.getPoidsName();
        poidsType = conf.getPoidsType();
        alpha = conf.getAlpha();
        beta = conf.getBeta();
        confPoids.setText("<html><table border=\"1\" cellpadding=\"3\" cellspacing=\"0\">\n"
                + "			<tr style=\"font-weight: bold;\" bgcolor=\"#6699\" style=\"font-size: 7px;\">\n"
                + "				<td style=\"font-weight: bold;\">Property</td>\n"
                + "				<td style=\"font-weight: bold;\">Coefficient</td>\n"
                + "				\n"
                + "			</tr>\n"
                + "			<tr>\n"
                + "				<td style=\"font-weight: bold;\" bgcolor=\"#6699\">Name</td>\n"
                + "				<td>" + poidsName + "</td>\n"
                + "			</tr>\n"
                + "			<tr>\n"
                + "				<td style=\"font-weight: bold;\" bgcolor=\"#6699\">Type</td>\n"
                + "				<td>" + poidsType + "</td>\n"
                + "			</tr>\n"
                + "		</table>");
    }//GEN-LAST:event_setConfBtnActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (schemaGlobal == null || listeSchemaSource.isEmpty()) {
            if (schemaGlobal == null && !listeSchemaSource.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "You do not have a global schema",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if (listeSchemaSource.isEmpty() && schemaGlobal != null) {
                JOptionPane.showMessageDialog(this,
                        "You do not have any Source schema",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "You do not have any Source",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            new SimilarityAllDetail(this,true);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ConfDetailInformation(this,true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Poid 
    float poidsName;
    float poidsType ;
    float alpha ;
    float beta;
    private static Schema schemaGlobal = null;
    private static ArrayList<Schema> listeSchemaSource = new ArrayList();
    // permet de faire un log pendant une session 
    private String logInfosSchema = "infos Schema ";
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton annulerBtn;
    private javax.swing.JPanel bordPanel;
    private javax.swing.JButton calculerBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel confPoids;
    private javax.swing.JPanel contentpanel;
    private javax.swing.JComboBox eletSourceCombo;
    private javax.swing.JLabel erreurLabel;
    private javax.swing.JLabel fileXSDUp;
    private javax.swing.JComboBox globalCombo;
    private javax.swing.JRadioButton globalSchemaRadio;
    private javax.swing.JLabel infosConfig;
    private javax.swing.JTextArea infosSchema;
    private javax.swing.JLabel infosSemSym;
    private javax.swing.JLabel infosSimLex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPanel lexSimPanel;
    private javax.swing.JPanel logPanel;
    private javax.swing.JTextField nomSchemaTfd;
    private javax.swing.JPanel schemaAdd;
    private javax.swing.JPanel schemaPanel;
    private javax.swing.JComboBox schemaSourceCombo;
    private javax.swing.JTree schemaTreeGlobal;
    private javax.swing.JTree schemaTreeSource;
    private javax.swing.JPanel semSimPanel;
    private javax.swing.JButton setConfBtn;
    private javax.swing.JLabel simAll;
    private javax.swing.JProgressBar simBar;
    private javax.swing.JProgressBar simBarSem;
    private javax.swing.JProgressBar simBarSem1;
    private javax.swing.JButton simTotal;
    private javax.swing.JRadioButton sourceSchemaRadio;
    private javax.swing.JLabel totalSim;
    private javax.swing.JPanel totalSimPanel;
    private javax.swing.ButtonGroup typeSchemaRadio;
    private javax.swing.JButton validerBtn;
    // End of variables declaration//GEN-END:variables
}
