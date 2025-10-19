package pr7.task5;

public class StringOperations implements Str{

    @Override
    public int len(String s) {
        if (s == null) {
            return 0;
        }
        return s.length();
    }

    @Override
    public String nechetpos(String s) {
        if (s == null || s.isEmpty()){ return "";}
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2){
            newStr.append(s.charAt(i));
        }
        return newStr.toString();
    }

    @Override
    public String reverse(String s) {
        if (s == null) {return null;}
        StringBuilder res = new StringBuilder(s);
        return res.reverse().toString();
    }
}
