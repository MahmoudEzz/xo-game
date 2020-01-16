/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package receiveReq;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import scene.ChangeView;

/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class ReceiveReqController implements Initializable {

    ChangeView cv = new ChangeView();
    
    @FXML
    private Button btnAccept;
    @FXML
    private Button btnRefused;
    @FXML
    private CheckBox ckBxRecord;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openXOBoard(ActionEvent event) throws IOException {
        System.out.println("Accepted");
                cv.changeScene("/TwoPlayers/Two.fxml", event);
    }

    @FXML
    private void goToOnlinePlayers(ActionEvent event) throws IOException {
        cv.changeScene("/onlinePlayers/onlineXML.fxml", event);
    }

    @FXML
    private void recordGameReceived(ActionEvent event) {
        System.out.println("Recorded");
    }
    
}
