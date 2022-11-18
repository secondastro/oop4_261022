package personal;

import transport.Transport;
import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class Mechanic<T extends Transport> {
    private final String name;
    private final String organization;

    private final String specialization;

    private final List<Transport> transportsArray = new ArrayList<>();

    public List<Mechanic> allMechanics = new ArrayList<>(15);


    public Mechanic(String name, String organization, String specialization) {
        this.name = ValidationUtils.validationString(name, "default");
        this.organization = ValidationUtils.validationString(organization, "default");
        this.specialization = specialization;
        allMechanics.add(this);
    }


    @SafeVarargs
    public final void serve(T... transports) {
        for (T transport : transports) {
            if (!transportsArray.contains(transport)) {
                transportsArray.add(transport);
            }
            if (transport.getMechanics()==null || !transport.getMechanics().contains(this)) {
                transport.setMechanics(this);
            }
            System.out.println(this.getName() + " провел техобслуживание " + transport.getBrand() + " " + transport.getModel());
        }
    }

    public String getName() {
        return name;
    }



    public String getOrganization() {
        return organization;
    }


    public String getSpecialization() {

        return specialization;
    }

    @Override
    public String toString() {
        return "механик "
                + name +  " из организации " +
                 organization  +
                ", специализация " + specialization ;
    }
}
