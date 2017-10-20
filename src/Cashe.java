import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by user on 20.10.2017.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Cashe {
    int expireInSec() default -1;
}
