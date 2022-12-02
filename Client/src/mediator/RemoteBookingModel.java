package mediator;

import model.Booking;
import model.UserList;
import utility.observer.subject.RemoteSubject;

public interface RemoteBookingModel extends RemoteSubject<Booking, UserList> {


    void addUserClient(String name);

    void addUserEmployee(String name);



    UserList getUsersClient();

    UserList getUsersEmployee();



    void removeUserClient(String username);

    void removeUserEmployee(String username);
}
