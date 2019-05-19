
package model.contacts;

import java.io.IOException;
import java.net.*;
import view.GUI;

public class ContactsBroadcast implements Runnable{
	
	private GUI gui;
	private int puerto;

	public ContactsBroadcast(GUI gui, int puerto){
		this.gui = gui;
		this.puerto = puerto;
	}
	
	@Override
	@SuppressWarnings("SleepWhileInLoop")
	public void run(){
		try(DatagramSocket socket = new DatagramSocket()){
			byte[] byteArray = new byte[100];
			DatagramPacket datagramPacket = new DatagramPacket(
				byteArray,
				byteArray.length,
				InetAddress.getByName("235.1.1.1"),
				puerto);
			gui.setValueLabelStatus(String.format("Enviando %s bytes a %s:%s",
				byteArray.length,
				datagramPacket.getAddress().getHostAddress(),
				datagramPacket.getPort()));
			while(true){
				System.out.print(".");
				socket.send(datagramPacket);
				Thread.sleep(2000);
			}
		}catch(IOException | InterruptedException ex){
			System.out.println(ex.getMessage());
		}
	}
	
}
