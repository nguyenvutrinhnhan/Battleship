class Util {
    public static String capitalize(String str) {
        String result = str;
        System.out.println("Before: " + result);
        if (str == null || str.isBlank()) {
            result = str;
        } else if (str.length() == 1) {
            result = str.toUpperCase();
        } else {
            result = Character.toUpperCase(str.charAt(0)) + str.substring(1);
        }
        System.out.println("After: " + result);
        return result;
    }
}