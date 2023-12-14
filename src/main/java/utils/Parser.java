package utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static String joinWithBlank(List<String> stringList) {
        return String.join(" | ", stringList);
    }

}
