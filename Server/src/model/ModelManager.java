package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
    private PropertyChangeSupport property;
    private UserList usersClient;
    private UserList usersEmployee;
    public ModelManager()
    {
        this.usersClient = new UserList();
        this.usersEmployee = new UserList();
        this.property = new PropertyChangeSupport(this);
    }

    @Override
    public void addListener(PropertyChangeListener listener)
    {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener)
    {
        property.removePropertyChangeListener(listener);
    }

    @Override
    public void addUserClient(String name) {
        usersClient.addUserClient(name);
    }

    @Override
    public void addUserEmployee(String name) {
        usersEmployee.addUserEmployee(name);
    }

    @Override
    public UserList getUsersClient() {
        return usersClient;
    }

    @Override
    public UserList getUsersEmployee() {
        return usersEmployee;
    }

    @Override
    public void removeUser(String username) {
        usersClient.removeUser(username);
        usersEmployee.removeUser(username);
    }


}
