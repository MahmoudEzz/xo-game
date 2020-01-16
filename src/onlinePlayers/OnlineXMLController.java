/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinePlayers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import scene.ChangeView;
/**
 * FXML Controller class
 *
 * @author Ahmed
 */
public class OnlineXMLController implements Initializable {

    ChangeView cv = new ChangeView();
    
    @FXML
    private Button btnPreGames;
    @FXML
    private ListView<String> lstView;
    ObservableList<String> list = FXCollections.observableArrayList("Mahmoud", "Ahmed", "Hussien", "Ramy",
            "Mahmoud", "Ahmed", "Hussien", "Ramy", "Mahmoud", "Ahmed", "Hussien", "Ramy"
    ,"Mahmoud", "Ahmed", "Hussien", "Ramy","Mahmoud", "Ahmed", "Hussien", "Ramy"
    ,"Mahmoud", "Ahmed", "Hussien", "Ramy");
    @FXML
    private AnchorPane anchor;
    

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public void backToMenu(ActionEvent event) throws IOException{
        cv.changeScene("/start/start.fxml", event);
    }
    @FXML
    private void gotoPreGames(ActionEvent event) throws IOException {
        cv.changeScene("/PreGames/PreGames.fxml", event);
    }
    @FXML
    private void makeReq(MouseEvent event) throws IOException {
        cv.changeSceneMouse("/makeReq/Req.fxml", event);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         lstView.setItems(list);
    }    

    
    
}
