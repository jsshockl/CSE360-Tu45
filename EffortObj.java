package application;

public class EffortObj extends EffortLog{
	private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String project;
    
    private String lifeCycle;
    private String category1;
    private String category2;
    
    // Getter and Setter for project
    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }
    
 // Getter for lifeCycle
    public String getLifeCycle() {
        return lifeCycle;
    }

    // Setter for lifeCycle
    public void setLifeCycle(String lifeCycle) {
        this.lifeCycle = lifeCycle;
    }

    // Getter for category1
    public String getCategory1() {
        return category1;
    }

    // Setter for category1
    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    // Getter for category2
    public String getCategory2() {
        return category2;
    }

    // Setter for category2
    public void setCategory2(String category2) {
        this.category2 = category2;
    }
    
    // Getter and Setter for startDate
    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    // Getter and Setter for startTime
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    // Getter and Setter for endDate
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    // Getter and Setter for endTime
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public String toString() {
    	return "Effort Object\n" + "Start Time: " + startTime + "\nEnd Time: " + endTime + "\nProject Name: " + project + 
    			"\nLife Cycle Step: " + lifeCycle + "\nEffort Catgegory: " + category1 + " " + category2;
    }
}
