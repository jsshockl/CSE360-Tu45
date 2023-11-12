package application;

public class EffortLog {
    private static int numEffort;
    private String project;
    private String defectName;
    private String defectSymptoms;
    private String injected;
    private String removed;
    private String defectCategory;

    // Getter and Setter for numEffort
    public static int getNumEffort() {
        return numEffort;
    }

    public static void setNumEffort(int numEffort) {
        EffortLog.numEffort = numEffort;
    }

    // Getter and Setter for project
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    // Getter and Setter for defectName
    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
    }

    // Getter and Setter for defectSymptoms
    public String getDefectSymptoms() {
        return defectSymptoms;
    }

    public void setDefectSymptoms(String defectSymptoms) {
        this.defectSymptoms = defectSymptoms;
    }

    // Getter and Setter for injected
    public String getInjected() {
        return injected;
    }

    public void setInjected(String injected) {
        this.injected = injected;
    }

    // Getter and Setter for removed
    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed;
    }

    // Getter and Setter for defectCategory
    public String getDefectCategory() {
        return defectCategory;
    }

    public void setDefectCategory(String defectCategory) {
        this.defectCategory = defectCategory;
    }
    
    public String toString() {
    	return "Num Effort: " + numEffort + "\nProject: " + project + "\nDefect Name: " + defectName + 
    			"\nDefect Symptoms: " + defectSymptoms + "\nStep when Injected: " + injected + 
    			"\nStep when Removed: " + removed + "\nDefect Category: " + defectCategory + "\n\n";
    }
}
