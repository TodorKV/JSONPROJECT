package writer;

import userandreport.Report;
import userandreport.User;

import java.io.PrintWriter;

public class WriteToFileIMPL implements WriteToFile{
    private static final String firstLine = "Name   ,Score";
    private User[] users;
    private Report report;

    public WriteToFileIMPL(Report report, User[] users) {
        setReport(report);
        setUsers(users);
    }



    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }


    @Override
    public void WriteValidUsersToFile(PrintWriter printWriter) {
        printWriter.println(firstLine);
        for (User user: this.users) {
            if(user.getSalesPeriod() <= this.report.getPeriodLimit()){
                double score;
                if(this.report.isUseExperienceMultiplier())
                    score = user.getTotalSales() / user.getSalesPeriod() * user.getExperienceMultiplier();
                else
                    score = user.getTotalSales() / user.getSalesPeriod();
                if(score >= report.getTopPerformersThreshold()){
                    printWriter.println(String.format("%s, %.2f", user.getName(), score));
                }
            }
        }
        printWriter.close();
    }
}
