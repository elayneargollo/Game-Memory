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
public class Version extends JFrame {

	private JPanel versionWindow;
	private JButton selectButton;
	private JLayeredPane versionPane;
	private JTextPane versionText;
	private Logo ifbaLogo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Version frame = new Version();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void initComponente() {
		setTitle("Version"); 
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 279);

		versionWindow = new JPanel();
		versionWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		versionWindow.setLayout(new BorderLayout(0, 0));
		setContentPane(versionWindow);

		versionPane = new JLayeredPane();
		versionPane.setForeground(Color.DARK_GRAY);
		versionPane.setBackground(new Color(0, 0, 0));
		versionWindow.add(versionPane, BorderLayout.CENTER);

		selectButton = new JButton("Ok");
		selectButton.setBounds(152, 193, 89, 23);
		versionPane.add(selectButton);

		versionText = new JTextPane();
		versionText.setBackground(Color.BLACK);
		versionText.setFont(new Font("Verdana", Font.PLAIN, 11));
		versionText.setForeground(Color.WHITE);
		versionText.setText("Versao 3.0.5 (21086)");
		versionText.setBounds(114, 143, 179, 39);
		versionText.setEditable(false);
		versionPane.add(versionText);
		
		versionPane.add(ifbaLogo = new Logo(74, 11, 219, 100));

		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/JogoMemoria.png")));
		this.getContentPane().setBackground(Color.BLACK);

		selectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
	}

	public Version() {
		initComponente();	
	}
}