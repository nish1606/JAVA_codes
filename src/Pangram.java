public class Pangram {
    public static void main(String[] args) {
        String sentence = "thequickbrownfoxjumpsoverthelazydog";
        boolean ans = checkPangram(sentence);
        System.out.println(ans);
    }
    static boolean checkPangram(String sentence){
        boolean[] seen = new boolean[26];
        int count = 0;
        sentence = sentence.toLowerCase();
        for(char ch : sentence.toCharArray()){
            if(ch >='a' && ch<='z'){
                int index = ch - 'a';
                if(!seen[index]){
                    seen[index] = true;
                    count++;
                }
            }
        }
        return count==26;
    }
}
