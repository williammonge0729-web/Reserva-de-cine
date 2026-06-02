package Reserva_Cine;

import javax.sound.sampled.*;
import java.io.File;

public class MusicaFondo {
  
	public static void encenderMusica() {
  

        try {
            File archivo = new File("recursos/Music_menu.wav");

            AudioInputStream audio =
                    AudioSystem.getAudioInputStream(archivo);

            Clip clip = AudioSystem.getClip();
            clip.open(audio);

            // 🔁 LOOP INFINITO
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();

            System.out.println("Musica en loop...");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}