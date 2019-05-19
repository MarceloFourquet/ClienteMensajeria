
package model;

import java.net.InetAddress;
import java.util.Objects;

public class Contacto{

	private InetAddress inetAddres;
	private int port;

	public Contacto(){
	}

	public Contacto(InetAddress inetAddres, int port){
		this.inetAddres = inetAddres;
		this.port = port;
	}

	public InetAddress getInetAddres(){
		return inetAddres;
	}

	public void setInetAddres(InetAddress inetAddres){
		this.inetAddres = inetAddres;
	}

	public int getPort(){
		return port;
	}

	public void setPort(int port){
		this.port = port;
	}

	@Override
	public int hashCode(){
		return Objects.hash(inetAddres, port);
	}

	@Override
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(this.getClass() != obj.getClass()){
			return false;
		}
		Contacto other = (Contacto) obj;
		return (this.port == other.port) && Objects.equals(this.inetAddres, other.inetAddres);
	}
	
	@Override
	public String toString(){
		return String.format("%s:%s", inetAddres.getHostAddress(), port);
	}

}
