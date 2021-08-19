import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Server extends javax.swing.JFrame {

    static ServerSocket ssckt;
    static Socket sckt;
    static DataInputStream dtinpt;
    static DataOutputStream dtotpt;


    /** Creates new form Server */
    public Server() {
    	setResizable(false);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtbxarea = new javax.swing.JTextArea();
        txtbxfield = new javax.swing.JTextField();
        btnsend = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtbxarea.setColumns(20);
        txtbxarea.setRows(5);
        jScrollPane1.setViewportView(txtbxarea);

        txtbxfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbxfieldActionPerformed(evt);
            }
        });

        btnsend.setText("Gonder");
        btnsend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendActionPerformed(evt);
            }
        });

        jLabel2.setText("Server");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(txtbxfield, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnsend))))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(151)
        					.addComponent(jLabel2)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(27)
        			.addComponent(jLabel2)
        			.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
        			.addGap(45)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(txtbxfield, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnsend, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addGap(19))
        );
        getContentPane().setLayout(layout);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbxfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbxfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbxfieldActionPerformed

    private void btnsendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendActionPerformed


        try
        {
        String msgout="";
        msgout =txtbxfield.getText().trim();
        dtotpt.writeUTF(msgout);

        }
        catch(Exception e)
        {
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnsendActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });

        String msgin ="";
        try
        {
            ssckt = new ServerSocket(1201);
            sckt = ssckt.accept();
            dtinpt = new DataInputStream(sckt.getInputStream());
            dtotpt = new DataOutputStream(sckt.getOutputStream());
            while(!msgin.equals("exit"))
            {
                msgin =dtinpt.readUTF();
                txtbxarea.setText(txtbxarea.getText().trim()+"\n Client:"+msgin);
            }
        }
        catch(Exception e)
        {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsend;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea txtbxarea;
    private javax.swing.JTextField txtbxfield;
    // End of variables declaration//GEN-END:variables

}
