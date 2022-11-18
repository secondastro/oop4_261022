package personal;

import transport.Transport;
import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class Sponsor {
    private String name;

    private int sizeOfDonat;

    private final List<Transport> transportsArray = new ArrayList<>();

    public final static List<Sponsor> allSponsors = new ArrayList<>(15);

    public Sponsor(String name, int sizeOfDonat) {
        setName(name);
       // this.sizeOfDonat = sizeOfDonat;
        setSizeOfDonat(sizeOfDonat);
        allSponsors.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public int getSizeOfDonat() {
        return sizeOfDonat;
    }

    public void setSizeOfDonat(int sizeOfDonat) {
        try {
            this.sizeOfDonat = ValidationUtils.validationInt(sizeOfDonat);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void toDonat(Transport...transports) {
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
