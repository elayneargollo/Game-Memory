package ifba.edu.inf015.lib;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileConvert {

	public Image convertImage(String path) throws IOException {

		Image image = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(path));
		return image;
	}

}
