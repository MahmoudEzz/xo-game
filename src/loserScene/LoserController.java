/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loserScene;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import scene.ChangeView;

/**
 * FXML Controller class
 *
 * @author mahmo
 */
public class LoserController implements Initializable {

    ChangeView cv = new ChangeView();
    
    @FXML private MediaView mv;
    private MediaPlayer mp;
    private Media me;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String path = new File("src/media/loser.mp4").getAbsolutePath();
        me = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(me);
        mv.setMediaPlayer(mp);
        mp.setAutoPlay(true);
        
    } 
    
    public void changeScreenToRematch(ActionEvent event) throws IOException{
        mp.stop();
        cv.changeScene("/rematchScene/rematchView.fxml", event);
    }
}
