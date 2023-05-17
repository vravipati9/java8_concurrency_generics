package java8;

public class BackwardCompatability {
    public static void main(String[] args) {
        System.out.println(Util.doWork(new Converter() {
            @Override
            public int convert(int value) {
                return value + 1;
            }
        }));

        System.out.println(Util.doWork(value -> value + 1));
    }
}
