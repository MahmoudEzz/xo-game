/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawScene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import scene.ChangeView;

/**
 * FXML Controller class
 *
 * @author mahmo
 */
public class DrawController implements Initializable {

    ChangeView cv = new ChangeView();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void changeScreenToRematch(ActionEvent event) throws IOException{
        cv.changeScene("/rematchScene/rematchView.fxml", event);
    }
}
    

