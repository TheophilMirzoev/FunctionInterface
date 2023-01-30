import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args)
    {
        Predicate <Integer> predicate = x -> x > 0;
        System.out.println(predicate.test(5));

        Predicate<Integer> predicate1 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer >= 0) {
                    return true;
                } else
                    return false;
            }
        };

        System.out.println(predicate1.test(-2));

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
        System.out.println(function.apply(5.8d));

        Function<Double, Long> function1 = x -> x.longValue();
        System.out.println(function1.apply(6.8d));

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
               Random random = new Random();
                int i = random.nextInt(100);
                return i;
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> {
            Random random = new Random();
            int i = random.nextInt(100);
            return i;
        };
        System.out.println(supplier1.get());

    }
    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition,
                                                        Function<? super T, ? extends U> ifTrue,
                                                        Function<? super T, ? extends U> ifFalse){
          if (condition.equals(true) ){
              return (Function<T, U>) ifTrue;
          }else return (Function<T, U>) ifFalse;
    }
}