import transport.Bus;
import transport.Transport;


import java.util.LinkedList;
import java.util.Queue;

public class Station<T extends Transport> {

    public Queue<T> queue = new LinkedList<>();

    public void addToQueue(T transport) {
        try {
            if (transport.getClass() != Bus.class) {
                queue.offer(transport);
            } else {
                throw new IllegalArgumentException(transport.getBrand() + " хотел пройти ТО, но понял, что он автобус, и ушел домой");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void doMaintenance() {
        T transport = queue.poll();
        if (transport != null) {
            System.out.println(transport.getBrand() + " " + transport.getModel() + " прошел ТО");
            doMaintenance();
        }

    }

}
