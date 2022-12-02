import mediator.BookingServer;
import mediator.ThreadSafeServer;
import model.Model;
import model.ModelManager;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

public class Server
{
    public static void main(String[] args) throws MalformedURLException, RemoteException {
        Model model = new ModelManager();
       BookingServer bookingServer = new BookingServer(model);
        ThreadSafeServer server=new ThreadSafeServer();
    }
}
