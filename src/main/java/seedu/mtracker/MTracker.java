package seedu.mtracker;

import seedu.mtracker.commands.Command;
import seedu.mtracker.commands.ExitCommand;
import seedu.mtracker.commands.InvalidCommand;
import seedu.mtracker.console.InputParser;
import seedu.mtracker.error.ErrorMessage;
import seedu.mtracker.filemanager.Storage;
import seedu.mtracker.instrument.InstrumentManager;
import seedu.mtracker.ui.TextUi;

import java.util.logging.Level;

public class MTracker {
    private Storage storage;
    private InstrumentManager instrumentManager;
    private InputParser parser;
    private LogHelper logger;

    public MTracker(String filePath) {
        try {
            instrumentManager = InstrumentManager.getInstance();
            logger = LogHelper.getInstance();
            storage = new Storage(filePath);
            parser = new InputParser();
        } catch (Exception e) {
            ErrorMessage.displayFileError();
            System.exit(-1);
        }
    }

    public void run() {
        Command command;
        String userInput;
        String[] commandComponents;

        do {
            userInput = InputParser.getUserInput();
            commandComponents = parser.getCommandComponents(userInput);
            try {
                command = parser.filterByCommandType(commandComponents);
                command.setData(instrumentManager, storage);
                command.execute();
            } catch (Exception e) {
                logger.getLogger().log(Level.WARNING, e.getMessage());
                TextUi.showErrorMessage(e);
                command = new InvalidCommand();
            }
        } while (!(command instanceof ExitCommand));
    }

    public void executeProgram() {
        TextUi.greetAtStartUp();
        run();
    }

    /**
     * Main entry-point for the mTracker application.
     */
    public static void main(String[] args) {
        new MTracker("data/mTracker.txt").executeProgram();
    }

}
