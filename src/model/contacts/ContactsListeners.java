
package model.contacts;

import java.io.IOException;
import java.net.*;
import view.GUI;

public class ContactsListeners implements Runnable{

	private GUI gui;
	private int puerto;

	public ContactsListeners(GUI gui, int puerto){
		this.gui = gui;
		this.puerto = puerto;
	}

	@Override
	public void run(){
		byte[] byteArray = new byte[100];
		DatagramPacket datagramPacket = new DatagramPacket(byteArray, byteArray.length);
		try(MulticastSocket socket = new MulticastSocket(puerto)){
			socket.joinGroup(InetAddress.getByName("235.1.1.1"));
			while(true){
				socket.receive(datagramPacket);
				System.out.printf("Recibido %s bytes desde %s:%s%n",
					datagramPacket.getLength(),
					datagramPacket.getAddress().getHostAddress(),
					"[" + new String(datagramPacket.getData()) + "]");
				datagramPacket.setLength(byteArray.length);
				new Thread(new ContactsHandler(gui, datagramPacket.getAddress())).start();
			}
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

}
