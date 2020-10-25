package ifba.edu.inf015.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.MenuBar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ifba.edu.inf015.jogo.Game;
import ifba.edu.inf015.lib.FileConvert;

import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Score extends JFrame {

	private JPanel scoreWindow;
	private JLayeredPane scorePane;
	private MenuBar menu;
	private Logo scoreLogo;
	private Game newGame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Score frame = new Score();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Score() {
		menu = new MenuBar();
	}

	public void initComponents(Map<String, String> map) {
		setTitle("Welcome");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 418);

		scoreWindow = new JPanel();
		scoreWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		scoreWindow.setLayout(new BorderLayout(0, 0));
		setContentPane(scoreWindow);

		scorePane= new JLayeredPane();
		scorePane.setForeground(Color.DARK_GRAY);
		scorePane.setBackground(new Color(0, 0, 0));
		scoreWindow.add(scorePane, BorderLayout.CENTER);

		JTextArea caixaDeTexto = new JTextArea(mostrarTexto(map));
		caixaDeTexto.setForeground(Color.WHITE);
		caixaDeTexto.setBackground(Color.BLACK);
		
		JScrollPane scrollPane = new JScrollPane(caixaDeTexto);
		scrollPane.setBounds(70, 150,300, 150);
		scrollPane.setBorder(new LineBorder(Color.blue));
		scorePane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(37, 48, 46, 14);
		scorePane.add(lblNewLabel);

		scorePane.add(scoreLogo = new Logo(23, 20, 364, 71, "images/pontos.png"));

		JButton newGameButton = new JButton("Clique no menu para jogar novamente");
		newGameButton.setBounds(50, 324, 300, 23);
		scorePane.add(newGameButton);

		try {
			setIconImage(new FileConvert().convertImage("images/JogoMemoria.png"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		this.getContentPane().setBackground(Color.BLACK);

		newGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

	}
	
	public String mostrarTexto(Map<String, String> map) {
		String str = "Jogador" + "\t\t" + "Pontuacao" + "\n";

		for (String key : map.keySet()) { 
			str += ("  " + key + "\t\t" + map.get(key) + "\n");
		}

		return str;
	}
	
}