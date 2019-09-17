package taxi;

import java.util.Random;

public class ClientGenerator implements Runnable {

    private CallCenter callCenter;
    private int clientCounter;

    public ClientGenerator(CallCenter callCenter, int clientCounter) {
        this.callCenter = callCenter;
        this.clientCounter = clientCounter;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < clientCounter) {
            Client client = new Client();
            count++;
            client.setTarget(new Random().nextInt(10));
            client.setMessage("<target>" + client.getTarget() + "<target>");
            callCenter.takeCall(client);
        }
    }
}
