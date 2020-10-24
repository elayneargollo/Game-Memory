package ifba.edu.inf015.jogo;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	String musicJogo = null;
	private int titleMusic[] = {1, 2, 3, 4, 5, 6};
	private Clip oClip;
	
	private void play(String path, boolean loop) {
		try {
			InputStream input = (InputStream) getClass().getResourceAsStream(path);
			InputStream bufferedIn = new BufferedInputStream(input);
			oClip = AudioSystem.getClip();

			AudioInputStream audio = AudioSystem.getAudioInputStream(bufferedIn);

			oClip.open(audio);
			
			if(loop) {
				oClip.loop(Clip.LOOP_CONTINUOUSLY);
			}else {
				oClip.loop(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buttonSound() {
		this.play("/audios/botao.wav", false);
	}
	
	public void cardTurn() {
		this.play("/audios/turn.wav", false);
	}

	public void erro() {
		this.play("/audios/erro2.wav", false);
	}

	public void acerto() {
		this.play("/audios/acerto.wav", false);
	}

	public void vitoria() {
		this.play("/audios/vitoria.wav", false);
	}

	public void mainMusic() {
		String path = "/audios/" + this.getRandom(titleMusic) + ".wav";
			
		this.play(path, true);
	}

	public void point() {
		this.play("/audios/acerto.wav", false);
	}

	public void stop() {
		try {
			oClip.stop();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void boo() {
		this.play("/audios/vaia.wav", false);
	}
	
	public int getRandom(int[] array){
	    int randomElement = new Random().nextInt(array.length);
	    
	    return array[randomElement];
	}
}