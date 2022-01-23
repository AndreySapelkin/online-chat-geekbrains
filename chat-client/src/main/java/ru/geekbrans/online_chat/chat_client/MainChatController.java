package ru.geekbrans.online_chat.chat_client;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class MainChatController implements Initializable {

    MultipleSelectionModel<String> langsSelectionModel;

    @FXML
    public TextField inputField;

    @FXML
    public VBox mainChatPanel;

    @FXML
    public TextArea mainChatArea;

    @FXML
    public ListView contactList;

    @FXML
    public Button btnSend;

    public void ConnectToServer(ActionEvent actionEvent) {
    }

    public void disconnectFromServer(ActionEvent actionEvent) {
    }

    public void mockAction(ActionEvent actionEvent) {
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(1);
    }

    public void showHelp(ActionEvent actionEvent) {
    }

    public void showAbout(ActionEvent actionEvent) {
    }

    public void sendMessage(ActionEvent actionEvent) {

        var selectUserContact = langsSelectionModel.getSelectedItems();
        var userMessage = inputField.getText();
        if (userMessage.isBlank()) {
            return;
        }

        var fullMessage = new SimpleDateFormat("HH:mm:ss").format(new Date())
                + " - "
                + userMessage
                + System.lineSeparator();

        if (selectUserContact.size() == 0) {
            mainChatArea.appendText("ALL: " + fullMessage);
        } else {
            mainChatArea.appendText(String.join(", ", selectUserContact) + ": " + fullMessage);
        }
        inputField.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        var contacts = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            contacts.add("Contact#" + (i + 1));
        }
        contactList.setItems(FXCollections.observableList(contacts));

        langsSelectionModel = contactList.getSelectionModel();
        langsSelectionModel.setSelectionMode(SelectionMode.MULTIPLE);

    }
}
