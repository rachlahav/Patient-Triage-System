import engine.TriageSimulator;
import rules.PatientConditionComparator;

public class AppMain {

    public static void main(String[] args) {
        try {
            // Path to your input data file
            String inputFile = "data/small_input.txt";

            // Initialize triage rule (condition-based)
            PatientConditionComparator triageRule = new PatientConditionComparator();

            // Initialize and run simulator
            TriageSimulator simulator = new TriageSimulator(inputFile, triageRule);
            simulator.runSimulation();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
