package view;

import camp.nextstep.edu.missionutils.Console;
import utils.Parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputView {
    // case1. 단일 숫자만 입력
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        while (true) {
            try {
                int number = inputBridgeSize();
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int inputBridgeSize() {
        String string = Console.readLine();
        validateNumber(string);
        return Integer.parseInt(string);
    }

    private static void validateNumber(String string) {
        // 숫자(0-9)만 허용하는 정규식
        if (!string.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("[ERROR] 자연수만 허용됩니다.");
        }
        //  특정 숫자 기준 존재
        if (Integer.parseInt(string) > 20 || Integer.parseInt(string) < 3) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    // ============================ //
    // case2. 단일 문자열만 입력
    public static String readString() {
        System.out.println("시스템 시작");
        while (true) {
            try {
                String string = inputString();
                return string;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputString() {
        String string = Console.readLine();
        validateString(string);
        return string;
    }

    private static void validateString(String string) {
        // 영어만 허용하는 정규식
        if (!string.matches("^[a-zA-z]+$")) {
            throw new IllegalArgumentException("[ERROR] 영어만 허용됩니다.");
        }
//        // 한글만 허용하는 정규식
//        if (!string.matches("^[가-힣]+$")) {
//            throw new IllegalArgumentException("[ERROR] 한글만 허용됩니다.");
//        }
        // 특정 문자만 허용하는 정규식(U와 D만 허용)
        if (!string.equals("U") || string.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U와 D만 허용됩니다.");
        }
    }

    // ============================ //
    // case3. 구분자로 문자를 입력 받는 경우 - String
    public static List<String> readStringList() {
        System.out.println("시스템 시작");
        while (true) {
            try {
                List<String> stringList = inputStringList();
                return stringList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 쉼표(,) + 공백 불허를 기준으로 구분 (ex) 김성한,포비,해피 / 김성한
    private static List<String> inputStringList() {
        List<String> stringList = List.of(Console.readLine().split(","));
        validateStringList(stringList);
        return stringList;
    }

    private static void validateStringList(List<String> stringList) {
        Set<String> uniqueNames = new HashSet<>();

        for (String string : stringList) {
            // 문자열의 길이 제한 확인
            if (string.length() > 5) {
                throw new IllegalArgumentException("[ERROR] 예시를 참고해주세요. 문자열의 길이는 5 미만 입니다.");
            }
            // (영어 대소문자 + 숫자 + 한글) 만 허용
            if (!string.matches("^[a-zA-Z0-9가-힣]+$")) {
                throw new IllegalArgumentException("[ERROR] 특수문자 및 공백은 불허합니다.");
            }
            // 이미 나타난 이름인지 확인 - 중복체크
            if (!uniqueNames.add(string)) {
                throw new IllegalArgumentException("[ERROR] 중복된 것이 존재합니다.");
            }
        }
    }

    // ============================ //
    // case4. 구분자로 숫자를 입력 받는 경우 - Integer
    public static List<Integer> readIntList() {
        System.out.println("시스템 시작");
        while (true) {
            try {
                List<Integer> intList = inputIntList();
                return intList;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 쉼표(,)를 기준으로 구분 (ex) 1,2,3 / 1
    private static List<Integer> inputIntList() {
        List<String> stringList = List.of(Console.readLine().split(","));
        validateIntList(stringList);
        List<Integer> intList = Parser.parseInteger(stringList);
        return intList;
    }

    private static void validateIntList(List<String> intList) {
        Set<String> uniqueNames = new HashSet<>();

        for (String number : intList) {
            // 숫자 판단
            if (!number.matches("^[0-9]+$")) {
                throw new IllegalArgumentException("[ERROR] 숫자만 허용됩니다.");
            }
            // 특정수 기준 이하, 미만, 이상, 초과 판단
            if (Integer.parseInt(number) > 5) {
                throw new IllegalArgumentException("[ERROR] 5 이상만 허용됩니다.");
            }
            // 중복 판단
            if (!uniqueNames.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 것이 존재합니다.");
            }
        }
    }
}
