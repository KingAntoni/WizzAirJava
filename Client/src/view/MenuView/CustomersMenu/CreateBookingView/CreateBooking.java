package view.MenuView.CustomersMenu.CreateBookingView;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import view.ViewHandler;
import viewModel.CreateBookingViewModel;

import java.awt.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CreateBooking {
    @FXML TextField inputUserName;
    @FXML ListView<String> bookingList;
    @FXML TextField bookingField;
    @FXML Label errorLabel;
    private Region root;
    private ViewHandler viewHandler;
    private CreateBookingViewModel createBookingViewModel;
    public void innit(ViewHandler viewHandler, CreateBookingViewModel createBookingViewModel, Region root){
        this.viewHandler=viewHandler;
        this.root=root;
        this.createBookingViewModel = createBookingViewModel;
        this.bookingList.setItems(createBookingViewModel.getItems());
    }
    public Region getRoot(){
        return root;
    }
    public void reset(){inputUserName.setText("");}
    private @FXML void onConnect() throws RemoteException, NotBoundException, MalformedURLException {
        if(inputUserName.getText().equals(""))
        {
            inputUserName.setText("Select Username");
            System.out.println("No username was set");
        }
        else if(!(createBookingViewModel.isConnected())){
            createBookingViewModel.setUsername(inputUserName.getText());
            createBookingViewModel.connect();
            inputUserName.setText("");
            errorLabel.setText("Connected");
        }
}
    @FXML
    public void onEnter(){
        createBookingViewModel.sendBookingDetails(bookingField.getText());

    }
    private @FXML void onCurrentUsers()
    {
        if(createBookingViewModel.isConnected()){
            viewHandler.openView("userList");

        }
        else{
            errorLabel.setText("You must be connected");
        }
}
}
