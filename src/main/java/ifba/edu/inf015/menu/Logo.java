package ifba.edu.inf015.menu;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Logo extends JLabel{
	
	public Logo(int xPosition, int yPosition, int width, int height) {
		this.setIcon(new ImageIcon(Credits.class.getResource("/imagens/IFBALogo.png")));
		this.setBounds(xPosition, yPosition, width, height);
	}
	
	public Logo(int xPosition, int yPosition, int width, int height, String path) {
		InputStream image = this.getClass().getClassLoader().getResourceAsStream(path);
		
		try {
			Image bufferedImage = ImageIO.read(image);
			this.setIcon(new ImageIcon(bufferedImage));
			this.setBounds(xPosition, yPosition, width, height);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
}
