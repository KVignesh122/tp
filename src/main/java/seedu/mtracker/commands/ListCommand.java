package seedu.mtracker.commands;

import seedu.mtracker.instrument.Instrument;
import seedu.mtracker.ui.TextUi;

import java.io.IOException;
import java.util.ArrayList;

public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    private ArrayList<Instrument> instruments;

    @Override
    public String execute() throws IOException {
        instruments = instrumentManager.getInstruments();
        TextUi.displayAllInstruments(instruments);
        storage.writeFile(instrumentManager);
        return COMMAND_WORD;
    }
}
