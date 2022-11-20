package racing.personal;

import racing.transport.Transport;

import java.util.HashSet;
import java.util.Set;

public class Sponsor {
    private final String name;

    private final int sizeOfDonat;





    public Sponsor(String name, int sizeOfDonat) {
        this.name = name;
        this.sizeOfDonat = sizeOfDonat;
        allSponsors.add(this);
    }
    public static final Set<Sponsor> allSponsors = new HashSet<>();
    private final Set<Transport> transportsSet = new HashSet<>();

    public String getName() {
        return name;
    }


    public int getSizeOfDonat() {
        return sizeOfDonat;
    }


    public void toDonat(Transport... transports) {
        for (Transport transport : transports) {
            transport.setSponsors(this);
            transportsSet.add(transport);
            transport.setMoney(getSizeOfDonat());
            System.out.println("Участник на " + transport.getBrand() + " " +
                    transport.getModel() + " благодарит спонсора " + getName() + " за помощь в " + getSizeOfDonat() + " тенге");
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
