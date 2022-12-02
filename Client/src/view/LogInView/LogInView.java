package view.LogInView;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import view.ViewHandler;
import viewModel.LogInViewModel;


public class LogInView {
    @FXML
    TextField usernameField;
    @FXML
    TextField passwordField;
    private Region root;
    private ViewHandler viewHandler;
    private LogInViewModel viewModel;

    public void init(ViewHandler viewHandler, LogInViewModel logInViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.root = root;
        this.viewModel = logInViewModel;
        usernameField.textProperty().bindBidirectional(logInViewModel.getUsernameProperty());
        passwordField.textProperty().bindBidirectional(logInViewModel.getPasswordProperty());
    }

    @FXML
    public void loginButtonPressed() {
        boolean isValid = viewModel.login();
        if (isValid) {
            //open next view
        } else {
            //throw alert or whatever
        }


    }

    @FXML public void createAccountButtonPressed(){
        viewHandler.openView("selectUserType");
    }

    public void reset() {
    }

    public Region getRoot() {
        return root;
    }

}
