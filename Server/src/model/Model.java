package model;

import utility.UnnamedPropertyChangeSubject;

public interface Model extends UnnamedPropertyChangeSubject

{
    void addUserClient(String name);
    void addUserEmployee(String name);



    UserList getUsersClient();
    UserList getUsersEmployee();
    void removeUser(String username);
}
