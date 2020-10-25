package ifba.edu.inf015.jogo;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.imageio.stream.ImageInputStream;

import ifba.edu.inf015.comunicacao.Client;
import ifba.edu.inf015.lib.FileConvert;

@SuppressWarnings("serial")
public class GameFacil extends Letter {

	private Image imgFundo = getImgFundo("images/flipper.png");

	public GameFacil(Image imgF, JLabel Label_pont, JLabel cartasViradas, JMenuItem novojogo) {

		super(imgF, Label_pont, cartasViradas, novojogo);
		setImgFrente(imgF);
		var_Label_Pontos = Label_pont;
		var_Label_Cartas_Viradas = cartasViradas;
		novoJogo = novojogo;

		this.addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				capturarCliqueDoMouse();
			}
		});

		novoJogo.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				subMenuDeJogoNovoJogoActionPerformed();
			}
		});

	}

	@Override
	public void subMenuDeJogoNovoJogoActionPerformed() {
		contCartasViradasUma = 0;
		pontos = 0;
		contCardViradaPar = 0;
		cont = 0;
	}

	@Override
	public void capturarCliqueDoMouse() {

		if (!this.isViradaPraFrente()) {

			this.mostrarCarta();
			viradaParaFrente = true;
			cont++;
			contCartasViradasUma++;

			var_Label_Cartas_Viradas.setText(contCartasViradasUma + "");

			if (cont == 1) {

				new Sound().cartaVirando();
				clicaPrimCarta = this;
			}

			if (cont == 2) {

				new Sound().cartaVirando();

				if (this.getPar().isViradaPraFrente()) {

					new Sound().acerto();
					JOptionPane.showMessageDialog(null, "Acertou!");
					clicaPrimCarta.setVisible(false);
					this.setVisible(false);
					clicaPrimCarta.viradaParaFrente = true;
					this.viradaParaFrente = true;
					var_Label_Pontos.setText(Pontuacao(+10));

					contCardViradaPar += 2;

				} else {

					new Sound().erro();
					JOptionPane.showMessageDialog(null, "Errou!");
					clicaPrimCarta.esconderCarta();
					this.esconderCarta();
					clicaPrimCarta.viradaParaFrente = false;
					this.viradaParaFrente = false;
					var_Label_Pontos.setText(Pontuacao(-5));

				}

				if (contCardViradaPar == 16) {

					if (Integer.parseInt(Pontuacao(0)) == 80) {

						new Sound().vitoria();
						JOptionPane.showMessageDialog(null,
								" Voce eh o Flipper !!" + "\n Sua pontuacao foi: " + Pontuacao(0));
					}

					if (Integer.parseInt(Pontuacao(0)) > 20) {
						JOptionPane.showMessageDialog(null,
								" Muito bem ! Continue praticando." + "\n Sua pontuacao foi: " + Pontuacao(0));
					}

					else {
						new Sound().vaia();
						JOptionPane.showMessageDialog(null,
								"Voce precisa estudar" + "\n Sua pontuacao foi: " + Pontuacao(0));
					}

					alimentarBanco();

					contCartasViradasUma = 0;
					pontos = 0;
					contCardViradaPar = 0;
				}

				clicaPrimCarta = null;
				cont = 0;

			}
		} else {

			esconderCarta();
			viradaParaFrente = false;
			clicaPrimCarta = null;
			cont = 0;
		}

	}

	@Override
	public void esconderCarta() {

		try {
			Image image = new FileConvert().convertImage("images/flipper.png");
			ImageIcon icon = new ImageIcon(new ImageIcon(image).getImage());
			this.setIcon(icon);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mostrarCarta() {

		ImageIcon icon = new ImageIcon(new ImageIcon(getImgFrente()).getImage());
		this.setIcon(icon);

	}

	public void alimentarBanco() {

		try {
			Client.jogadorDAO.update(Client.nomeCliente, Pontuacao(0));
		} catch (Exception e) {
			e.printStackTrace();
		}

		Client.jogadorDAO.mostrarScore();
	}

	public Image getImgFundo(String path) {
		Image imgFundo = null;

		try {
			imgFundo = new FileConvert().convertImage(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return imgFundo;
	}

}
