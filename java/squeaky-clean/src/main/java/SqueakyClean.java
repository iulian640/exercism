class SqueakyClean {
    static String clean(String identifier) {

        StringBuilder sb = new StringBuilder();

        char[] Array = identifier
                .replace(" ", "_")
                .replace("3", "e")
                .replace("0", "o")
                .replace("1", "l")
                .replace("4", "a")
                .replace("7", "t")
                .toCharArray();

        boolean nextUpper = false;

        for (int i = 0; i < Array.length; i++) {

            if (Array[i] == '-') {
                nextUpper = true;
            } else {
                if (nextUpper) {
                    sb.append(Character.toUpperCase(Array[i]));
                    nextUpper = false;
                } else if (!Character.isAlphabetic(Array[i]) && Array[i] != '_') {

                } else {
                    sb.append(Array[i]);
                }
            }

        }
        return sb.toString();

    }
}
