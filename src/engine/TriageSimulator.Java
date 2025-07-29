package engine;

import java.util.*;
import model.Patient;
import data.TriageSystemParser;
import rules.TriageRule;
import core.Heap;  // Assuming you have a Heap implementation here

public class TriageSimulator {

    private List<Patient> patients;
    private PriorityQueue<Patient> triageQueue;
    private TriageRule triageRule;

    // Tracking metrics
    private Map<String, Double> metrics;
    public void runSimulation(List<Patient> patients) {
        // Use PegaWorkflowSimulator to prioritize patients
        List<Patient> prioritizedPatients = pegaSimulator.prioritizePatients(patients);

        // Use prioritizedPatients for further triage processing
        // ...

        pegaSimulator.generateDashboardMetrics();
    }

    public TriageSimulator(String inputFile, TriageRule rule) throws Exception {
        // Load patients from file
        TriageSystemParser parser = new TriageSystemParser();
        parser.readPatientFile(inputFile);
        this.patients = parser.getPatients();

        // Store rule and initialize priority queue with it
        this.triageRule = rule;
        this.triageQueue = new PriorityQueue<>(rule);

        // Initialize metrics
        this.metrics = new HashMap<>();
    }

    public void runSimulation() {
        // Add all patients to priority queue
        triageQueue.addAll(patients);

        // Simple simulation loop: process patients in priority order
        while (!triageQueue.isEmpty()) {
            Patient current = triageQueue.poll();
            // Simulate treatment (add timing, state changes etc. here)
            System.out.println("Treating patient: " + current);
            // Update metrics if needed
        }

        // Calculate & print final metrics (dummy example)
        System.out.println("Simulation complete. Metrics: " + metrics);
    }

    // Additional methods for metrics, patient states, etc. can be added here
}

