package sword_offer.code5;

/**
 * @author Created By Frank
 * @date 2018-08-23 9:13
 * 替换空格
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer resStr = new StringBuffer();

        String str2 = str.toString();
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            if(ch == ' '){
                resStr.append("%20");
            }
            else{
                resStr.append(ch);
            }
        }
        return resStr.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We Are Happy");
        System.out.println(new Solution().replaceSpace(sb));
    }
}