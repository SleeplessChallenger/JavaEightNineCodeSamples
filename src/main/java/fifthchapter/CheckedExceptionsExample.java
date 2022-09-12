package fifthchapter;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckedExceptionsExample {
    // doesn't work
//    public List<String> encodeValues(String... values) throws UnsupportedEncodingException {
//        return Arrays.stream(values)
//                .map(s -> URLEncoder.encode(s, "UTF-8"))
//                .collect(Collectors.toList());
//    }

    public List<String> encodeValuesAnonClass(String... values) {
        return Arrays.stream(values)
                .map(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        try {
                            return URLEncoder.encode(s, "UTF-8");
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                            return "";
                        }
                    }
                })
                .collect(Collectors.toList());
    }

    public List<String> encodeValues(String... values) {
        return Arrays.stream(values)
                .map(s -> {
                    try {
                        return URLEncoder.encode(s, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        return "";
                    }
                })
                .collect(Collectors.toList());
    }

    // extracted method for encoding

    public List<String> encodeValuesExtracted(String... values) {
        return Arrays.stream(values)
//                .map(s -> extractedMethodForCalculation(s))
                .map(this::extractedMethodForCalculation)
                .collect(Collectors.toList());
    }

    private String extractedMethodForCalculation(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
