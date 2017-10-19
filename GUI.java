import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
/**
 * Creates a GUI to display the SalaryCalculator class.
 * 
 * @author Andrew Olesak
 * @version November 10, 2015
 */
public class GUI extends JFrame implements ActionListener
{
    SalaryCalculator calculator;

    // defines buttons
    private JButton weeklySalaryButton;
    private JButton monthlySalaryButton;
    private JButton yearlySalaryButton;
    private JButton moneyAmountButton;
    private JButton convertToHourlyWageButton;

    // results area
    JTextArea results;

    // defines text fields
    private JTextField hourlyWage;
    private JTextField hoursWeek;
    private JTextField moneyAmount;
    private JTextField yearlySalary;

    // defines labels
    private JLabel hoursWeekLabel;
    private JLabel hourlyWageLabel;
    private JLabel moneyAmountLabel;
    private JLabel yearlySalaryLabel;

    // create a salary object
    SalaryCalculator calc = new SalaryCalculator();

    // create rounders
    NumberFormat round = NumberFormat.getCurrencyInstance();
    DecimalFormat df = new DecimalFormat("#.#");

    public static void main(String args[]){
        GUI gui = new GUI();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("Salary Calculator");
        gui.pack();
        gui.setVisible(true);
    }

    /**
     * Constructor sets values and places them on the GUI.
     */
    public GUI(){

        // instantiate the object
        calculator = new SalaryCalculator();

        setLayout(new GridBagLayout());
        GridBagConstraints spot = new GridBagConstraints();

        // create the results area
        results = new JTextArea(20,20);
        JScrollPane scrollPane = new JScrollPane(results);
        spot.gridx = 0;
        spot.gridy = 1;
        spot.gridheight = 10;
        spot.insets.left = 20;
        spot.insets.right = 20;
        spot.insets.bottom = 20;
        add(scrollPane, spot);
        spot = new GridBagConstraints();

        // create and place the results label
        spot.gridx = 0;
        spot.gridy = 0;
        spot.insets.bottom = 20;
        add(new JLabel("Results"), spot);

        // create and place the hourlyWage label
        this.hourlyWageLabel = new JLabel();
        this.hourlyWageLabel.setText("Hourly Wage");
        spot.gridx = 1;
        spot.gridy = 1;
        spot.anchor = GridBagConstraints.WEST;
        spot.insets.bottom = 5;
        add(this.hourlyWageLabel, spot);

        // create and place the hoursWeek label
        this.hoursWeekLabel = new JLabel();
        this.hoursWeekLabel.setText("Hours per Week");
        spot.gridx = 1;
        spot.gridy = 2;
        add(this.hoursWeekLabel, spot);

        // create and place the money amount label
        this.moneyAmountLabel = new JLabel();
        this.moneyAmountLabel.setText("Amount");
        spot.gridx = 1;
        spot.gridy = 3;
        add(this.moneyAmountLabel, spot);

        // create and place the yearly salary label
        this.yearlySalaryLabel = new JLabel();
        this.yearlySalaryLabel.setText("Yearly Salary");
        spot.gridx = 1;
        spot.gridy = 4;
        add(this.yearlySalaryLabel, spot);

        // create and place the hourly wage text field
        this.hourlyWage = new JTextField(8);
        spot.gridx = 1;
        spot.gridy = 1;
        spot.insets.left = 100;
        spot.insets.bottom = 5;
        add(this.hourlyWage, spot);

        // create and place the hoursWeek text field
        this.hoursWeek = new JTextField(8);
        spot.gridx = 1;
        spot.gridy = 2;
        add(this.hoursWeek, spot);

        // create and place the money amount text field
        this.moneyAmount = new JTextField(8);
        spot.gridx = 1;
        spot.gridy = 3;
        add(this.moneyAmount, spot);

        // create and place the yearly salary text field
        this.yearlySalary = new JTextField(8);
        spot.gridx = 1;
        spot.gridy = 4;
        add(this.yearlySalary, spot);

        // create and display the weekly salary button
        this.weeklySalaryButton = new JButton("Find the Weekly Salary");
        spot.gridx = 1;
        spot.gridy = 5;
        spot.anchor = GridBagConstraints.CENTER;
        spot.insets = new Insets(20, 0, 0, 80);
        add(this.weeklySalaryButton, spot);

        // create and display the monthly salary button
        this.monthlySalaryButton = new JButton("Find the Monthly Salary");
        spot.gridx = 1;
        spot.gridy = 6;
        spot.insets.top = 10;
        add(this.monthlySalaryButton, spot);

        // create and display the yearly salary button
        this.yearlySalaryButton = new JButton("Find the Yearly Salary");
        spot.gridx = 1;
        spot.gridy = 7;
        add(this.yearlySalaryButton, spot);

        // create and display the money amount button
        this.moneyAmountButton = new JButton("Amount of time needed to make given amount");
        spot.gridx = 1;
        spot.gridy = 8;
        add(this.moneyAmountButton, spot);

        // create and display the convert to hourly wage button
        this.convertToHourlyWageButton = new JButton("Convert Yearly Salary to Hourly Wage");
        spot.gridx = 1;
        spot.gridy = 9;
        add(this.convertToHourlyWageButton, spot);

        // register the listeners for the buttons
        this.weeklySalaryButton.addActionListener(this);
        this.monthlySalaryButton.addActionListener(this);
        this.yearlySalaryButton.addActionListener(this);
        this.moneyAmountButton.addActionListener(this);
        this.convertToHourlyWageButton.addActionListener(this);
    }

    /**
     * Display the results for weekly salary
     */
    public void calculateWeeklySalary(){
        
        // test that the text fields aren't blank
        String hW = hourlyWage.getText();
        String hPW = hoursWeek.getText();
        if(hW.length() == 0 || hPW.length() == 0){
            results.setText("Make sure the hourlyWage and hoursWeek fields aren't blank");
            return;
        }
        
        // test that the textfields are valid integers and doubles
        if(!checkValidDouble(hW, "hourlyWage")){
            return;
        }if(!checkValidInteger(hPW, "hoursPerWeek")){
            return;
        }
        
        double hoursWorked = Double.parseDouble(hourlyWage.getText());
        int hoursPerWeek = Integer.parseInt(hoursWeek.getText());
        double weeklySalary = calc.calcWeeklySalary(hoursWorked, hoursPerWeek);
        String weeklySal = round.format(weeklySalary);
        results.setText(weeklySal + " per Week");
    }

    /**
     * Display the results for monthly salary
     */
    public void calculateMonthlySalary(){
        
        // test that the text fields aren't blank
        String hW = hourlyWage.getText();
        String hPW = hoursWeek.getText();
        if(hW.length() == 0 || hPW.length() == 0){
            results.setText("Make sure the hourlyWage and hoursWeek fields aren't blank");
            return;
        }
        
        // test that the textfields are valid integers and doubles
        if(!checkValidDouble(hW, "hourlyWage")){
            return;
        }if(!checkValidInteger(hPW, "hoursPerWeek")){
            return;
        }
        
        double hoursWorked = Double.parseDouble(hourlyWage.getText());
        int hoursPerWeek = Integer.parseInt(hoursWeek.getText());
        double monthlySalary = calc.calcMonthlySalary(hoursWorked, hoursPerWeek);
        String monthlySal = round.format(monthlySalary);
        results.setText(monthlySal + " per Month");
    }

    /**
     * Display the results for a yearly salary
     */
    public void calculateYearlySalary(){
        
        // test that the text fields aren't blank
        String hW = hourlyWage.getText();
        String hPW = hoursWeek.getText();
        if(hW.length() == 0 || hPW.length() == 0){
            results.setText("Make sure the hourlyWage and hoursWeek fields aren't blank");
            return;
        }
        
        // test that the textfields are valid integers and doubles
        if(!checkValidDouble(hW, "hourlyWage")){
            return;
        }if(!checkValidInteger(hPW, "hoursPerWeek")){
            return;
        }
        
        double hoursWorked = Double.parseDouble(hourlyWage.getText());
        int hoursPerWeek = Integer.parseInt(hoursWeek.getText());
        double yearlySalary = calc.calcYearlySalary(hoursWorked, hoursPerWeek);
        String yearlySal = round.format(yearlySalary);
        results.setText(yearlySal + " per Year");
    }

    /**
     * Displays the amount of time needed to make a certain amount of money
     */
    public void calcAmountOfTime(){
        
        // test that the text fields aren't blank
        String hW = hourlyWage.getText();
        String hPW = hoursWeek.getText();
        String m = moneyAmount.getText();
        if(hW.length() == 0 || hPW.length() == 0 || m.length() == 0){
            results.setText("Make sure the hourlyWage and hoursWeek fields aren't blank");
            return;
        }
        
        // test that the textfields are valid integers and doubles
        if(!checkValidDouble(hW, "hourlyWage")){
            return;
        }if(!checkValidInteger(hPW, "hoursPerWeek")){
            return;
        }if(!checkValidInteger(m, "Amount")){
            return;
        }
        
        double wage = Double.parseDouble(hourlyWage.getText());
        int hours = Integer.parseInt(hoursWeek.getText());
        int money = Integer.parseInt(moneyAmount.getText());
        double weeks = calc.timeToMakeMoney(money, hours, wage);
        String weeksStr = df.format(weeks);
        results.setText(weeksStr + " weeks");
    }

    /**
     * Displays the hourly wage converted from a given salary
     */
    public void calcHourlyWage(){
        
        // test that the text fields aren't blank
        String s = yearlySalary.getText();
        if(s.length() == 0){
            results.setText("Make sure the yearlySalary field isn't blank");
            return;
        }
        
        // test that the textfields are valid integers and doubles
        if(!checkValidDouble(s, "yearlySalary")){
            return;
        }
        
        double yearSalary = Double.parseDouble(yearlySalary.getText());
        double hourlyWage = calc.convertToHourlyWage(yearSalary);
        String hourlyMoney = round.format(hourlyWage);
        results.setText(hourlyMoney + " per hour");
    }

    /**
     * Called when a button is pressed.
     * 
     * @param e the event that was fired
     */
    public void actionPerformed(ActionEvent e){
        JComponent buttonPressed = (JComponent) e.getSource();

        // react to weekly salary button pressed
        if(e.getSource() == this.weeklySalaryButton){
            this.calculateWeeklySalary();
        }

        // react to monthly salary button pressed
        if(e.getSource() == this.monthlySalaryButton){
            this.calculateMonthlySalary();
        }

        // react to yearly salary button pressed
        if(e.getSource() == this.yearlySalaryButton){
            this.calculateYearlySalary();
        }

        // react to money amount button pressed
        if(e.getSource() == this.moneyAmountButton){
            this.calcAmountOfTime();
        }

        // react to convert to hourly wage button pressed
        if(e.getSource() == this.convertToHourlyWageButton){
            this.calcHourlyWage();   
        }
    }
    
    /**
     * Check to see if a valid integer is entered into a text field
     * 
     * @param numstr the string to be checked
     * @param label the textfield name
     * @return true if valid integer
     */
    private boolean checkValidInteger(String numstr, String label){
        boolean valid = true;
        try{
            int value = Integer.parseInt(numstr);
            
        }catch(NumberFormatException e){
            valid = false;
            JOptionPane.showMessageDialog(this, "Enter an integer in " + label);
        }
        return valid;
    }
    
    /**
     * checkto see if a valid double is entered into a text field
     * 
     * @param numstr the string to be checked
     * @param label the textfield name
     * @return true if valid double
     */
    private boolean checkValidDouble(String numstr, String label){
        boolean valid = true;
        try{
            double value = Double.parseDouble(numstr);
            
        }catch(NumberFormatException e){
            valid = false;
            JOptionPane.showMessageDialog(this, "Enter a double in " + label);
        }
        return valid;
    }
}
