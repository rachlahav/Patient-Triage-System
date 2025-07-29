// src/pega/PegaWorkflowSimulator.java

package pega;

import java.util.List;
import model.Patient;

/**
 * Simulates interaction with Pega Platform rules engine for triage workflow.
 */
public class PegaWorkflowSimulator {

    /**
     * Simulate calling PegaRULES engine to rank patients dynamically
     */
    public List<Patient> prioritizePatients(List<Patient> patients) {
        // For demo, just sort by severity, age, resource availability logic
        patients.sort((p1, p2) -> {
            // Replace this with call to Pega rule engine in real app
            int severityCompare = Integer.compare(p2.getConditionSeverity(), p1.getConditionSeverity());
            if (severityCompare != 0) return severityCompare;
            int ageCompare = Integer.compare(p2.getAge(), p1.getAge());
            if (ageCompare != 0) return ageCompare;
            // Add resource ava
