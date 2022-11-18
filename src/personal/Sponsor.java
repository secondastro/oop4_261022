package personal;

import transport.Transport;
import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class Sponsor {
    private final String name;

    private final int sizeOfDonat;

    private final List<Transport> transportsArray = new ArrayList<>();

    public final static List<Sponsor> allSponsors = new ArrayList<>(15);

    public Sponsor(String name, int sizeOfDonat) {
        this.name = name;
        this.sizeOfDonat = sizeOfDonat;
        allSponsors.add(this);
    }

    public String getName() {
        return name;
    }


    public int getSizeOfDonat() {
        return sizeOfDonat;
    }


    public void toDonat(Transport... transports) {
        for (Transport transport : transports) {
            transport.setSponsors(this);
            transportsArray.add(transport);
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
