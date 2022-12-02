package mediator;
import model.Booking;
import model.Model;
import utility.observer.event.ObserverEvent;
import utility.observer.listener.RemoteListener;

import model.UserList;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BookingClient implements BookingClientModel,RemoteListener<Booking,UserList >{
    private RemoteBookingModel server;
    private Model model;
    public BookingClient(Model model){
        this.model=model;
    }
    @Override
    public void connectClient()throws RemoteException, MalformedURLException, NotBoundException{
        server=(RemoteBookingModel) Naming.lookup("rmi://localhost:1099/booking");
        UnicastRemoteObject.exportObject(this,0);
        server.addListener(this,"booking");
        server.addUserClient(model.getUserNameClient());
    }

    @Override
    public UserList getUserListClient(){
        return server.getUsersClient();
    }

    @Override
    public void removeUserClient(String userNameClient){
        server.removeUserClient(userNameClient);
    }



    @Override
    public void close(){

    }
    @Override
    public void propertyChange(ObserverEvent<Booking,UserList> event) throws RemoteException {
        //getBookingFromServer
    }
}
