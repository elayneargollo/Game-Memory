package ifba.edu.inf015.comunicacao;

import java.net.Socket;

public class ClientManager extends Thread {

	@SuppressWarnings("unused")
	private Socket cliente;

	public ClientManager(Socket cliente) {
		this.cliente = cliente;
		start();
	}

}
