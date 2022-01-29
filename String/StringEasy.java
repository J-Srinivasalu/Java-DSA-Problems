package CompletedPhase1;

import java.util.Arrays;
import java.util.List;

public class StringEasy {

    //    Defanging an Ip address
    public String defangIPaddr(String address) {
        StringBuilder str = new StringBuilder();
        char[] s = "string".toCharArray();
        return address.replace(".", "[.]");
    }

    //    Shuffle String
    public String restoreString(String s, int[] indices) {
        char[] ans = new char[s.length()];
        int j = 0;
        for (int i : indices) {
            ans[i] = s.charAt(j++);
        }
        return new String(ans);
    }

    //    Goal Parser Interpretation
    public String interpret(String command) {
//        return interpretUsingReplaceFunction(command);
        return interpretUsingStringBuilder(command);
    }

    public String interpretUsingReplaceFunction(String command) {
        command = command.replace("()", "o");
        command = command.replace("(al)", "al");
        return command;
    }

    public String interpretUsingStringBuilder(String command) {
        StringBuilder S = new StringBuilder(command.length());
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') S.append('G');
            if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    S.append('o');
                    i++;
                } else {
                    S.append("al");
                    i = i + 3;
                }
            }
        }
        return S.toString();
    }

    //    Count Items Matching a rule

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count = 0;
        for (List<String> item : items) {
            switch (ruleKey) {
                case "type":
                    if (item.get(0).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "color":
                    if (item.get(1).equals(ruleValue)) {
                        count++;
                    }
                    break;
                case "name":
                    if (item.get(2).equals(ruleValue)) {
                        count++;
                    }
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }
        }
        return count;
    }

    //    Sorting the Sentence
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        String[] ans = new String[str.length];
        for (String word : str) {
            int i = (int) (word.charAt(word.length() - 1) - '0');
            ans[i - 1] = word.substring(0, word.length() - 1);
        }
        StringBuilder originalSentence = new StringBuilder();
        int i = 0;
        for (; i < ans.length - 1; i++) {
            originalSentence.append(ans[i]).append(" ");
        }
        originalSentence.append(ans[i]);
        return originalSentence.toString();
    }

    //    Check if two strings are equivalent

    public boolean arrayStringAreEqual(String[] word1, String[] word2) {
        return arrayStringsAreEqualUsingStringBuilders(word1, word2);
//        return arrayStringsAreEqualUsingJoinMethod(word1,word2);
    }

    public boolean arrayStringsAreEqualUsingJoinMethod(String[] word1, String[] word2) {
        String str1 = String.join(",", word1);
        str1 = str1.replace(",", "");
        String str2 = String.join(",", word2);
        str2 = str2.replace(",", "");
        return str1.equals(str2);
    }

    public boolean arrayStringsAreEqualUsingStringBuilders(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        for (String str : word1) {
            str1.append(str);
        }
        for (String str : word2) {
            str2.append(str);
        }

        return str1.toString().equals(str2.toString());
    }

    //    To Lower Case
    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public String toLowerCase2(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            ans.append(c > 64 && c < 91 ? (char) (c + 32) : c);
        }
        return ans.toString();
    }

    //    Determine if string halves are alike
    public boolean halvesAreAlike(String s) {
        char[] str = s.toLowerCase().toCharArray();
        int mid = str.length / 2;
        int first = 0;
        int second = 0;
        for (int i = 0; i < mid; i++) {
            switch (str[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    first++;
            }
        }
        for (int i = mid; i < str.length; i++) {
            switch (str[i]) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    second++;
            }
        }
        return first == second;
    }

    String vowels = "aeiouAEIOU";

    public boolean halvesAreAlike2(String S) {
        int mid = S.length() / 2, ans = 0;
        for (int i = 0, j = mid; i < mid; i++, j++) {
            if (vowels.indexOf(S.charAt(i)) >= 0) ans++;
            if (vowels.indexOf(S.charAt(j)) >= 0) ans--;
        }
        return ans == 0;
    }

    //    Decrypt String from Alphabet to Integer Mapping
    public String freqAlphabets(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                str.append((char) (96 + Integer.parseInt(s.substring(i - 2, i))));
                i -= 2;
            } else {
                str.append((char) (96 + (s.charAt(i) - '0')));
            }
        }
        return str.reverse().toString();
    }

    //    Number of Strings That Appear as Substrings in Word
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String s : patterns) {
            if (word.contains(s)) count++;
        }
        return count;
    }

    //    Robot Return to Origin
    public boolean judgeCircle(String moves) {
        int[] position = {0, 0};
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    position[0]--;
                    break;
                case 'D':
                    position[0]++;
                    break;
                case 'R':
                    position[1]++;
                    break;
                case 'L':
                    position[1]--;
                    break;
            }
        }
        return Arrays.equals(position, new int[]{0, 0});
    }

    //    Reverse Words in a String III
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            StringBuilder str = new StringBuilder(arr[i]);
            arr[i] = str.reverse().toString();
        }
        StringBuilder ans = new StringBuilder();
        int i = 0;
        for (; i < arr.length - 1; i++) {
            ans.append(arr[i]).append(" ");
        }
        ans.append(arr[i]);
        return ans.toString();
    }

    //    Excel Sheet Column Title
    //copied
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.append((char) ('A' + n % 26));
            n /= 26;
        }
        result.reverse();
        return result.toString();
    }

    //    Implement strStr()
    //copied
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) { // The length of haystack
            for (int j = 0; ; j++) { // The length of needle
                if (j == needle.length())
                    return i; // If at this point we have navigated through the entire length of needle, we have found a solution, haystack[i].
                if (i + j == haystack.length())
                    return -1; // This happens when we run out of elements in haystack, but there are still elements in needle.
                if (needle.charAt(j) != haystack.charAt(i + j))
                    break; // We stop comparing after needle[j], so i will be incremented and cycle repeats itself.
            }
        }
    }

    //    Long Pressed Name
    public boolean isLongPressedName(String name, String typed) {

        int i = 1, j = 1;

        //Checking the first character
        if (name.charAt(0) != typed.charAt(0))
            return false;


        //Traversing the Strings using two pointer
        while (i < name.length() && j < typed.length()) {
            if (name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else {
                if (typed.charAt(j) == typed.charAt(j - 1))
                    j++;

                else
                    return false;
            }
        }


        //Case 1 : i and j both reached end of the String
        if (i == name.length() && j == typed.length())
            return true;

            //Case 2 : First word is not yet complete traversed. The second word is complete
        else if (i != name.length() && j == typed.length())
            return false;

            //Case 3: First word complete. The second word still has some characters left.
        else {
            while (j != typed.length()) {
                if (typed.charAt(j) == typed.charAt(j - 1))
                    j++;

                else
                    return false;
            }
        }
        return true;
    }

    //    Valid Palindrome
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str.append(s.charAt(i));
            }
        }
        return str.toString().equals(str.reverse().toString());
    }

    //    Valid Palindrome II
    public boolean validPalindrome(String s) {
        char[] sc = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (sc[i] != sc[j]) {
                return helper(sc, i + 1, j) || helper(sc, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    boolean helper(char[] sc, int i, int j) {
        while (i < j) {
            if (sc[i] != sc[j]) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean validPalindrome2(String s) {
        return isPalindrome(s, 0, s.length() - 1, false);
    }

    public boolean isPalindrome(final String s, int leftIndex, int rightIndex, final boolean isCharacterDeleted) {

        while (leftIndex < rightIndex) {

            if (s.charAt(leftIndex) != s.charAt(rightIndex)) {

                if (isCharacterDeleted) {
                    return false;
                }

                // isPalindrome(s, leftIndex + 1, rightIndex, true) for cases like "ececabbacec"
                // isPalindrome(s, leftIndex, rightIndex - 1, true) for cases like "abccbab"
                return isPalindrome(s, leftIndex + 1, rightIndex, true) || isPalindrome(s, leftIndex, rightIndex - 1, true);
            }

            ++leftIndex;
            --rightIndex;

        }

        return true;
    }

    //    Longest Common Prefix
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int index = 1; index < strs.length; index++) {
            while (strs[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    //    Maximum Repeating Substring
    public int maxRepeating(String sequence, String word) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        while (sequence.contains(result.append(word))) count++;
        return count;
    }

    //    Check if Binary String Has at Most One Segment of Ones
    public boolean checkOnesSegmentOneLiner(String s) {
        return !s.contains("01");
    }

    //using xor operator
    public boolean checkOnesSegment(String s) {

        int count = 0;
        char ch = '1';

        for (char c : s.toCharArray()) {
            if ((c ^ ch) == 1) {
                ++count;
                ch = c;
                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
    }

    //    Merge Strings Alternately
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        StringBuilder ans = new StringBuilder();
        while (i < word1.length() || j < word2.length()) {
            if (i < word1.length()) {
                ans.append(word1.charAt(i++));
            }
            if (j < word2.length()) {
                ans.append(word2.charAt(j++));
            }
        }
        return ans.toString();
    }

    //    Reverse Prefix of Word
    public String reversePrefix(String word, char ch) {
        int i = 0;
        for (; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                break;
            }
        }
        if (i == word.length()) return word;
        StringBuilder ans = new StringBuilder();

        for (int j = i; j >= 0; j--) {
            ans.append(word.charAt(j));
        }
        if (i != word.length() - 1) {
            for (int j = i + 1; j < word.length(); j++) {
                ans.append(word.charAt(j));
            }
        }
        return ans.toString();

    }

    //    Roman to Integer
    public int romanToInt(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i != s.length() - 1 && getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                total -= getValue(s.charAt(i));
            } else {
                total += getValue(s.charAt(i));
            }
        }
        return total;
    }

    public int getValue(Character ch) {

        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }


    //    Length of last word
    public int lengthOfLastWord(String s) {
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (len != 0) return len;
            } else {
                len++;
            }
        }
        return len;
    }
}

//    Valid Parentheses
