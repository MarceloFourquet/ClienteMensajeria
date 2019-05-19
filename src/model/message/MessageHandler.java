
package model.message;

import java.io.*;
import java.net.Socket;
import view.GUI;

public class MessageHandler extends Thread{

	private Socket cliente;
	private GUI gui;

	public MessageHandler(GUI gui, Socket cliente){
		this.cliente = cliente;
		this.gui = gui;
	}

	@Override
	public void run(){
		String hostName = cliente.getInetAddress().getHostAddress();
		int port = cliente.getPort();
		gui.setValueLabelStatus("Atendiendo conexión desde: " + hostName + ":" + port);
		try(InputStreamReader inputStream = new InputStreamReader(cliente.getInputStream())){
			try(BufferedReader bufferedReader = new BufferedReader(inputStream)){
				StringBuilder mensaje = new StringBuilder()
					.append(hostName)
					.append(":")
					.append(port)
					.append(" ->\n");
				String linea;
				while((linea = bufferedReader.readLine()) != null){
					mensaje
					.append(linea)
					.append("\n");
				}
				gui.setValueAreaMensajes(mensaje.toString());
			}
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
