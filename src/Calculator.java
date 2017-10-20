/**
 * Created by user on 20.10.2017.
 */
public interface Calculator {

    @Cashe(expireInSec = 20)
    double calculate(double a);

    @Cashe(expireInSec = 10)
    double calculate2(double a);

    @Cashe(expireInSec = 10)
    double calculate3(double a);


}
