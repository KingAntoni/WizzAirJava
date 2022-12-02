package mediator;

import model.Booking;
import model.Model;
import model.UserList;
import utility.observer.listener.GeneralListener;
import utility.observer.subject.PropertyChangeAction;
import utility.observer.subject.PropertyChangeProxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BookingServer implements RemoteServerModel {
    private PropertyChangeAction<Booking, UserList> property;
    private Model model;
    public BookingServer(Model model) throws RemoteException, MalformedURLException {
        this.model = model;
        startRegistry();
        UnicastRemoteObject.exportObject(this, 1099);
        Naming.rebind("booking", this);
        this.property= new PropertyChangeProxy<>(this, true);
        System.out.println("Server started...");
    }

    public static void startRegistry() throws RemoteException {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            System.out.println("Registry started......");
        } catch (java.rmi.server.ExportException e) {
            System.out.println("Registry already started perhaps?....." + e.getMessage());
        }
    }


    @Override
    public boolean addListener(GeneralListener<Booking, UserList> listener, String... propertyNames) throws RemoteException {
        return property.addListener(listener, propertyNames);
    }

    @Override
    public boolean removeListener(GeneralListener<Booking, UserList> listener, String... propertyNames) throws RemoteException {
        return property.removeListener(listener, propertyNames);
    }

    @Override
    public void addUserClient(String nameClient) {
        model.addUserClient(nameClient);
    }

    @Override
    public void addUserEmployee(String nameEmployee) {
        model.addUserEmployee(nameEmployee);
    }

    @Override
    public UserList getUsersClient() {
        return model.getUsersClient();
    }

    @Override
    public UserList getUsersEmployee() {
        return model.getUsersEmployee();
    }

    @Override
    public void removeUser(String username) {
        model.removeUser(username);
    }

}
