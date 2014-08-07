/*
 * TestProgramView.java
 */

package testprogram;

import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * The application's main frame.
 */
public class TestProgramView extends FrameView {

    public TestProgramView(SingleFrameApplication app) {
        super(app);

        initComponents();

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
       

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                  
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                  
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());                   
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = TestProgramApp.getApplication().getMainFrame();
            aboutBox = new TestProgramAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        TestProgramApp.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanelTestProgram = new javax.swing.JPanel();
        jStartButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaRunInfo = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextStationName = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextProductName = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextTestStatus = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextSFISStatus = new javax.swing.JTextPane();
        jLabelSFISCOM = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jLabelHHSN = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextHHSN = new javax.swing.JTextPane();
        jLabelMAC = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextMAC = new javax.swing.JTextPane();
        jLabelSN = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextSN = new javax.swing.JTextPane();
        jLabelSSID = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextSSID = new javax.swing.JTextPane();
        jLabelPASS = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPASS = new javax.swing.JTextPane();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();

        mainPanelTestProgram.setName("mainPanelTestProgram"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(testprogram.TestProgramApp.class).getContext().getResourceMap(TestProgramView.class);
        jStartButton.setText(resourceMap.getString("jButtonStart.text")); // NOI18N
        jStartButton.setName("jButtonStart"); // NOI18N
        jStartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jStartButtonMousePressed(evt);
            }
        });

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        jTextAreaRunInfo.setColumns(20);
        jTextAreaRunInfo.setRows(5);
        jTextAreaRunInfo.setName("jTextDisplayRunInfo"); // NOI18N
        jScrollPane1.setViewportView(jTextAreaRunInfo);
        jTextAreaRunInfo.getAccessibleContext().setAccessibleName(resourceMap.getString("jTextArea1.AccessibleContext.accessibleName")); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        jTextStationName.setName("jTextStationName"); // NOI18N
        jScrollPane2.setViewportView(jTextStationName);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        jTextProductName.setName("jTextProductName"); // NOI18N
        jScrollPane3.setViewportView(jTextProductName);

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        jTextTestStatus.setName("jTextTestResult"); // NOI18N
        jScrollPane4.setViewportView(jTextTestStatus);

        jScrollPane5.setName("jScrollPane5"); // NOI18N

        jTextSFISStatus.setName("jTextSFISStatus"); // NOI18N
        jScrollPane5.setViewportView(jTextSFISStatus);

        jLabelSFISCOM.setText(resourceMap.getString("jLabelSFISCOM.text")); // NOI18N
        jLabelSFISCOM.setName("jLabelSFISCOM"); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "COM1", "COM2", "COM3", "COM4", "COM5" }));
        jComboBox1.setName("jComboSFISCOM"); // NOI18N

        jLabelHHSN.setText(resourceMap.getString("jLabelHHSN.text")); // NOI18N
        jLabelHHSN.setName("jLabelHHSN"); // NOI18N

        jScrollPane6.setName("jScrollPane6"); // NOI18N

        jTextHHSN.setName("jTextHHSN"); // NOI18N
        jScrollPane6.setViewportView(jTextHHSN);

        jLabelMAC.setText(resourceMap.getString("jLabelMAC.text")); // NOI18N
        jLabelMAC.setName("jLabelMAC"); // NOI18N

        jScrollPane7.setName("jScrollPane7"); // NOI18N

        jTextMAC.setName("jTextMAC"); // NOI18N
        jScrollPane7.setViewportView(jTextMAC);

        jLabelSN.setText(resourceMap.getString("jLabelSN.text")); // NOI18N
        jLabelSN.setName("jLabelSN"); // NOI18N

        jScrollPane8.setName("jScrollPane8"); // NOI18N

        jTextSN.setName("jTextSN"); // NOI18N
        jScrollPane8.setViewportView(jTextSN);

        jLabelSSID.setText(resourceMap.getString("jLabelSSID.text")); // NOI18N
        jLabelSSID.setName("jLabelSSID"); // NOI18N

        jScrollPane9.setName("jScrollPane9"); // NOI18N

        jTextSSID.setName("jTextSSID"); // NOI18N
        jScrollPane9.setViewportView(jTextSSID);

        jLabelPASS.setText(resourceMap.getString("jLabelPASS.text")); // NOI18N
        jLabelPASS.setName("jLabelPASS"); // NOI18N

        jScrollPane10.setName("jScrollPane10"); // NOI18N

        jTextPASS.setName("jTextPASS"); // NOI18N
        jScrollPane10.setViewportView(jTextPASS);

        javax.swing.GroupLayout mainPanelTestProgramLayout = new javax.swing.GroupLayout(mainPanelTestProgram);
        mainPanelTestProgram.setLayout(mainPanelTestProgramLayout);
        mainPanelTestProgramLayout.setHorizontalGroup(
            mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jStartButton)
                                    .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                                        .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                                                .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelHHSN)
                                                    .addComponent(jLabelMAC)
                                                    .addComponent(jLabelSN))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                                                .addComponent(jLabelSSID)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane9))
                                            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                                                .addComponent(jLabelPASS)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane10)))
                                        .addGap(137, 137, 137)))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelTestProgramLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                                .addContainerGap()))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelTestProgramLayout.createSequentialGroup()
                            .addComponent(jLabelSFISCOM)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(14, 14, 14)))
                    .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        mainPanelTestProgramLayout.setVerticalGroup(
            mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                        .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                                .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1)
                                    .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelSFISCOM)
                                        .addComponent(jLabelHHSN)))
                                .addGap(6, 6, 6))
                            .addGroup(mainPanelTestProgramLayout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelMAC)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSN)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelSSID)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainPanelTestProgramLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPASS)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jStartButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabelSFISCOM.getAccessibleContext().setAccessibleName(resourceMap.getString("jLabelSFISCOM.AccessibleContext.accessibleName")); // NOI18N

        mainPanelTestProgram.getAccessibleContext().setAccessibleName(resourceMap.getString("mainPanel.AccessibleContext.accessibleName")); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(testprogram.TestProgramApp.class).getContext().getActionMap(TestProgramView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel))
                .addGap(3, 3, 3))
        );

        setComponent(mainPanelTestProgram);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jStartButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jStartButtonMousePressed
        jTextHHSN.setText("SIG1234");         
        jTextMAC.setText("DC3A5E123456");         
        jTextSN.setText("1234567890ABC");         
        jTextSSID.setText("NETGEAR23");         
        jTextPASS.setText("flowerrain123"); 
    }//GEN-LAST:event_jStartButtonMousePressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabelHHSN;
    private javax.swing.JLabel jLabelMAC;
    private javax.swing.JLabel jLabelPASS;
    private javax.swing.JLabel jLabelSFISCOM;
    private javax.swing.JLabel jLabelSN;
    private javax.swing.JLabel jLabelSSID;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton jStartButton;
    private javax.swing.JTextArea jTextAreaRunInfo;
    private javax.swing.JTextPane jTextHHSN;
    private javax.swing.JTextPane jTextMAC;
    private javax.swing.JTextPane jTextPASS;
    private javax.swing.JTextPane jTextProductName;
    private javax.swing.JTextPane jTextSFISStatus;
    private javax.swing.JTextPane jTextSN;
    private javax.swing.JTextPane jTextSSID;
    private javax.swing.JTextPane jTextStationName;
    private javax.swing.JTextPane jTextTestStatus;
    private javax.swing.JPanel mainPanelTestProgram;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;
}