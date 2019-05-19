
package model.file;

import view.GUI;
import java.io.*;
import java.net.Socket;
import javax.swing.JFileChooser;

public class FileHandler extends Thread{

	private Socket cliente;
	private GUI gui;

	public FileHandler(Socket cliente, GUI vc){
		this.cliente = cliente;
		this.gui = vc;
	}

	@Override
	public void run(){
		String hostName = cliente.getInetAddress().getHostAddress();
		int port = cliente.getPort();
		gui.setValueLabelStatus("Atendiendo conexión desde: " + hostName + ":" + port);
		final JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(gui);
		if(returnValue == JFileChooser.APPROVE_OPTION){
			File file = fileChooser.getSelectedFile();
			try(InputStream inputStream = cliente.getInputStream()){
				try(FileOutputStream fileOutputStream = new FileOutputStream(file, true)){
					int oneByte;
					while((oneByte = inputStream.read()) != -1){
						fileOutputStream.write(oneByte);
					}
					fileOutputStream.flush();
				}
				gui.setValueLabelStatus("Archivo " + file.getName() + " recibido");
			}catch(IOException ex){
				System.out.println(ex.getMessage());
			}finally{
				try{
					cliente.close();
				}catch(IOException ex){
					System.out.println(ex.getMessage());
				}
			}
		}
	}
	
}