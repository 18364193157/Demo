package inspur.domain;

import java.io.UnsupportedEncodingException;

/**
 * @author langyonghe
 * @date 2020/11/19 14:48
 */
public class CompileTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "2017-09-07 16:49:05.0";
        char[] chars = str.toCharArray();
        System.out.println(chars.length);
        System.out.println(str.getBytes("UTF-8").length);
    }
}
