package interview.template2;

import java.io.*;

public class Check {
    public static void main(String[] args) throws IOException {
        check("D:\\gitdoc\\interview_code\\src\\interview\\code_0915_爱奇艺\\Main1.java");//这里的字符串是你要统计的文件的路径，你自己填写
    }

    public static void check(String s) throws IOException {

        int  describe = -1;
        String str = null;
        File f = new File(s);
        BufferedReader br = new BufferedReader(new FileReader(f));
        str = br.readLine();
        while (str != null) {
            if (str.contains("//")) describe++;
            if (str.contains("/*")) {
                while (!str.contains("*/")) {
                    describe++;
                    str = br.readLine();
                }
            }
            str = br.readLine();
        }
        System.out.println("文件注释行数为：" + describe);
        /*asdfdsff
         * sdasadfsf//fg
         * asdfsdf//dsfg
         * asdf
         */
    }
}