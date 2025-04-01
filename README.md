# -Assignment-7-Date-Class

## Overview
The Date class represents a calendar date with day, month, and year attributes. It provides various methods for validation, manipulation, and comparison of dates. The program also includes a Main class to demonstrate its functionality.

Features
Date Validation: Ensures the date is within valid ranges, considering leap years.

Leap Year Handling: Determines if a given year is a leap year.

Date Update: Allows modification of the date while ensuring its validity.

Day of the Week Calculation: Uses Zeller’s Congruence to determine the day of the week.

Date Difference Calculation: Computes the number of days between two dates.

Sorting: Implements Comparable<Date> to sort dates in ascending order (year → month → day).

Readable Date Format: Displays the date in "Month Day, Year" format.

## Usage Example

```
Date date1 = new Date(1, 1, 2023);
Date date2 = new Date(15, 5, 2020);
```

```
date1.printDate(); // Output: January 1, 2023
System.out.println("Day of the week: " + date1.getDayOfWeek());
System.out.println("Days between dates: " + date1.calculateDifference(date2));
```
## Compilation & Execution

1.Compile the program:
```
javac Main.java
```

2.Run the program:
```
java Main
```

## Challenges & Improvements
Leap Year Calculation: Ensuring correct leap year logic.

Date Difference Calculation: Handling time zone variations and different calendar systems.

Extending Functionality: Could add methods for adding/subtracting days or formatting dates in multiple styles.
