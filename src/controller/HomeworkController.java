package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HomeworkController {

    @FXML
    TableView tableView;

    @FXML
    TextField columns;
    @FXML
    TextField rows;
    @FXML
    Button ok;

    @FXML
    private void okButtonAction (ActionEvent e){
        System.out.println(columns.getText());
        System.out.print(rows.getText());
        tableView.g
    }
}
