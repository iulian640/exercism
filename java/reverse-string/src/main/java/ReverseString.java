class ReverseString {

    String reverse(String inputString) {

        StringBuilder reverseBuilder = new StringBuilder(inputString);

        reverseBuilder.reverse();

        String result = reverseBuilder.toString();

        return result;
    }

}
