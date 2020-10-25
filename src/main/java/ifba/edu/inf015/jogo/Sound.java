package ifba.edu.inf015.jogo;

import java.io.InputStream;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	String musicJogo = null;
	private int titleMusic[] = {1, 2, 3, 4, 5, 6};
	private Clip oClip;

	public void cartaVirando() {

		try {
			String resource = "/audios/turn.wav";
			
			InputStream input = getClass().getResourceAsStream(resource);

			oClip = AudioSystem.getClip();
			AudioInputStream audio = AudioSystem.getAudioInputStream(input);
			oClip.open(audio);
			oClip.loop(0); 

		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	private void play(String path) {
		try {
			InputStream input = (InputStream) getClass().getResourceAsStream(path);
			oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(input);

			oClip.open(audio);
			oClip.loop(Clip.LOOP_CONTINUOUSLY);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selecionado() {
		this.play("/audios/botao.wav");
	}

	public void erro() {
		this.play("/audios/erro2.wav");
	}

	public void acerto() {
		this.play("/audios/acerto.wav");
	}

	public void vitoria() {
		this.play("/audios/vitoria.wav");
	}

	public void mainMusic() {
		String path = "/audios/" + this.getRandom(titleMusic) + ".wav";
			
		this.play(path);
	}

	public void turn() {
		this.play("/audios/acerto.wav");
	}

	public void stop() {
		try {
			oClip.stop();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void vaia() {
		this.play("/audios/vaia.wav");
	}
	
	public int getRandom(int[] array){
	    int randomElement = new Random().nextInt(array.length);
	    
	    return array[randomElement];
	}
}
