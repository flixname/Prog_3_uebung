package ui.gui;

import domainLogic.MainLogic;
import javafx.fxml.FXML;
import ui.cli.commands.CreateContentCommand;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import ui.cli.commands.CreateUploaderCommand;
import ui.cli.commands.AddressCommand;


public class Controler_GUI {
    MainLogic mainLogic = new MainLogic(100);

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
        CreateUploaderCommand createUploaderCommand = new CreateUploaderCommand(contentInput.getText());
        mainLogic.createUploader(createUploaderCommand.getUploader());
        //TODO Update
    }

    private void deleteBtnClicked() {
        //AddressCommand addressCommand = new AddressCommand(contentInput.getText());
        //glContent.deleteSingleContent(addressCommand.getAddress());
        //TODO Update
    }

    private void updateBtnClicked() {
        AddressCommand addressCommand = new AddressCommand(contentInput.getText());
        mainLogic.update(addressCommand.getAddress());
    }

    private void setPromtTxt(){
        //TODO
    }

    private void createBtnClicked() {
        CreateContentCommand createContentCommand = new CreateContentCommand(contentInput.getText());
        mainLogic.createContent(createContentCommand.getContent(), createContentCommand.getUploader(), createContentCommand.getTags(), createContentCommand.getBitrate(), createContentCommand.getDuration());
    }

    private void readBtnClicked() {
        //glContent.readContentByType(contentInput.getText());
        //TODO Update
    } //TODO: Command erstellen

}
