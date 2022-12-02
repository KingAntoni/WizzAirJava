package model;

import mediator.BookingClient;
import mediator.BookingEmployee;
import utility.UnnamedPropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class ModelManager implements Model, UnnamedPropertyChangeSubject {
    private PropertyChangeSupport property;
    private BookingClient client;
    private BookingEmployee employee;
    private String userNameClient;
    private String userNameEmployee;
    private boolean isConnected;
    public ModelManager(String userNameClient,String userNameEmployee)throws RemoteException,NotBoundException,MalformedURLException{
        this.userNameClient=userNameClient;
        this.userNameEmployee=userNameEmployee;
        property=new PropertyChangeSupport(this);
        client=new BookingClient(this);
        employee=new BookingEmployee(this);
        this.isConnected=false;
    }

    @Override
    public void setUserName(String userName) {

    }

    @Override
    public void setUserNameClient(String userNameClient) {
        this.userNameClient=userNameClient;
    }

    @Override
    public void setUserNameEmployee(String userNameEmployee) {
        this.userNameEmployee=userNameEmployee;
    }

    @Override
    public ArrayList<String> getUserListClient() {
        return client.getUserListClient().getUserListClient();
    }
    @Override
    public ArrayList<String> getUserListEmployee() {
        return employee.getUserListEmployee().getUserListEmployee();
    }

    @Override
    public String getUserNameClient() {
        return userNameClient;
    }
    @Override
    public String getUserNameEmployee() {
        return userNameEmployee;
    }

    @Override
    public void removeUserClient() {
    client.removeUserClient(userNameClient);
    }
    @Override
    public void removeUserEmployee() {
        employee.removeUserEmployee(userNameEmployee);
    }

    @Override
    public void connect() {

    }


    @Override
    public void connectClient() throws RemoteException, NotBoundException, MalformedURLException {
    client.connectClient();
    isConnected=true;
    }
    @Override
    public void connectEmployee() throws RemoteException, NotBoundException, MalformedURLException {
        employee.connectEmployee();
        isConnected=true;
    }

    @Override
    public boolean isConnected() {
        return isConnected;
    }

    @Override
    public void addUserClient(String name) {

    }

    @Override
    public void addUserEmployee(String name) {

    }

    @Override
    public UserList getUsersClient() {
        return null;
    }

    @Override
    public UserList getUsersEmployee() {
        return null;
    }

    @Override
    public void removeUserClient(String username) {

    }

    @Override
    public void removeUserEmployee(String username) {

    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }

}
