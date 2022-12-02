package mediator;

import model.UserList;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface BookingEmployeeModel {

    void connectEmployee()throws RemoteException, MalformedURLException, NotBoundException;

    UserList getUserListEmployee();

    void removeUserEmployee(String userName);

    void close();


}
