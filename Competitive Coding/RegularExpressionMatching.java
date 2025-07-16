public class RegularExpressionMatching {
    public static void main(String[] args) {
        // String str = "abb";
        // String patteren = "a.*";
        System.out.println(findmatch("aab", "a.*"));
        System.out.println(findmatch("aa", "a"));
        System.out.println(findmatch("aa", "a*"));
        System.out.println(findmatch("ab", ".*"));
        System.out.println(findmatch("mississippi", "mis*is*p*."));
    }
    public static boolean findmatch(String str, String pattern){
        int strlen = str.length();
        int patternlen = pattern.length();
        return findmatchutil(str, strlen, pattern, patternlen);
    }

    public static boolean findmatchutil(String str, int strlength, String pattern, int patternlen){
        if (patternlen == 0){
            return strlength == 0;
        }
        if (strlength == 0){
            return (patternlen >= 2 && pattern.charAt(patternlen - 1) == '*') && findmatchutil(str, strlength, pattern, patternlen-2);
        }

        if (str.charAt(strlength - 1) == pattern.charAt(patternlen - 1) || pattern.charAt(patternlen - 1) == '.'){
            return findmatchutil(str, strlength-1, pattern, patternlen-1);
        }
        if (pattern.charAt(patternlen - 1) == '*'){
            boolean zero = findmatchutil(str, strlength, pattern, patternlen-2);
            boolean oneOrmore = (pattern.charAt(patternlen - 2) == str.charAt(strlength - 1) || pattern.charAt(patternlen - 2) == '.') && findmatchutil(str, strlength-1, pattern, patternlen);
            return zero || oneOrmore;
        }


        return false;
    }
}
