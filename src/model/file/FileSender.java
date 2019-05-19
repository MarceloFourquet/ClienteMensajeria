
package model.file;

import java.io.*;
import java.net.Socket;
import model.Contacto;
import view.GUI;

public class FileSender implements Runnable{

	private Contacto contacto;
	private GUI gui;
	private File file;

	public FileSender(Contacto contacto, GUI gui, File file){
		this.contacto = contacto;
		this.gui = gui;
		this.file = file;
	}

	@Override
	public void run(){
		String hostName = contacto.getInetAddres().getHostName();
		int port = contacto.getPort();
		try(Socket socket = new Socket(hostName, port)){
			try(OutputStream outputStream = socket.getOutputStream()){
				try(FileInputStream inputStream = new FileInputStream(file)){
					int oneByte;
					while((oneByte = inputStream.read()) != -1){
						outputStream.write(oneByte);
					}
					outputStream.flush();
				}
			}
		}catch(IOException ex){
			gui.setValueLabelStatus("Archivo " + file.getName() + " NO enviado -> " + ex.getMessage());
		}
		gui.setValueLabelStatus("Archivo " + file.getName() + " enviado");
	}

}
