package by.it._examples_.jd01_10.sample_proxylog.logger;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {
    String text();

    Level level() default Level.INFO;

    enum Level {
        ERROR, DEBUG, INFO, MESSAGES
    }
}
