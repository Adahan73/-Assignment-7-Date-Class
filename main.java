import java.util.*;

class Date implements Comparable<Date> {
    private int day, month, year;
    
    // Days in each month (leap year considered separately)
    private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MONTH_NAMES = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private static final String[] WEEK_DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    
    // Constructor
    public Date(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date");
        }
    }
    
    // Leap year check
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    // Date validation
    public static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) return false;
        int maxDays = DAYS_IN_MONTH[month];
        if (month == 2 && isLeapYear(year)) maxDays = 29;
        return day <= maxDays;
    }
    
    // Update the date
    public void updateDate(int day, int month, int year) {
        if (isValidDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new IllegalArgumentException("Invalid date update");
        }
    }
    
    // Get the day of the week (Zeller's Congruence Algorithm)
    public String getDayOfWeek() {
        int m = month, y = year;
        if (m < 3) {
            m += 12;
            y -= 1;
        }
        int k = y % 100;
        int j = y / 100;
        int h = (day + (13 * (m + 1)) / 5 + k + (k / 4) + (j / 4) + (5 * j)) % 7;
        return WEEK_DAYS[(h + 5) % 7];
    }
    
    // Calculate the difference in days between two dates
    public int calculateDifference(Date other) {
        Calendar c1 = new GregorianCalendar(year, month - 1, day);
        Calendar c2 = new GregorianCalendar(other.year, other.month - 1, other.day);
        long diffMillis = Math.abs(c1.getTimeInMillis() - c2.getTimeInMillis());
        return (int) (diffMillis / (1000 * 60 * 60 * 24));
    }
    
    // Print the date in readable format
    public void printDate() {
        System.out.println(MONTH_NAMES[month] + " " + day + ", " + year);
    }
    
    // Compare two dates for sorting
    @Override
    public int compareTo(Date other) {
        if (this.year != other.year) return this.year - other.year;
        if (this.month != other.month) return this.month - other.month;
        return this.day - other.day;
    }
    
    // Override toString method
    @Override
    public String toString() {
        return MONTH_NAMES[month] + " " + day + ", " + year;
    }
}

// Main class to test the Date class
public class Main {
    public static void main(String[] args) {
        List<Date> dates = new ArrayList<>();
        
        try {
            Date date1 = new Date(1, 1, 2023);
            Date date2 = new Date(15, 5, 2020);
            Date date3 = new Date(29, 2, 2024); // Leap year test
            
            date1.printDate();
            date2.printDate();
            date3.printDate();
            
            System.out.println("Day of the week for " + date1 + ": " + date1.getDayOfWeek());
            System.out.println("Day of the week for " + date2 + ": " + date2.getDayOfWeek());
            
            System.out.println("Difference in days: " + date1.calculateDifference(date2));
            
            // Adding dates to list
            dates.add(date1);
            dates.add(date2);
            dates.add(date3);
            
            Collections.sort(dates);
            System.out.println("Sorted Dates:");
            for (Date d : dates) {
                System.out.println(d);
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

// README.md
/*
# Date Class in Java

## Project Overview
This project implements a Date class in Java with various operations, including date validation, comparison, and sorting.

## Compilation and Execution Instructions
1. Compile the program:
   ```
   javac Main.java
   ```
2. Run the program:
   ```
   java Main
   ```

## Additional Notes
- The program validates leap years.
- Uses Zeller’s Congruence to determine the day of the week.
- Supports sorting Date objects based on year, month, and day.
- Handles invalid date inputs gracefully.

## Challenges
- Implementing leap year rules correctly.
- Efficiently calculating date differences.
*/
