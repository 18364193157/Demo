package inspur.domain;

/**
 * @author langyonghe
 * @date 2020/11/19 14:48
 */
public class CompileTest {
    public static void main(String[] args) {
        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                break;
        }
    }
}
