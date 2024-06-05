import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String s = scanner.nextLine();

        String[] words = s.split(" ");
        List<String> arr = new ArrayList<>();

        for (String string : words) {
            List<Character> ch = new ArrayList<>();
            for (Character c : string.toCharArray()) {
                ch.add(c);
            }
            ch.sort(null);
            String st = "";
            for (Character c : ch) {
                st += c;
            }
            arr.add(st);
        }

        Set<String> set = new LinkedHashSet<String>(arr);
        System.out.println(set.size());   
    }
}
