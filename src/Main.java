import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do " +
            "eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
            "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute" +
            " irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit " +
            "anim id est laborum.";
    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        text.toLowerCase();
        char[] symbols =  text.toCharArray();

        for(int i = 0; i < symbols.length; i++) {
            if (Character.isLetter(symbols[i])) {
                Integer count = map.get(symbols[i]);
                if (count == null) {
                    map.put(symbols[i], 1);
                } else {
                    map.put(symbols[i], ++count);
                }
            }
        }

        Integer max = getMax(map);
        Integer min = getMin(map);
        for (Map.Entry<Character, Integer> symb : map.entrySet()) {
            if (symb.getValue().equals(max)){
                System.out.println("Максимальное число вхождений: " + "\n" + symb.getKey() + " - " + symb.getValue());
            }
        }
        System.out.println();
        for (Map.Entry<Character, Integer> symb : map.entrySet()) {
            if (symb.getValue().equals(min)){
                System.out.println("Минимальное число вхождений: " + "\n" + symb.getKey() + " - " + symb.getValue());
            }
        }

    }

    private static Integer getMax(Map<Character, Integer> map) {

        int countMax = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> symb : map.entrySet()){
            if (symb.getValue() > countMax) {
                countMax = symb.getValue();
            }
        }
        return countMax;
    }

    private static Integer getMin(Map<Character, Integer> map) {

        int countMin = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> symb : map.entrySet()){
            if (symb.getValue() < countMin) {
                countMin = symb.getValue();
            }
        }
        return countMin;
    }
}