import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 0;
        //System.out.println(predicate.test(5));

        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };

        //System.out.println(predicate1.test(-2));

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s + " привет");
            }
        };
        consumer.accept("Андрей");

        Consumer<String> consumer1 = x -> System.out.println(x + " привет");
        consumer1.accept("Сергей");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                long i = aDouble.longValue();
                return i;
            }
        };
       // System.out.println(function.apply(5.8d));

        Function<Double, Long> function1 = x -> x.longValue();
        //System.out.println(function1.apply(6.8d));
        Function<Long, Double> function2 = x -> x.doubleValue();

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                int i = random.nextInt(100);
                return i;
            }
        };
        //System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> {
            Random random = new Random();
            int i = random.nextInt(100);
            return i;
        };
       // System.out.println(supplier1.get());

        Predicate <Integer> integerPredicate = x -> x > 0;
        Function<Integer, Double> integerDoubleFunction = x -> x.doubleValue();
        Function<Integer, Long> integerLongFunction = x -> x.longValue();


        ternaryOperator(predicate, integerDoubleFunction, integerLongFunction);


    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return new Function<T, U>() {
            U u;
            @Override
            public U apply(T t) {
                if (condition.test(t)) {
                    u = ifTrue.apply(t);
                }else u = ifFalse.apply(t);
                System.out.println(u);
                return  u;
            }
    };
}

}
