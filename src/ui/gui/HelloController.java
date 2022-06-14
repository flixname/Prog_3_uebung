package ui.gui;

import domainLogic.ContentLogic;
import domainLogic.UploaderLogic;
import javafx.fxml.FXML;
import ui.cli.commands.AddressCommand;
import ui.cli.commands.ContentCommand;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.cli.commands.UploaderCommand;


public class HelloController  {

    ContentLogic glContent = new ContentLogic();
    UploaderLogic glUploader = new UploaderLogic();

    @FXML
    private TextField contentInput;
    @FXML
    private Button createBtn;
    @FXML
    private Button createProducerBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private TextField producerInput;
    @FXML
    private Text producerPromptTxt;
    @FXML
    private Text promptContentTxt;
    @FXML
    private Button readBtn;
    @FXML
    private Button updateBtn;


    //methoden set,update usw
    public void initialize() {
        createBtn.setOnMouseClicked(mouseEvent -> this.createBtnClicked());
        readBtn.setOnMouseClicked(mouseEvent -> this.readBtnClicked());
        updateBtn.setOnMouseClicked(mouseEvent -> this.updateBtnClicked());
        deleteBtn.setOnMouseClicked(mouseEvent -> this.deleteBtnClicked());
        createProducerBtn.setOnMouseClicked(mouseEvent -> this.createProducerBtnClicked());
    }

    private void createProducerBtnClicked() {
        UploaderCommand uploaderCommand = new UploaderCommand(contentInput.getText());
        glUploader.createUploader(uploaderCommand.getUploader());
        //TODO Update
    }

    private void deleteBtnClicked() {
        AddressCommand addressCommand = new AddressCommand(contentInput.getText());
        //glContent.deleteSingleContent(addressCommand.getAddress());
        //TODO Update
    }

    private void updateBtnClicked() {
        AddressCommand addressCommand = new AddressCommand(contentInput.getText());
        glContent.update(addressCommand.getAddress());
        //TODO Update
    }

    private void setPromtTxt(){
        //TODO
    }

    private void createBtnClicked() {
        ContentCommand contentCommand = new ContentCommand(contentInput.getText());
        glContent.createContent(contentCommand.getContent(), contentCommand.getUploader(), contentCommand.getTags(), contentCommand.getBitrate(), contentCommand.getDuration());
        //TODO Update
    }

    private void readBtnClicked() {
        //glContent.readContentByType(contentInput.getText());
        //TODO Update
    } //TODO: Command erstellen

}
