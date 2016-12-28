import java.util.Arrays;
public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        String result = "";
        if (s.length() == 0)
            return "";
        int[] count = new int[128];
        Arrays.fill(count, 0);
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        int max = 0, printchar = 0, flag = 0;
        for (int j = 0; j < 128; j++) {
            for (int i = 0; i < 128; i++) {
                if (count[i] > max) {
                    max = count[i];
                    printchar = i;
                    flag = 1;
                }
            }
            if (flag == 1) {
                for (int i = 0; i < count[printchar]; i++)
                    result += (char) (printchar);
                count[printchar] = 0;
            } else
                return result;
            flag = 0;
            max = 0;
        }
        return result;
    }
}