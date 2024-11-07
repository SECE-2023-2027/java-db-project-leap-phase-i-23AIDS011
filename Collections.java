import java.util.*;
public class Collections {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(10);
        numbers.add(40);
        numbers.add(20);
        numbers.add(50);
        numbers.add(100);
        numbers.add(2114);
        numbers.add(321);
        int min = numbers.get(0);
        int max = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < min) {
                min = numbers.get(i);
            }
            if (numbers.get(i) > max) {
                max = numbers.get(i);
            }
        }

        System.out.println("List of Numbers: " + numbers);
        System.out.println("Minimum Value: " + min);
        System.out.println("Maximum Value: " + max);

        System.out.print("Duplicate Values: ");
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (numbers.get(i) == numbers.get(j)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                boolean a = false;
                for (int k = 0; k < duplicates.size(); k++) {
                    if (duplicates.get(k) == numbers.get(i)) {
                        a = true;
                        break;
                    }
                }
                if (!a) {
                    duplicates.add(numbers.get(i));
                    System.out.print(numbers.get(i) + " ");
                }
            }
        }
    }
}
