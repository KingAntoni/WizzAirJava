package mediator;

import model.UserList;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface BookingClientModel {

    void connectClient()throws RemoteException, MalformedURLException, NotBoundException;

    UserList getUserListClient();

    void removeUserClient(String userName);



    void close();
}
