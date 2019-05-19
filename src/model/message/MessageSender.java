
package model.message;

import java.io.*;
import java.net.Socket;
import model.Contacto;
import view.GUI;

public class MessageSender implements Runnable{

	private GUI gui;
	private Contacto contacto;

	public MessageSender(GUI gui, Contacto contacto){
		this.gui = gui;
		this.contacto = contacto;
	}

	@Override
	public void run(){
		try(Socket socket = new Socket(contacto.getInetAddres().getHostName(), contacto.getPort())){
			try (PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true)) {
				outputStream.println(gui.getValueAreaTexto());
			}
		}catch(IOException ex){
			gui.setValueLabelStatus("Mensaje NO enviado -> " + ex.getMessage());
		}
		gui.setValueLabelStatus("Mensaje enviado");
	}

}
