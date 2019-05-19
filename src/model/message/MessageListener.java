
package model.message;

import java.io.IOException;
import java.net.ServerSocket;
import view.GUI;

public class MessageListener implements Runnable{

	private GUI gui;
	private int puerto;

	public MessageListener(GUI gui, int puerto){
		this.gui = gui;
		this.puerto = puerto;
	}

	@Override
	public void run(){
		try{
			ServerSocket serverSocket = new ServerSocket(puerto);
			while(true){
				new MessageHandler(gui, serverSocket.accept()).start();
			}
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

}
