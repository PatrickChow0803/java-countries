package local.patrickchow.webemployees;

import java.util.concurrent.atomic.AtomicLong;

// Classes with no annotation at the top are POJOs. Plain Old Java Object
public class Employee {
    // By using AtmoicLong, will never assign 2 employees the same ID.
    // Ex: Signing up 2 people at the same time will have 2 different ids
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String fname;
    private String lName;
    private double salary;
    private boolean has401k;
    private int companyId;
    private int healthPlanId;

    public Employee(String fname, String lName, double salary, boolean has401k, int companyId, int healthPlanId) {
        this.id = counter.incrementAndGet();
        this.fname = fname;
        this.lName = lName;
        this.salary = salary;
        this.has401k = has401k;
        this.companyId = companyId;
        this.healthPlanId = healthPlanId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname.toUpperCase();
    }

    public String getLName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName.toUpperCase();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isHas401k() {
        return has401k;
    }

    public void setHas401k(boolean has401k) {
        this.has401k = has401k;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getHealthPlanId() {
        return healthPlanId;
    }

    public void setHealthPlanId(int healthPlanId) {
        this.healthPlanId = healthPlanId;
    }
}
