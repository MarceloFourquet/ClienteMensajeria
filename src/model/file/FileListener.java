
package model.file;

import java.io.IOException;
import java.net.ServerSocket;
import view.GUI;

public class FileListener implements Runnable{

	private GUI gui;
	private int puerto;

	public FileListener(GUI gui, int puerto){
		this.gui = gui;
		this.puerto = puerto;
	}

	@Override
	public void run(){
		try{
			ServerSocket serverSocket = new ServerSocket(puerto);
			while(true){
				new FileHandler(serverSocket.accept(), gui).start();
			}
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

}
