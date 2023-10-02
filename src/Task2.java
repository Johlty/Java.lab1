
public class Task2 {
    public static void bubbleSortByCapitalLetters(String[] unsortedStrings) {
        if (unsortedStrings == null|| unsortedStrings.length<2)
            return ;
        for(int last = unsortedStrings.length -1 ; last > 0; last--)
        {
            for(int first = 0; first < last; first++){
                if(countOfUppercase(unsortedStrings[first])<countOfUppercase(unsortedStrings[first+1])){
                    String tmp = unsortedStrings[first];
                    unsortedStrings[first] = unsortedStrings[first+1];
                    unsortedStrings[first+1] = tmp;
                }
            }
        }
    }
    public static int countOfUppercase(String text) {
        int count = 0;
        if (text == null)
            return -1;
        for (int i = 0; i < text.length() - 1; i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                count++;
            }
        }
        return count;
    }
}