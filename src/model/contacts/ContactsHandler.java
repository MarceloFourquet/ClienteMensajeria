
package model.contacts;

import java.net.InetAddress;
import model.Contacto;
import view.GUI;

public class ContactsHandler implements Runnable{
	
	private GUI gui;
	private InetAddress contactAddress;

	public ContactsHandler(GUI gui, InetAddress contactAddress){
		this.gui = gui;
		this.contactAddress = contactAddress;
	}

	@Override
	public void run(){
		gui.addContacto(new Contacto(contactAddress, 5000));
	}
	
}
