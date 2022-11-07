package transport;

public class Truck extends Transport implements Competing {

    public enum LoadCapacity{N1(null, 3.5f),
        N2(3.5f, 12f),
        N3(12f, null);
        private final Float capacityMin;
        private final Float capacityMax;

        public Float getCapacityMin() {
            return capacityMin;
        }

        public float getCapacityMax() {
            return capacityMax;
        }

        LoadCapacity(Float capacityMin, Float capacityMax) {
            this.capacityMin = capacityMin;
            this.capacityMax = capacityMax;
        }

        @Override
        public String toString() {
            String capacityPassMin = capacityMin != null
                    ? "от " + capacityMin
                    : "";
            String capacityPassMax = capacityMax !=null
                    ? " до " + capacityMax : "";
            return "грузоподъемность: " + capacityPassMin + capacityPassMax + " тонн";
        }
    }

    private final LoadCapacity loadCapacity;

    public Truck(String brand, String model, double engineVolume, Circles circles, LoadCapacity loadCapacity) {
        super(brand, model, engineVolume, circles);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void printType() {
        if (this.loadCapacity != null) {
            System.out.println(this.loadCapacity);
        } else {
            System.out.println("Информации не достаточно");
        }

    }

    @Override
    public void start() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " начал движение");
    }

    @Override
    public void finish() {
        System.out.println("Грузовой автомобиль " + getBrand() + " " + getModel() + " закончил движение");
    }


    @Override
    public String pitStop() {
        return getBrand() + " " + getModel() + " заехал на пит-стоп";
    }
    @Override
    public String maxSpeed() {
        int max = Integer.MIN_VALUE;
        int [] arr = getCircles().getSpeed();
        for (int anInt : arr) {
            if (anInt > max) {
                max = anInt;
            }
        }
        return "Максимальная скорость грузовика " + getBrand() + " " + getModel() + ": " + max + " км/ч";


    }

    public String BestTime() {
        double[] arr = getCircles().getTimes();
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return "Грузовик " + getBrand() + " " + getModel() + ". Лучшее время круга: " + min + " секунд";
    }
}

