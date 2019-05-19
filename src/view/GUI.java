
package view;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.*;
import model.Contacto;
import model.message.MessageSender;
import model.file.FileSender;

public class GUI extends javax.swing.JFrame{

	private DefaultListModel modeloContactos = new DefaultListModel();

	public GUI(){
		initComponents();
		buttonClearActionPerformed(null);
		listaContactos.setModel(modeloContactos);
	}

	public void setValueLabelStatus(String texto){
		labelStatus.setText(texto);
	}

	public void setValueAreaMensajes(String texto){
		areaMensaje.append(texto);
	}
	
	public String getValueAreaTexto(){
		return areaTexto.getText();
	}

	public void addContacto(Contacto contacto){
		if(!modeloContactos.contains(contacto)){
			modeloContactos.addElement(contacto);
		}
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelHost = new javax.swing.JLabel();
        labePort = new javax.swing.JLabel();
        textFieldHost = new javax.swing.JTextField();
        textFieldPort = new javax.swing.JTextField();
        buttonAddContact = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaContactos = new javax.swing.JList();
        labelTexto = new javax.swing.JLabel();
        textAreaTexto = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextArea();
        labelStatus = new javax.swing.JLabel();
        buttonSend = new javax.swing.JButton();
        buttonSendFile = new javax.swing.JButton();
        buttonClear = new javax.swing.JButton();
        labelIncommingMessages = new javax.swing.JLabel();
        textAreaIncommingMessage = new javax.swing.JScrollPane();
        areaMensaje = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cliente de Mensajería");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelHost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelHost.setText("Host");
        getContentPane().add(labelHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 27, -1, -1));

        labePort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labePort.setText("Port");
        getContentPane().add(labePort, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 70, 28, -1));

        textFieldHost.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(textFieldHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 23, 231, 25));

        textFieldPort.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(textFieldPort, new org.netbeans.lib.awtextra.AbsoluteConstraints(67, 66, 231, 25));

        buttonAddContact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonAddContact.setLabel("Add Contact");
        buttonAddContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddContactActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAddContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 109, 277, -1));

        listaContactos.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Contactos"));
        listaContactos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(listaContactos);
        listaContactos.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 152, 277, 150));

        labelTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelTexto.setText("Texto a Enviar");
        getContentPane().add(labelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 27, -1, -1));

        textAreaTexto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        areaTexto.setColumns(20);
        areaTexto.setRows(5);
        textAreaTexto.setViewportView(areaTexto);

        getContentPane().add(textAreaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 66, 383, 236));

        labelStatus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelStatus.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 320, 693, 20));

        buttonSend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonSend.setText("Send");
        buttonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 355, 85, -1));

        buttonSendFile.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonSendFile.setText("Send File");
        buttonSendFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSendFileActionPerformed(evt);
            }
        });
        getContentPane().add(buttonSendFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 355, -1, -1));

        buttonClear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        buttonClear.setText("Clear");
        buttonClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });
        getContentPane().add(buttonClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 355, 85, -1));

        labelIncommingMessages.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelIncommingMessages.setText("Mensajes Entrantes");
        getContentPane().add(labelIncommingMessages, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 398, -1, -1));

        textAreaIncommingMessage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        areaMensaje.setColumns(20);
        areaMensaje.setRows(5);
        textAreaIncommingMessage.setViewportView(areaMensaje);

        getContentPane().add(textAreaIncommingMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 433, 693, 140));

        setSize(new java.awt.Dimension(760, 638));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
		areaMensaje.setText("");
		areaTexto.setText("");
		labelStatus.setText("Envie un mensaje");
    }//GEN-LAST:event_buttonClearActionPerformed

    private void buttonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendActionPerformed
		Contacto contacto = (Contacto) listaContactos.getSelectedValue();
		if(contacto != null){
			new Thread(new MessageSender(this, contacto)).start();
		}
    }//GEN-LAST:event_buttonSendActionPerformed

    private void buttonAddContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddContactActionPerformed
		try{
			addContacto(new Contacto(InetAddress.getByName(textFieldHost.getText()), Integer.parseInt(textFieldPort.getText())));
		}catch(UnknownHostException ex){
			System.out.println(ex.getMessage());
		}
    }//GEN-LAST:event_buttonAddContactActionPerformed

    private void buttonSendFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSendFileActionPerformed
		final JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(this);
		if(returnValue == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			Contacto contacto = (Contacto) listaContactos.getSelectedValue();
			if(contacto != null){
				new Thread(new FileSender(contacto, this, file)).start();
			}
		}
    }//GEN-LAST:event_buttonSendFileActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMensaje;
    private javax.swing.JTextArea areaTexto;
    private javax.swing.JButton buttonAddContact;
    private javax.swing.JButton buttonClear;
    private javax.swing.JButton buttonSend;
    private javax.swing.JButton buttonSendFile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labePort;
    private javax.swing.JLabel labelHost;
    private javax.swing.JLabel labelIncommingMessages;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JLabel labelTexto;
    private javax.swing.JList listaContactos;
    private javax.swing.JScrollPane textAreaIncommingMessage;
    private javax.swing.JScrollPane textAreaTexto;
    private javax.swing.JTextField textFieldHost;
    private javax.swing.JTextField textFieldPort;
    // End of variables declaration//GEN-END:variables
}
