package ifba.edu.inf015.jogo;

import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public abstract class Letter extends JLabel {

	public static int cont = 0;
	public static int pontos = 0;
	public static int contCardViradaPar = 0;
	public static int contCartasViradasUma = 0;
	public static Letter clicaPrimCarta;
	protected Image imgFrente;
	protected boolean viradaParaFrente = false;
	public Letter par;
	public JLabel var_Label_Pontos;
	public JLabel var_Label_Cartas_Viradas;
	public JMenuItem novoJogo;

	public Letter(Image imgF, JLabel Label_pont, JLabel cartasViradas, JMenuItem novojogo) {
		super();	
	}

	public static String Pontuacao(int num) {
		pontos = (num) + pontos;
		String nome_num = pontos + "";
		return nome_num;
	}
	
	public Image getImgFrente() {
		return imgFrente;
	}
	
	public void setImgFrente(Image imgFrente) {
		this.imgFrente = imgFrente;
	}

	public boolean isViradaPraFrente() {
		return viradaParaFrente;
	}

	public void setViradaPraFrente(boolean viradaParaFrente) {
		this.viradaParaFrente = viradaParaFrente;
	}
	
	public Letter getPar() {
		return par;
	}

	public void setPar(Letter par) {
		this.par = par;
	}

	public abstract void esconderCarta();
	public abstract void mostrarCarta();
	public abstract void subMenuDeJogoNovoJogoActionPerformed();
	public abstract void capturarCliqueDoMouse();

}
