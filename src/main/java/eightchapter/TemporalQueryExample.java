package eightchapter;

import java.time.LocalDate;
import java.time.temporal.TemporalQueries;

// `TemporalQuery` interface is used as the argument to the query method on temporal objects
public class TemporalQueryExample {

//    <R> R query(TemporalQuery<R> query)
    public static void main(String[] args) throws Exception {
        queries();
    }

    public static void queries() throws Exception {
        Object returnValue = LocalDate.now().query(TemporalQueries.precision());
        System.out.println(returnValue);
    }

}
