package model;

import utility.observer.subject.UnnamedPropertyChangeSubject;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Model extends UnnamedPropertyChangeSubject {
    void setUserName(String userName);

    void setUserNameClient(String userNameClient);

    void setUserNameEmployee(String userNameEmployee);

    ArrayList<String>getUserListClient();
    ArrayList<String>getUserListEmployee();


    void removeUserClient();

    void removeUserEmployee();

    void connectClient() throws RemoteException, NotBoundException, MalformedURLException;


    void connectEmployee() throws RemoteException, NotBoundException, MalformedURLException;

    boolean isConnected();

    void addUserClient(String name);

    void addUserEmployee(String name);

    UserList getUsersClient();

    UserList getUsersEmployee();

    void removeUserClient(String username);

    void removeUserEmployee(String username);

    String getUserNameClient();

    String getUserNameEmployee();

    void connect();
}
