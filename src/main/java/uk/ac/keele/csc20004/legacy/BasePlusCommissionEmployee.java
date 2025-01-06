/* **********************
 * CSC-20004 2023/24     
 * Working with legacy code
 * Source code adapted from: 
 * Deitel, Deitel. Java How to Program, 11/e, Early Objects Version
 * https://github.com/pdeitel/JavaHowToProgram11e_EarlyObjects
 * **********************/

// Fig. 10.8: BasePlusCommissionEmployee.java
// BasePlusCommissionEmployee class extends CommissionEmployee.

package uk.ac.keele.csc20004.legacy;

/**
 * A variation on the CommissionEmployee, for an employee who
 * accrues commissions over a base salary.
 */
public class BasePlusCommissionEmployee extends CommissionEmployee {
   private double baseSalary; // base salary per week

   /**
    * The constructor for a BasePlusCommissionEmployee.
    * Sets the attributes inherited from CommissionEmployee, plus an
    * additional attribute for the base salary.
    * 
    * @param firstName            first name of the employee
    * @param lastName             last name of the employee
    * @param socialSecurityNumber the SSN (a sequence of digits in the form
    *                             ddd-dddd-ddd)
    * @param grossSales           the gross weekly sales
    * @param commissionRate       the commission percentage
    * @param baseSalary           the base salary to which commissions are added
    */
   public BasePlusCommissionEmployee(String firstName, String lastName,
         String socialSecurityNumber, double grossSales,
         double commissionRate, double baseSalary) {
      super(firstName, lastName, socialSecurityNumber,
            grossSales, commissionRate);

      if (baseSalary < 0.0) { // validate baseSalary
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }

      this.baseSalary = baseSalary;
   }

   /**
    * There is usually no need for documenting obvious getters and setters.
    * For completeness, we document them here.
    * This sets the base salary.
    * 
    * @param baseSalary the base salary to which commissions are added
    */
   public void setBaseSalary(double baseSalary) {
      if (baseSalary < 0.0) { // validate baseSalary
         throw new IllegalArgumentException("Base salary must be >= 0.0");
      }

      this.baseSalary = baseSalary;
   }

   /**
    * There is usually no need for documenting obvious getters and setters.
    * For completeness, we document them here.
    * This returns the base salary.
    * 
    * @return the base salary to which commissions are added
    */
   public double getBaseSalary() {
      return baseSalary;
   }

   /**
    * Calculate earnings for this type of Employee.
    * This method overrides the abstract method earnings() in Employee,
    * so it must provide an implementation (which is specific for the derived
    * class).
    * Note the use of the @Override annotation, which is optional but
    * recommended. It tells the compiler that the method is supposed to
    * override a method in the superclass (in this case, CommissionEmployee).
    * 
    * @return the earnings of the employee
    */
   @Override
   public double earnings() {
      // we can rely on the implementation from the superclass and
      // just add the base salary
      return getBaseSalary() + super.earnings();
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
      return String.format("%s %s; %s: $%,.2f",
            "base-salaried", super.toString(),
            "base salary", getBaseSalary());
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
