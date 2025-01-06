/* **********************
 * CSC-20004 2023/24     
 * Working with legacy code
 * Source code adapted from: 
 * Deitel, Deitel. Java How to Program, 11/e, Early Objects Version
 * https://github.com/pdeitel/JavaHowToProgram11e_EarlyObjects
 * **********************/

// Fig. 10.5: SalariedEmployee.java
// SalariedEmployee concrete class extends abstract class Employee.

package uk.ac.keele.csc20004.legacy;

/**
 * A concrete implementation of the Employee class, for an
 * employee who is on a fixed weekly salary.
 */
public class SalariedEmployee extends Employee {
   private double weeklySalary;

   /**
    * Standard constructor; just sets the required attributes for the
    * concrete class.
    * 
    * @param firstName            first name of the employee
    * @param lastName             last name of the employee
    * @param socialSecurityNumber the SSN (a sequence of digits in the form
    *                             ddd-dddd-ddd)
    * @param weeklySalary         the fixed weekly salary (must be greater than 0)
    */
   public SalariedEmployee(String firstName, String lastName,
         String socialSecurityNumber, double weeklySalary) {
      super(firstName, lastName, socialSecurityNumber);

      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
               "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   }

   /**
    * There is usually no need for documenting obvious getters and setters.
    * For completeness, we document them here.
    * This sets the weekly salary for the SalariedEmployee.
    * 
    * @param weeklySalary the fixed weekly salary (must be greater than 0)
    */
   public void setWeeklySalary(double weeklySalary) {
      if (weeklySalary < 0.0) {
         throw new IllegalArgumentException(
               "Weekly salary must be >= 0.0");
      }

      this.weeklySalary = weeklySalary;
   }

   /**
    * There is usually no need for documenting obvious getters and setters.
    * For completeness, we document them here.
    * This gets the weekly salary for the SalariedEmployee.
    * 
    * @return the fixed weekly salary
    */
   public double getWeeklySalary() {
      return weeklySalary;
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
      return getWeeklySalary();
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
      return String.format("salaried employee: %s%n%s: $%,.2f",
            super.toString(), "weekly salary", getWeeklySalary());
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
