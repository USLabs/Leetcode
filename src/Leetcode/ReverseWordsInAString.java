package Leetcode;

/**
 * Created by uslabs on 6/20/17.
 */
public class ReverseWordsInAString {
    public static void Solution() {
        String input = " 1";


        if (input == null || input.length() == 0)
            System.out.println(input);

        String[] words = input.split(" ");
        if (words.length == 0)
            System.out.println(input);

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (word.length() == 0)
                continue;
            sb.insert(0, " " + word);
        }

        String output = (sb.substring(1).toString());
        System.out.println(output);


    }
}
