package thirdchapter;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector {

    public void useCollector() {
        // with lambda
        String s = Stream.of("this", "is", "list")
                .collect(() -> new StringBuilder(),
                        (sb, str) -> sb.append(str),
                        (sb1, sb2) -> sb1.append(sb2)
                ).toString();

        // with reference
        String s2 = Stream.of("this", "is", "also")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append).toString();

        // with joining
        String s3 = Stream.of("this", "is", "next")
                .collect(Collectors.joining());

        // collect with StringBuilder
        String string = new String("Just for example");
        String forward = string.toLowerCase(Locale.ROOT).codePoints()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();
        String backward = new StringBuilder(forward).reverse().toString();
        forward.equals(backward);

    }
}
