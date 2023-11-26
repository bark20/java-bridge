package bridge.view.print;

public interface Printer {

    void printLine(String message);

    void printWithEmptyLineAhead(String message);

    void printEmptyLine();

}
