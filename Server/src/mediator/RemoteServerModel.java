package mediator;

import model.Booking;
import model.UserList;
import utility.observer.subject.RemoteSubject;

import java.rmi.RemoteException;

public interface RemoteServerModel extends RemoteSubject<Booking, UserList> {

    void addUserClient(String name) throws RemoteException;
    void addUserEmployee(String name) throws RemoteException;



    UserList getUsersClient() throws RemoteException;
    UserList getUsersEmployee() throws RemoteException;



    void removeUser(String username)throws RemoteException;
}
