package ifba.edu.inf015.comunicacao;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;


public class SocketServidor {

	private ServerSocket server = null;
	private static final int port = 11111;

	public void criarServerSocket(int porta) throws IOException {
		server = new ServerSocket(porta);
	}

	public Socket esperarConexao() throws IOException {
		Socket client = server.accept();
		return client;
	}

	public static void main(String[] args) throws IOException {

		try {

			SocketServidor servidor = new SocketServidor();
			servidor.criarServerSocket(port);
			
			JOptionPane.showMessageDialog(null, "Conectado com sucesso.");

			while (true) {
				Socket cliente = servidor.esperarConexao();
				new ClientManager(cliente);
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "A porta esta ocupada ou o servidor esta ocupado.");
		}

	}
}
