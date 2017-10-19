
/**
 * Calculates the Salary and simulates a budget system.
 * 
 * @author Andrew Olesak 
 * @version November 10, 2015
 */
public class SalaryCalculator
{
    private double hourlyWage;
    private int hoursWeek;
    private final int MONTH_LENGTH = 4;
    private final int YEAR_LENGTH = 52;
    private final double TAXES_PERCENT = .80;
    private final int HOURS_IN_WEEK = 40;
    
    /**
     * Constructor sets the instance variables.
     */
    public SalaryCalculator(){
        this.hourlyWage = 0.0;
        this.hoursWeek = 0;
    }
    
    /**
     * @return the current wage per hour
     */
    public double getHourlyWage(){
        return this.hourlyWage;
    }
    
    /**
     * @return the current hours per week worked
     */
    public int getHoursWeek(){
        return this.hoursWeek;
    }
    
    /**
     * Calculates the salary in a week.
     * 
     * @param hourlyWage the amount made in an hour of work
     * @param hoursWeek the number of hours worked in a particular week
     * @return the salary for that particualar week
     */
    public double calcWeeklySalary(double hourlyWage, int hoursWeek){
        this.hourlyWage = hourlyWage;
        this.hoursWeek = hoursWeek;
        double weeklySalary = this.hourlyWage * this.hoursWeek * TAXES_PERCENT;
        return weeklySalary;
    }
    
    /**
     * Calculates the salary for a month(four weeks).
     * 
     * @param hourlyWage the amount made in an hour of work
     * @param hoursWeek the number of hours worked in a particular week
     * @return the salary for four weeks
     */
    public double calcMonthlySalary(double hourlyWage, int hoursWeek){
        double monthlySalary = this.calcWeeklySalary(hourlyWage, hoursWeek) * MONTH_LENGTH;
        return monthlySalary;
    }
    
    /**
     * Calculates the salary for a year(12 months).
     * 
     * @param hourlyWage the amount made in an hour of work
     * @param hoursWeek the number of hours worked in a particular week
     * @return the yearly salary
     */
    public double calcYearlySalary(double hourlyWage, int hoursWeek){
        double yearlySalary = this.calcWeeklySalary(hourlyWage, hoursWeek) * YEAR_LENGTH;
        return yearlySalary;
    }
    
    /**
     * @param moneyValue an amount of money
     * @return the amount of time it will take to return a given amount of money.
     */
    public double timeToMakeMoney(int moneyValue, int hours, double wage){
        double weeklySal = this.calcWeeklySalary(wage, hours);
        double weeksNeeded = moneyValue / weeklySal;
        return weeksNeeded;
    }
    
    /**
     * Computes the hourly wage for a given salary
     * 
     * @param yearlySalary the yearly salary
     * @return an hourly wage
     */
    public double convertToHourlyWage(double yearlySalary){
        double hourlyMoney = yearlySalary / YEAR_LENGTH / HOURS_IN_WEEK;
        return hourlyMoney;
    }
}
