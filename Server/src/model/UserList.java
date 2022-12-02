package model;

import java.io.Serializable;
import java.util.ArrayList;

public class UserList implements Serializable
{
    private ArrayList<String> userListClient;
    private ArrayList<String> userListEmployee;

    public UserList()
    {
        userListClient = new ArrayList<>();
        userListEmployee=new ArrayList<>();
    }

    public ArrayList<String> getUserListClient()
    {
        return userListClient;
    }

    public ArrayList<String> getUserListEmployee()
    {
        return userListEmployee;
    }
    public void addUserClient(String username)
    {
        userListClient.add(username);
    }

    public void addUserEmployee(String username)
    {
        userListEmployee.add(username);
    }

    public void removeUser(String username)
    {
        int i = 0;
        while (i < userListEmployee.size()||i<userListClient.size())
        {
            if (userListEmployee.get(i).equals(username))
            {
                userListEmployee.remove(i);
            }
            else if (userListClient.get(i).equals(username)){
                userListClient.remove(i);
            }
            i++;
        }
    }


}
