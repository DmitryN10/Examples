import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by user on 20.10.2017.
 */
public class LoggingProxy implements InvocationHandler {

    private final Object delegate;
    HashMap<ArrayList<Object>, ResultAndTme> cash = new HashMap<>();

    public LoggingProxy(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cashe annotation = method.getAnnotation(Cashe.class);
        int i = annotation.expireInSec();

        if (args != null){
            System.out.print("input ");
            for (Object arg: args) System.out.print(arg + ", ");
            System.out.println();
        }

        ArrayList<Object> methAndParam = new ArrayList<>();
        methAndParam.add(method);
        Collections.addAll(methAndParam, args);

        if (cash.containsKey(methAndParam)) addElementWhichExist(cash, methAndParam);

        long startTime = System.currentTimeMillis();
        Object result = method.invoke(delegate, args);
        ResultAndTme resultAndTme = new ResultAndTme(result, startTime);
        cash.put(methAndParam, resultAndTme);
        return resultAndTme.getResult();
    }
    public static Object addElementWhichExist(Map<ArrayList<Object>, ResultAndTme> map,  ArrayList<Object> methAndParam){
        if (map.containsKey(methAndParam)){
            long time = map.get(methAndParam).getStartTime();
            long currentTime = System.currentTimeMillis();
            if ((currentTime - time)*1000 < i){
                System.out.println("contain");
                System.out.println("Time is not up");
                return map.get(methAndParam).getResult();
            }
            else {
                System.out.println("Time is up");
                map.remove(methAndParam);
            }
        }

    }
}
