import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class Sound extends Applet{
   private AudioClip sound1; 
    

    public void init(){
        sound1 = getAudioClip(getCodeBase(),"sounds/violin.mp3");
        sound1.play();
        


}
}