package ifba.edu.inf015.comunicacao;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

import ifba.edu.inf015.jogo.Game;
import ifba.edu.inf015.jogo.Player;
import ifba.edu.inf015.persistencia.PlayerDAO;


public class Client {

	@SuppressWarnings("unused")
	private static Client cliente;

	private final String host;
	private final int porta;
	public static String nomeCliente;

	public static Player jogador;
	public static PlayerDAO jogadorDAO;

	public Client(String host, int porta, String nomeJogador) {
		this.host = host;
		this.porta = porta;
		cliente = this;
		this.nomeCliente = nomeJogador;
		clienteJogador(nomeJogador);
	}
	
	public void clienteJogador(String nomeJogador) {

		try {
			
			jogadorDAO = new PlayerDAO();
			
			if (!jogadorDAO.procurarJogador(nomeJogador)) {
				
				jogador = new Player(nomeJogador, "0");
				jogadorDAO.inserir(jogador);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void executa() throws UnknownHostException, IOException {

		try {
			Socket cliente = new Socket(host, porta);

			new Thread() {
				@Override
				public void run() {
					Game jogo = new Game(); 

					JOptionPane.showMessageDialog(null, nomeCliente + ", voce esta conectado. Bom Jogo !");
					jogo.setVisible(true); 
				}
			}.start();

		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(null, "Endereco Invalido. Tente novamente !");
			e.printStackTrace();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Servidor esta fora do ar");
			e.printStackTrace();
		}
	}

}