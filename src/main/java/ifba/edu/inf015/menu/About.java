package ifba.edu.inf015.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class About extends JFrame {

	private JPanel aboutWindow;
	private JButton selectButton;
	private JLayeredPane aboutPane;
	private JTextPane aboutText;
	private Logo ifbaLogo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public About() {
		initComponente();
	}

	public void initComponente() {
		setTitle("Sobre"); 
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 412);

		aboutWindow = new JPanel();
		aboutWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		aboutWindow.setLayout(new BorderLayout(0, 0));
		setContentPane(aboutWindow);

		aboutPane = new JLayeredPane();
		aboutPane.setForeground(Color.DARK_GRAY);
		aboutPane.setBackground(new Color(0, 0, 0));
		aboutWindow.add(aboutPane, BorderLayout.CENTER);

		selectButton = new JButton("Ok");
		selectButton.setBounds(136, 339, 89, 23);
		aboutPane.add(selectButton);

		aboutText = new JTextPane();
		aboutText.setText(
				"Jogo multiusuario programado em Java e utilizando Sockets. \r\n\r\nDesenvolvido pelos alunos de ADS do Instituto Federal de Educa\u00E7ao, Ciencia e Tecnologia da Bahia (IFBA)\r\n\r\nTeste seus conhecimentos em Redes de Computadores de uma maneira divertida e elegante. \r\n\t\t\t\t\tBoa Sorte ! ");
		aboutText.setBackground(Color.BLACK);
		aboutText.setFont(new Font("Verdana", Font.PLAIN, 11));
		aboutText.setForeground(Color.WHITE);
		aboutText.setBounds(60, 139, 254, 189);
		aboutText.setEditable(false);
		aboutPane.add(aboutText);
		
		aboutPane.add(ifbaLogo = new Logo(10, 11, 356, 100));

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/JogoMemoria.png")));
		this.getContentPane().setBackground(Color.BLACK);

		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}

}