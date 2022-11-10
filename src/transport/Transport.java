package transport;

import java.util.Arrays;
import java.util.Objects;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final double engineVolume;
    private Circles circles;

    public static Transport[] testedTransports = new Transport[0];

    public static class Circles {
        private double[] times;
        private int[] speed;

        public Circles(double[] times, int[] speed) {
            this.times = times;
            this.speed = speed;
        }

        public double[] getTimes() {
            return times;
        }

        public void setTimes(double[] times) {
            this.times = times;
        }

        public int[] getSpeed() {
            return speed;
        }

        public void setSpeed(int[] speed) {
            this.speed = speed;
        }
    }

    private static int counter = 0;
    public String s =null;

    public Transport(String brand, String model, double engineVolume, Circles circles) {
        this.brand = Objects.requireNonNullElse(brand, "default");
        this.model = Objects.requireNonNullElse(model, "default");
        if (engineVolume == 0) {
            this.engineVolume = 1.6;
        } else {
            this.engineVolume = engineVolume;
        }
        this.circles = circles;
    }

    public abstract void printType();

    public abstract void start();

    public abstract void finish();

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public Circles getCircles() {
        return circles;
    }

    public void setCircles(Circles circles) {
        this.circles = circles;
    }

    public static void transportTest(Transport... transports) {
        for (int i = 0; i < transports.length; i++) {
            if (counter == 0) {
                testedTransports = new Transport[1];
                testedTransports[0] = transports[i];
                counter++;
            } else {
                counter++;
                testedTransports = Arrays.copyOf(testedTransports, counter);
                testedTransports[counter - 1] = transports[i];
            }
        }
    }
    public abstract void checkTest() throws WrongTestDriveException;


    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }


}
