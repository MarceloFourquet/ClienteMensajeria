
package domain;

import view.GUI;
import model.file.FileListener;
import model.message.MessageListener;
import model.contacts.ContactsBroadcast;
import model.contacts.ContactsListeners;

public class Runner{

	public static void main(String[] args){
		GUI gui = new GUI();
		gui.setVisible(true);
		new Thread(new MessageListener(gui, 5000)).start();
		new Thread(new FileListener(gui, 5001)).start();
		new Thread(new ContactsBroadcast(gui, 4000)).start();
		new Thread(new ContactsListeners(gui, 4000)).start();
	}

}
