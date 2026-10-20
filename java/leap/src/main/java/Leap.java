class Leap {

    boolean isLeapYear(int year) {

        boolean isDivisibleBy100 = year % 100 == 0;
        boolean isDivisibleBy400 = year % 400 == 0;
        boolean isDivisibleBy4 = year % 4 == 0;

        if (isDivisibleBy400) {
            return true;
        } else if (isDivisibleBy100) {
            return false;
        } else if (isDivisibleBy4) {
            return true;
        } else {
            return false;
        }
    }

}
