
package start;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import scene.ChangeView;


public class StartController implements Initializable {

    ChangeView cv = new ChangeView();
    
    public void start(ActionEvent event) throws IOException{
       // new XOController();
        cv.changeScene("/XO/XO.fxml", event);
    }
    
    public void Two(ActionEvent event) throws IOException{
        cv.changeScene("/TwoPlayers/Two.fxml", event);
    }
    public void Three(ActionEvent event) throws IOException{
        cv.changeScene("/loginscene/Login.fxml", event);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
}
