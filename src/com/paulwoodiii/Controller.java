package com.paulwoodiii;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TextField usernameTextField;

    @FXML
    PasswordField passwordTextField;

    @FXML
    TextField emailTextField;

    @FXML
    ListView list;

    ObservableList<Person> people;


    public void addButtonPressed(){
        System.out.println("addItem");

        String username = usernameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordTextField.getText();

        if (    username != null && !username.isEmpty() &&
                email != null && !email.isEmpty() &&
                password != null && !password.isEmpty()
                ) {
            Person p = new Person(username,email,password);
            people.add(p);
            usernameTextField.clear();
            emailTextField.clear();
            passwordTextField.clear();
            list.refresh();
            persist();
        }
    }

    public void deleteButtonPressed(){
        Person item = (Person) list.getSelectionModel().getSelectedItem();
        if (item != null) {
            people.remove(item);
            list.refresh();
            persist();
        }
    }

    public void usernameOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

        }
    }

    public void emailOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

        }
    }

    public void passwordOnKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

        }
    }

    public void persist(){

        DataStore.persist("users.json",people);
    }

    public void load(){
        ArrayList<Person> personArrayList = DataStore.load("users.json");
        people = FXCollections.observableArrayList();
        people.addAll(personArrayList);
        list.setItems(people);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        load();
    }

}
