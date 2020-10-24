package ifba.edu.inf015.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ifba.edu.inf015.comunicacao.Client;
import ifba.edu.inf015.jogo.Sound;
import ifba.edu.inf015.lib.FileConvert;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JLabel lblCarregando;
	private JPanel loginWindow;
	private JButton playButton;
	private JLayeredPane loginPane;
	private Client cliente;
	private JTextField ipServidor;
	private JTextField portaServidor;
	private JTextField nomeJogador;
	@SuppressWarnings("unused")
	private MenuBar menu;
	@SuppressWarnings("unused")
	private Logo loginLogo;
	private Sound loginMusic;

	public Login() {
		initComponente();
		menu = new MenuBar();
		loginMusic = new Sound();
		loginMusic.mainMusic();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponente() {

		this.lblCarregando = new JLabel();
		setTitle("Jogo da Memoria - Redes");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 565);

		loginWindow = new JPanel();
		loginWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		loginWindow.setLayout(new BorderLayout(0, 0));
		setContentPane(loginWindow);

		loginPane = new JLayeredPane();
		loginWindow.add(loginPane, BorderLayout.CENTER);

		playButton = new JButton("Jogar");
		playButton.setBounds(233, 450, 90, 30);
		loginPane.add(playButton);

		ipServidor = new JTextField();
		ipServidor.setColumns(10);
		ipServidor.setBounds(204, 299, 150, 20);
		loginPane.add(ipServidor);

		JLabel ipLabel = new JLabel("Entre com IP do servidor:");
		ipLabel.setBounds(204, 274, 154, 14);
		loginPane.add(ipLabel);
		ipLabel.setForeground(Color.white);

		portaServidor = new JTextField();
		portaServidor.setColumns(10);
		portaServidor.setBounds(204, 355, 150, 20);
		loginPane.add(portaServidor);

		JLabel doorLabel = new JLabel("Entre com a porta:");
		doorLabel.setBounds(204, 330, 167, 14);
		loginPane.add(doorLabel);
		doorLabel.setForeground(Color.white);

		
		loginPane.add(loginLogo = new Logo(25, 43, 534, 190, "images/testepng.png"));
		
		nomeJogador = new JTextField();
		nomeJogador.setColumns(10);
		nomeJogador.setBounds(204, 411, 150, 20);
		loginPane.add(nomeJogador);

		JLabel nameLabel = new JLabel("Informe seu nome:");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(204, 386, 167, 14);
		loginPane.add(nameLabel);
		
		try {
			setIconImage(new FileConvert().convertImage("images/JogoMemoria.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		this.getContentPane().setBackground(Color.BLACK);

		playButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					new Sound().buttonSound();
					cliente = new Client(ipServidor.getText(), Integer.parseInt(portaServidor.getText()),
							nomeJogador.getText());
					cliente.executa();
					setVisible(false);
					loginMusic.stop();
				} catch (IOException e) {
					lblCarregando.setVisible(false);
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public String getIp() {
		return this.ipServidor.getText();
	}
	
	public String getPlayer() {
		return this.nomeJogador.getText();
	}
	
	public String getPort() {
		return this.ipServidor.getText();
	}
}