package taxi;

public class Taxi implements Runnable {
    private CallCenter callCenter;
    private int target;

    public Taxi(CallCenter callCenter, int target) {
        this.callCenter = callCenter;
        this.target = target;
    }

    @Override
    public synchronized void run() {
        while (true) {
            Client client = callCenter.takeOrder(target);

            if (client != null) {
                try {
                    Thread.sleep(30);
                    System.out.println(client.getPhone() + " " + client.getTarget() + " " + client.getMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            } else
                break;
        }
    }
}

