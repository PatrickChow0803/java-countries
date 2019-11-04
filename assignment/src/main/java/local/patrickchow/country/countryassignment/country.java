package local.patrickchow.country.countryassignment;

import java.util.concurrent.atomic.AtomicLong;

public class country {

    private AtomicLong counter = new AtomicLong();
    private Long id;
    private String name;
    private int population;
    private double landMassSize;
    private double medianAge;

    public country(String name, int population, double landMassSize, double medianAge) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMassSize = landMassSize;
        this.medianAge = medianAge;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getLandMassSize() {
        return landMassSize;
    }

    public void setLandMassSize(double landMassSize) {
        this.landMassSize = landMassSize;
    }

    public double getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(double medianAge) {
        this.medianAge = medianAge;
    }
}
