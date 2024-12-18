import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {
    public static void main(String[] args) throws Exception {
        
        String filePath = "src\\clean-trap-loop-131bpm-136738.wav";
        File file = new File(filePath);

        try(Scanner scan = new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);) {
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
                

            String response = "";

            while(!response.equals("Q")){

                System.out.println("P = Play");
                System.out.println("Q = Quit");
                System.out.println("S = Stop");
                System.out.println("R = Restart");
                System.out.print("Enter your choise"); 

                response = scan.next().toUpperCase();

                switch(response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid Choice");
                }
            }
        } 
        catch(UnsupportedAudioFileException e) {
            
            System.out.println("Audio file is not Supported");
        }
        catch(FileNotFoundException e){
            
            System.out.print("Could not find file");
        }
        catch(LineUnavailableException e){
            
            System.out.println("Unable to access sudio resource");
        }

        catch (IOException e) {
            
            System.out.println("Something Went Wong UwU");
        }
        finally{

            System.out.println("Bye");
        }
        
    }
}
