package q4luyentap;

public class MyProcessor implements Processor {

    @Override
    public int countWords(String sentence) {
        if (sentence.isEmpty()) {
            return 0;
        } else {
            String[] arr = sentence.split("\\s+");
            int count = 0;
            for (String w : arr) {
                count++;
            }
            return count++;
        }
    }

    @Override
    public int sumOfEvenNumberInString(String input) {
        int sum = 0;
        if (input.isEmpty()) {
            return 0;
        }
        String[] arr = input.split("\\s+");
        for (String num : arr) {
            int n = Integer.parseInt(num);
            if (n % 2 == 0) {
                sum += n;
            }
        }
        return sum;
    }

    @Override
    public boolean isPerfect(int number) {
        int result = (int) Math.sqrt(number);
        if (Math.pow(result, 2) == number) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int countPalindromeWords(String sentence) {
        int count = 0;
        String[] arr = sentence.split("\\s+");

        for (String word : arr) {
            int i = 0;
            int j = word.length() - 1;
            while (i < j) {
                if (word.charAt(i) == word.charAt(j)) {
                    count++;
                }
                i++;
                j--;
            }
        }
        return count;
    }

    @Override
    public String convertToTitleCase(String input) {
        String[] arr =input.split("\\s+");
         int i = 0;
        for(String word:arr){
            String t = arr[i];
            arr[i] = t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase();
            i++;
        }
          return String.join(" ", arr);
        
    }

}
