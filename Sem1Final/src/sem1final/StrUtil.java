package sem1final;

public class StrUtil {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String oldString = "aaa";
        String newString = "bq";
        String string = "zzzaaaaaa";

        String returnString = apcsReplaceAll(string, oldString, newString);
        System.out.println(returnString);
    }

    public static String apcsReplaceAll(String str, String oldStr, String newStr) {
        String run = "";
        int last = 0;
        for (int i = 0; i <= str.length() - oldStr.length(); i++) {
            if (str.substring(i, i + oldStr.length()).equals(oldStr)) {
                run += str.substring(last, i);
                run += newStr;
                last = i + oldStr.length();
                i = last - 1;
            }
        }
        run += str.substring(last, str.length());
        return run;
    }
}
