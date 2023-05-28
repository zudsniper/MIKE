package tf.zod.autoagpt.ui;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class UserInterface {

    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void displayState() {
        // For now, just log a placeholder message
        log.info("Displaying the current state of the system...");
    }

    public String receiveUserInput() {
        log.info("Enter command: ");
        return scanner.nextLine();
    }
}
