import static java.lang.reflect.Proxy.newProxyInstance;

public class MainClass {
    public static void main(String[] args) {
        Calculator o = (Calculator) newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class<?>[]{Calculator.class}, new LoggingProxy(new HardWorklCalculatorImpl()));
        double f = o.calculate(10);
        System.out.println(f);
        double s = o.calculate(7);
        System.out.println(s);
        double a = o.calculate(9);
        System.out.println(a);
        double d = o.calculate(10);
        System.out.println(d);
        double e = o.calculate(9);
        System.out.println(e);

    }
}
