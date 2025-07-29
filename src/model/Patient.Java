// src/model/Patient.java
package model;

public class Patient {
    private String name;
    private int age;
    private int severity;
    private long arrivalTime;

    public Patient(String name, int age, int severity, long arrivalTime) {
        this.name = name;
        this.age = age;
        this.severity = severity;
        this.arrivalTime = arrivalTime;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getSeverity() { return severity; }
    public long getArrivalTime() { return arrivalTime; }

    @Override
    public String toString() {
        return String.format("%s (Age: %d, Severity: %d)", name, age, severity);
    }
}
