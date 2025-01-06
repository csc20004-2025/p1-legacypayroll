/* **********************
 * CSC-20004 2023/24     
 * Working with legacy code
 * Source code adapted from: 
 * Deitel, Deitel. Java How to Program, 11/e, Early Objects Version
 * https://github.com/pdeitel/JavaHowToProgram11e_EarlyObjects
 * **********************/

// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee.

package uk.ac.keele.csc20004.legacy;

/**
 * A concrete implementation of the Employee class, for an
 * employee who's paid by the hour. It will account for overtime,
 * considering 40 hours per standard week.
 */
public class HourlyEmployee extends Employee {
   private double wage; // wage per hour
   private double hours; // hours worked for week

   /**
    * Standard constructor; just sets the required attributes for the
    * concrete class.
    * 
    * @param firstName            first name of the employee
    * @param lastName             last name of the employee
    * @param socialSecurityNumber the SSN (a sequence of digits in the form
    *                             ddd-dddd-ddd)
    * @param wage                 the hourly wage (must be equal to/greater than
    *                             0.0)
    * @param hours                the worked hours per week
    */
   public HourlyEmployee(String firstName, String lastName,
         String socialSecurityNumber, double wage, double hours) {
      super(firstName, lastName, socialSecurityNumber);

      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
               "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.wage = wage;
      this.hours = hours;
   }

   /**
    * There is usually no need for documenting obvious getters and setters.
    * For completeness, we document them here.
    * This sets the wage for the HourlyEmployee.
    * 
    * @param wage the hourly wage (must be equal or greater than 0.0)
    */
   public void setWage(double wage) {
      if (wage < 0.0) { // validate wage
         throw new IllegalArgumentException("Hourly wage must be >= 0.0");
      }

      this.wage = wage;
   }

   /**
    * There is usually no need for documenting obvious getters and setters.
    * For completeness, we document them here.
    * This returns the wage.
    * 
    * @return the hourly wage (a positive number)
    */
   public double getWage() {
      return wage;
   }

   /**
    * There is usually no need for documenting obvious getters and setters.
    * For completeness, we document them here.
    * This sets the hours worked.
    * 
    * @param hours the worked hours per week (must be between 0.0 and 168.0)
    */
   public void setHours(double hours) {
      if ((hours < 0.0) || (hours > 168.0)) { // validate hours
         throw new IllegalArgumentException(
               "Hours worked must be >= 0.0 and <= 168.0");
      }

      this.hours = hours;
   }

   /**
    * There is usually no need for documenting obvious getters and setters.
    * For completeness, we document them here.
    * This returns the hours worked.
    * 
    * @return the worked hours per week (a number between 0.0 and 168.0)
    */
   public double getHours() {
      return hours;
   }

   /**
    * Calculate earnings for this type of Employee.
    * This method overrides the abstract method earnings() in Employee,
    * so it must provide an implementation (which is specific for the derived
    * class).
    * Note the use of the @Override annotation, which is optional but
    * recommended. It tells the compiler that the method is supposed to
    * override a method in the superclass (in this case, Employee).
    * 
    * @return the earnings of the employee
    */
    @Override
   public double earnings() {
      if (getHours() <= 40) { // no overtime
         return getWage() * getHours();
      } else {
         return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
      }
   }

   /**
    * It's usually a good idea to override the toString() method
    * to provide a more meaningful representation of the object when
    * it is printed.
    * 
    * @return a String representation of the CommissionEmployee object (printout of
    *         the main attributes)
    */
   @Override
   public String toString() {
      return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
            super.toString(), "hourly wage", getWage(),
            "hours worked", getHours());
   }
}

/**************************************************************************
 * (C) Copyright 1992-2018 by Deitel & Associates, Inc. and *
 * Pearson Education, Inc. All Rights Reserved. *
 * *
 * DISCLAIMER: The authors and publisher of this book have used their *
 * best efforts in preparing the book. These efforts include the *
 * development, research, and testing of the theories and programs *
 * to determine their effectiveness. The authors and publisher make *
 * no warranty of any kind, expressed or implied, with regard to these *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or *
 * consequential damages in connection with, or arising out of, the *
 * furnishing, performance, or use of these programs. *
 *************************************************************************/
