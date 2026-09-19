public class SalaryCalculator {
    public double salaryMultiplier(int daysSkipped) {

        int MAXDAYS = 5;

        boolean APPLIESPENALTY = daysSkipped >= MAXDAYS;

        return APPLIESPENALTY ? 0.85 : 1;

    }

    public int bonusMultiplier(int productsSold) {

        int SMALLBONUS = 10;
        int SPECIALBONUS = 13;

        boolean TYPEOFBONUS = productsSold >= 20;

        return TYPEOFBONUS ? SPECIALBONUS : SMALLBONUS;
    }

    public double bonusForProductsSold(int productsSold) {

        return bonusMultiplier(productsSold) * productsSold;
    }

    public double finalSalary(int daysSkipped, int productsSold) {

        int BASESALARY = 1000;
        int MAXSALARY = 2000;
        double calculatedSalary = BASESALARY * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);
        boolean REACHESMAXSALARY = calculatedSalary <= MAXSALARY;

        return REACHESMAXSALARY ? calculatedSalary : MAXSALARY;
    }
}
