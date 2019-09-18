package taxi;

import java.util.ArrayList;
import java.util.List;

public class CallCenter {
    private static final int N = 100;
    private int clientCounter = 0;
    private List<Client> clients;

    public CallCenter(){
        clients = new ArrayList<>();
    }

    public synchronized boolean takeCall(Client client) {
            if (clientCounter < N) {
                client.setPhone("phone :" + clientCounter);
                clientCounter++;

                clients.add(client);
                System.out.println("Принят клиент " + client + "(" + client.getTarget() + "), " + client.getPhone()
                        + " "  + "с машиной " + client.getTarget());

            } else {
                System.out.println("Не хватает места");
                return false;
            }
        return true;
    }

    public synchronized Client takeOrder(int target) {
            if (clientCounter > 0) {
               notifyAll();
                for (Client client : clients) {
                    if (client.getTarget() == target) {
                        clientCounter--;
                       client.setPhone("Phone " + clients.indexOf(client));
                        clients.remove(client);
                        return client;
                    }
                }
            }

        return null;
    }
}
