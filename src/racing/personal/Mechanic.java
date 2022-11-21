package racing.personal;

import racing.transport.Transport;
import utils.ValidationUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mechanic<T extends Transport> {
    private final String name;
    private final String organization;

    private final String specialization;

    private final Set<Transport> transportsSet = new HashSet<>();

    public static final Set<Mechanic> allMechanics = new HashSet<>();


    public Mechanic(String name, String organization, String specialization) {
        this.name = ValidationUtils.validationString(name, "default");
        this.organization = ValidationUtils.validationString(organization, "default");
        this.specialization = specialization;
        allMechanics.add(this);
    }


    @SafeVarargs
    public final void serve(T... transports) {
        for (T transport : transports) {
            if (!transportsSet.contains(transport)) {
                transportsSet.add(transport);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mechanic)) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return name.equals(mechanic.name) && organization.equals(mechanic.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, organization);
    }

    @Override
    public String toString() {
        return "механик "
                + name +  " из организации " +
                 organization  +
                ", специализация " + specialization ;
    }
}
