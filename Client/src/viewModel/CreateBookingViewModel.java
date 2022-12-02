package viewModel;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Booking;
import model.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CreateBookingViewModel implements PropertyChangeListener {
    private ObservableList<String> listView;
    private Model model;
    private Booking booking;

    public CreateBookingViewModel(Model model) {
        this.model = model;
        this.listView = FXCollections.observableArrayList();
        this.model.addListener(this);
    }


    public boolean isConnected() {
        return model.isConnected();
    }

    public void connect() throws RemoteException, NotBoundException, MalformedURLException {
        model.connect();
    }

    public ObservableList<String> getItems() {
        return listView;
    }

    public void setUsername(String usernameString) {
        model.setUserName(usernameString);
    }

    public void sendBookingDetails(String text) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(() ->
                {
                    if (evt.getPropertyName().equals("NewBookingFromServer")) {
                        listView.add((((Booking) evt.getNewValue()).getBookingNumber()));
                    }
                }
        );
    }
}
