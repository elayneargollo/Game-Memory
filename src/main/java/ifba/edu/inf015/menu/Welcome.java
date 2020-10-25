package ifba.edu.inf015.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Welcome extends JFrame {

	private JPanel contentPane;
	private JButton selecionar;
	private JLayeredPane layeredPane;
	private JTextPane txtpnTeste;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Welcome() {
		initComponente();
	}

	public void initComponente() {
		setTitle("Welcome"); 
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 412);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		layeredPane = new JLayeredPane();
		layeredPane.setForeground(Color.DARK_GRAY);
		layeredPane.setBackground(new Color(0, 0, 0));
		contentPane.add(layeredPane, BorderLayout.CENTER);

		selecionar = new JButton("Ok");
		selecionar.setBounds(136, 339, 89, 23);
		layeredPane.add(selecionar);

		txtpnTeste = new JTextPane();
		txtpnTeste.setText(
				"Jogo multiusuario programado em Java e utilizando Sockets. \r\n\r\nDesenvolvido pelos alunos de ADS do Instituto Federal de Educa\u00E7ao, Ciencia e Tecnologia da Bahia (IFBA)\r\n\r\nTeste seus conhecimentos em Redes de Computadores de uma maneira divertida e elegante. \r\n\t\t\t\t\tBoa Sorte ! ");
		txtpnTeste.setBackground(Color.BLACK);
		txtpnTeste.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtpnTeste.setForeground(Color.WHITE);
		txtpnTeste.setBounds(60, 139, 254, 189);
		layeredPane.add(txtpnTeste);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/imagens/IFBALogo.png")));
		lblNewLabel.setBounds(10, 11, 356, 100);
		layeredPane.add(lblNewLabel);

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/JogoMemoria.png")));
		this.getContentPane().setBackground(Color.BLACK);

		selecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}

}