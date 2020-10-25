package ifba.edu.inf015.jogo;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;

import ifba.edu.inf015.lib.FileConvert;

@SuppressWarnings("serial")
public class Game extends JFrame {

	ArrayList<GameFacil> cardArray = new ArrayList<GameFacil>();

	private javax.swing.JMenuBar barraDeMenu;
	private javax.swing.JLabel labelCartasViradas;
	private javax.swing.JLabel labelPontos;
	private javax.swing.JLabel labelPontuacao;
	private javax.swing.JLabel labelQuantDeCartasViradas2;
	private javax.swing.JMenu menuJogo;
	private javax.swing.JPanel painelPrincipal;
	private javax.swing.JMenuItem subMenuDeJogo_NovoJogo;
	private javax.swing.JMenuItem subMenuDeJogo_Opcoes;
	private javax.swing.JMenuItem subMenuDeJogo_Sair;
	private javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	private Sound gameMusic;

	public Game() {

		
		dispose();
		initComponents();
		
		gameMusic = new Sound();
		gameMusic.mainMusic();
		
		GameFacil cards[] = new GameFacil[16];
		
		this.loadImages(cards); 
		this.addCardsToArray(cards); 
		this.setPairs(); 

		Collections.shuffle(cardArray);

		for (GameFacil c : cardArray) {
			c.esconderCarta(); 
			painelPrincipal.add(c);
		}
	}
	
	public void muteSound() {
		this.gameMusic.stop();
	}

	private void initComponents() {
		
		labelPontos = new javax.swing.JLabel();
		labelPontuacao = new javax.swing.JLabel();
		labelCartasViradas = new javax.swing.JLabel();
		labelQuantDeCartasViradas2 = new javax.swing.JLabel();
		painelPrincipal = new javax.swing.JPanel();
		barraDeMenu = new javax.swing.JMenuBar();
		menuJogo = new javax.swing.JMenu();
		subMenuDeJogo_NovoJogo = new javax.swing.JMenuItem();
		subMenuDeJogo_Opcoes = new javax.swing.JMenuItem();
		subMenuDeJogo_Sair = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Jogo da Memoria Redes");
		setResizable(false);

		this.getContentPane().setBackground(Color.gray);
		
		try {
			setIconImage(new FileConvert().convertImage("images/JogoMemoria.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		labelPontos.setText("Pontos:");
		labelPontuacao.setText("0");
		labelCartasViradas.setText("Cartas Viradas:");
		labelQuantDeCartasViradas2.setText("0");

		painelPrincipal.setLayout(new java.awt.GridLayout(4, 4));
		this.painelPrincipal.setBackground(Color.gray);

		menuJogo.setText("Jogo");
		
		subMenuDeJogo_NovoJogo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
		subMenuDeJogo_NovoJogo.setText("Novo Jogo");

		subMenuDeJogo_NovoJogo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				SubMenuDeJogo_NovoJogoActionPerformed(evt);
			}
		});

		menuJogo.add(subMenuDeJogo_NovoJogo);
		subMenuDeJogo_Sair.setText("Sair");

		subMenuDeJogo_Sair.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				System.exit(0);
			}
		});

		menuJogo.add(subMenuDeJogo_Sair);
		barraDeMenu.add(menuJogo);
		setJMenuBar(barraDeMenu);

		getContentPane().setLayout(layout);
		this.alignedGroup();
		pack();
	}

	private void SubMenuDeJogo_NovoJogoActionPerformed(java.awt.event.ActionEvent evt) {
		this.gameMusic.stop();
		Game newJogo = new Game();
		newJogo.setVisible(true);
		Game.super.dispose();
	}

	private void SubMenuDeJogo_SairActionPerformed(java.awt.event.ActionEvent evt) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void alignedGroup() {
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
				.addComponent(painelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
				.addContainerGap())
				.addGroup(layout.createSequentialGroup()
				.addComponent(labelPontos)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(labelPontuacao)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 438, Short.MAX_VALUE)
				.addComponent(labelCartasViradas).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addComponent(labelQuantDeCartasViradas2).addGap(64, 64, 64)))));
	
	layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
			.addContainerGap()
			.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
			.addComponent(labelPontos)
			.addComponent(labelPontuacao)
			.addComponent(labelCartasViradas)
			.addComponent(labelQuantDeCartasViradas2))
			.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34,Short.MAX_VALUE)
			.addComponent(painelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 559,javax.swing.GroupLayout.PREFERRED_SIZE)
			.addContainerGap()));
	}
	
	private void loadImages(GameFacil cards[]) {
		
		for(int count = 0; count < 16; count++) {
			
			try {
				Image image = new FileConvert().convertImage("images/" + (count+1) + ".png");
				cards[count] = new GameFacil(image, labelPontuacao, labelQuantDeCartasViradas2, subMenuDeJogo_NovoJogo);
			} catch (IOException e) {

				e.printStackTrace();
			}
			
		}
	}
	
	private void addCardsToArray(GameFacil cards[]) {
		for(int count = 0; count < 16; count++) {
			this.cardArray.add(cards[count]);
		}
	}
	
	private void setPairs() {
		for(int count = 0; count < 15; count += 2) {
			this.cardArray.get(count).setPar(this.cardArray.get(count+1));
			this.cardArray.get(count+1).setPar(this.cardArray.get(count));			
		}
	}
}
