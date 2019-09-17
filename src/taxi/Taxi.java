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
        //List<taxi.Client> clients = new ArrayList<>();
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
        //while (true) {
          //  try {
            //    taxi.Client client = callCenter.takeOrder(this.target);
              //  if (client != null) {
//
  ///                  Thread.sleep(3000);
     //               System.out.println(client + " " + client.getTarget() + " " + client.getMessage());
       //         }
         //   } catch (InterruptedException e) {
           //     e.printStackTrace();
            //}
        }
    }

