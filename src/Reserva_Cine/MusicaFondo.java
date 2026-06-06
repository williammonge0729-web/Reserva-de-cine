package Reserva_Cine;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class MusicaFondo {

    public static void encenderMusica() {
        try {
            // Al no llevar "/" al inicio, busca el archivo en su misma carpeta (Reserva_Cine)
            URL url = MusicaFondo.class.getResource("Music_menu.wav");
            
            if (url == null) {
                System.out.println("Error: No se encontró el archivo Music_menu.wav dentro del paquete.");
                return; 
            }

            AudioInputStream audio = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            
            // Bucle continuo para la música de fondo
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error al reproducir el audio: " + e.getMessage());
        }
    }
}

