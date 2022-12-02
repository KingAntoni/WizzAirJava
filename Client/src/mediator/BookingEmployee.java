package mediator;

import model.Booking;
import model.Model;
import model.UserList;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.RemoteListener;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BookingEmployee implements BookingEmployeeModel, RemoteListener<Booking, UserList> {
    private RemoteBookingModel server;
    private Model model;
    public BookingEmployee(Model model){
        this.model=model;
    }

    @Override
    public void connectEmployee()throws RemoteException, MalformedURLException, NotBoundException {
        server=(RemoteBookingModel) Naming.lookup("rmi://localhost:1099/booking");
        UnicastRemoteObject.exportObject(this,0);
        server.addListener(this,"booking");
        server.addUserEmployee(model.getUserNameEmployee());
    }

    @Override
    public UserList getUserListEmployee(){
        return server.getUsersEmployee();
    }

    @Override
    public void removeUserEmployee(String userNameEmployee){
        server.removeUserEmployee(userNameEmployee);
    }

    @Override
    public void close(){

    }
    @Override
    public void propertyChange(ObserverEvent<Booking,UserList> event) throws RemoteException {
        //getBookingFromServer
    }
}