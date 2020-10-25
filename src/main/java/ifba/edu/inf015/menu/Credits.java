package ifba.edu.inf015.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Credits extends JFrame {

	private JPanel contentPane;
	private JButton selectButton;
	private JLayeredPane creditsPanel;
	private JTextPane creditsText;
	private Logo ifbaLogo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credits frame = new Credits();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponentes() {
		setTitle("Cr�ditos");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 392, 412);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		creditsPanel = new JLayeredPane();
		creditsPanel.setForeground(Color.DARK_GRAY);
		creditsPanel.setBackground(new Color(0, 0, 0));
		contentPane.add(creditsPanel, BorderLayout.CENTER);

		selectButton = new JButton("Ok");
		selectButton.setBounds(120, 323, 89, 23);
		creditsPanel.add(selectButton);

		creditsText = new JTextPane();
		creditsText.setBackground(Color.BLACK); 
		creditsText.setFont(new Font("Verdana", Font.PLAIN, 11)); 
		creditsText.setForeground(Color.WHITE); 
		creditsText.setText(
				"Orientador :\r\n   > Grinaldo Lopes de Oliveira\r\n\t\t\t\r\nColaboradores :\r\n  > Elayne Natalia de O. Argollo\r\n  > Edilton Silva Junior\r\n  > Gabriel dos Reis Morais\r\n");
		creditsText.setBounds(76, 169, 254, 132);
		creditsText.setEditable(false);
		creditsPanel.add(creditsText);
		
		creditsPanel.add(ifbaLogo = new Logo(10, 11, 356, 117));

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/JogoMemoria.png")));
		this.getContentPane().setBackground(Color.BLACK); 

		selectButton.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}

	public Credits() {
		initComponentes();
	}
}