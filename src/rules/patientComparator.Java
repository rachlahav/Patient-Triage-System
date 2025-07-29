package rules;

import model.Patient;

public class PatientConditionComparator implements TriageRule {

    /**
     * Compares patients by condition severity first, then by age if conditions are equal.
     * The Condition enum defines severity levels: LIGHT < MILD < SEVERE < CRITICAL.
     * 
     * @param pt1 First patient to compare
     * @param pt2 Second patient to compare
     * @return Positive int if pt1 > pt2, 0 if equal, negative otherwise
     */
    @Override
    public int compare(Patient pt1, Patient pt2) {
        int conditionComparison = pt1.getCondition().ordinal() - pt2.getCondition().ordinal();
        if (conditionComparison == 0) {
            return pt1.getAge() - pt2.getAge();
        }
        return conditionComparison;
    }
}
