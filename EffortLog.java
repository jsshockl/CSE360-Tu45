package application;

//parent class for effort and defect logs
public class EffortLog {
   protected static int totalLogs = 0;
   public static EffortLog[] logs = new EffortLog[995];
   
   public static void setTotalLogs(int logs) {
	   totalLogs = logs;
   }
   
   public static int getTotalLogs() {
	   return totalLogs;
   }
   
}
