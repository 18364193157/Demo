package inspur.domain.function;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author langyonghe
 * @date 2021/2/25 19:52
 */
public class FunctionTest<In,Out> {

    Function<In,Out> function = in -> (Out) ("apply:" + in);

    public static void main(String[] args) {
        FunctionTest<String,String> functionTest = new FunctionTest<>();
        System.out.println(functionTest.function.apply("hello~!"));


    }
}
