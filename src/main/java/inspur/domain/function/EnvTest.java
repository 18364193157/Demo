package inspur.domain.function;

/**
 * @author langyonghe
 * @date 2021/3/31 15:49
 */
public class EnvTest {

    public static void main(String[] args) {

        System.out.println(System.getenv("JAVA_HOME"));
        System.out.println(System.getenv("NIFI_HOME"));
        System.out.println(System.getenv("MAVEN_HOME"));

        try {
            String sr = null;
//            String trim = sr.trim();
            System.out.println(1/0);
        }catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            System.out.println("exe");
        }
    }
}
