import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    public String name;

    private final PrintStream printStream;
    private final Scanner scanner;


    public HumanPlayer(PrintStream printStream, Scanner scanner) {
        this.printStream = printStream;
        this.scanner = scanner;
    }

    public void setName(String name) {
        this.name = "Michael";
    }

    public String getName() {
        return name;
    }

    @Override
    public int chooseMove() {
        printStream.println("Enter 1 for Rock, 2 for Paper, 3 for Scissors");
        return scanner.nextInt() - 1;
    }
}
