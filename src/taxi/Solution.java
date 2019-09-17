package taxi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution {
    public static void main(String[] args) {
        CallCenter callCenter = new CallCenter();

        ClientGenerator clientGenerator = new ClientGenerator(callCenter, 1000);

        Taxi[] taxis = new Taxi[10];
        for(int i = 0; i < taxis.length; i++) {
            taxis[i] = new Taxi(callCenter, i);
        }

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(clientGenerator);
        for (Taxi taxi : taxis)
            service.execute(taxi);
        service.shutdown();
    }
}






