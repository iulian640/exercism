class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {

        int numDigits = String.valueOf(numberToCheck).length();

        int originalNumber = numberToCheck;
        double sum = 0;
        while (numberToCheck != 0) {
            int digit = numberToCheck % 10;
            numberToCheck = numberToCheck / 10;
            sum = sum + Math.pow(digit, numDigits);
        }

        return sum == originalNumber ? true : false;
    }

}
