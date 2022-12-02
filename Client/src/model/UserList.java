package model;

import java.util.ArrayList;

public class UserList {
    private ArrayList<String>userListClient;
    private ArrayList<String>userListEmployee;
    public UserList(){
        userListClient=new ArrayList<>();
        userListEmployee=new ArrayList<>();
    }

    public ArrayList<String> getUserListClient() {
        return userListClient;
    }
    public ArrayList<String> getUserListEmployee() {
        return userListEmployee;
    }
    public void addUserClient(String userName){
        userListClient.add(userName);
    }
    public void addUserEmployee(String userName){
        userListEmployee.add(userName);
    }
    public void removeUserName(String userName){
        int i=0;
        while (i<userListClient.size()||i<userListEmployee.size()){
            if (userListClient.get(i).equals(userName)){
                userListClient.remove(i);
            }
            else if (userListEmployee.get(i).equals(userName))
            {
                userListEmployee.remove(i);
            }
            i++;
        }
    }

    public void removeUserNameClient() {
    }
}
