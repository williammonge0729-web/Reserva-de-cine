package Reserva_Cine;

import javax.sound.sampled.*;
import java.io.File;

public class MusicaFondo {

    public static void main(String[] args) {

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

            // Mantiene el programa abierto
            Thread.sleep(Long.MAX_VALUE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}