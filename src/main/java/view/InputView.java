package view;

import camp.nextstep.edu.missionutils.Console;

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

    public static String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        while (true) {
            try {
                String string = inputMoving();
                return string;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputMoving() {
        String string = Console.readLine();
        validateMoving(string);
        return string;
    }

    private static void validateMoving(String string) {
        // 영어만 허용하는 정규식
        if (!string.matches("^[a-zA-z]+$")) {
            throw new IllegalArgumentException("[ERROR] 영어만 허용됩니다.");
        }
        // 특정 문자만 허용하는 정규식(U와 D만 허용)
        if (!string.equals("U") || string.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U와 D만 허용됩니다.");
        }
    }

    public static String readGameCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        while (true) {
            try {
                String string = inputGameCommand();
                return string;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static String inputGameCommand() {
        String string = Console.readLine();
        validateGameCommand(string);
        return string;
    }

    private static void validateGameCommand(String string) {
        // 영어만 허용하는 정규식
        if (!string.matches("^[a-zA-z]+$")) {
            throw new IllegalArgumentException("[ERROR] R와 Q만 허용됩니다.");
        }
        // 특정 문자만 허용하는 정규식(U와 D만 허용)
        if (!string.equals("R") || string.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R와 Q만 허용됩니다.");
        }
    }
}
