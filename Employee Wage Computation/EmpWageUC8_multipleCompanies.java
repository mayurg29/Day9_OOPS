// Computing Employee Wage for multiple companies

public class EmpWageUC8_multipleCompanies {
    public static final int IS_PART_TIME = 1;
    public static final int IS_FULL_TIME = 2;

    public static void calEmpWage(String company, int empRatePerHr, int numOfWorkingDays,
                                  int maxHrsPerMonth) {
        // Variables
        int empHrs = 0, totalEmpWage =0, totalEmpHrs = 0, totalWorkingDays = 0;
        // Computation
        while (totalEmpHrs <= maxHrsPerMonth && totalWorkingDays < numOfWorkingDays) {
            totalWorkingDays++;
            int empCheck = (int) Math.floor(Math.random() * 10) % 3;
            switch (empCheck) {
                case IS_FULL_TIME:
                    empHrs = 8;
                    break;
                case IS_PART_TIME:
                    empHrs = 4;
                    break;
                default:
                    empHrs = 0;
            }
            totalEmpHrs += empHrs;
            int empWage = empHrs * empRatePerHr;
            System.out.println("Day#: " + totalWorkingDays + " Emp Hr: " + empHrs);
            System.out.println("Emp Wage = " + empWage);
            System.out.println();
        }
        totalEmpWage = totalEmpHrs * empRatePerHr;
        System.out.println("totalEmpHrs = " + totalEmpHrs);
        System.out.println("Total Emp Wage for company " + company + " is: " + totalEmpWage);
    }

    public static void main(String[] args) {
        calEmpWage("DMart",20, 4, 10);
        System.out.println("----------------------------------------");
        calEmpWage("Reliance", 15, 3, 10);
    }
}
