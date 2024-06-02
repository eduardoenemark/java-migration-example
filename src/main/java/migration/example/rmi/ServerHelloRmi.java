package migration.example.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerHelloRmi extends UnicastRemoteObject implements HelloRmi {

    public ServerHelloRmi() throws RemoteException {
        super();
    }

    @Override
    public String hello() {
        try {
            return "Hello";
        } finally {
            Thread.currentThread().destroy();
        }
    }
}
