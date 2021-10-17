package seedu.mtracker.commands;

import seedu.mtracker.instrument.subinstrument.Etf;
import seedu.mtracker.ui.TextUi;

import java.io.IOException;

public class AddEtfCommand extends AddInstrumentCommand {

    public static final String COMMAND_WORD = "etf";

    public static final int PAST_RETURNS_INDEX = 3;
    public static final int REMARK_INDEX = 4;

    protected double pastReturnParameter;
    protected String remarkParameter;

    public void setEtfParameters() {
        remarkParameter = inputParameters.get(REMARK_INDEX);
        pastReturnParameter = Double.parseDouble(inputParameters.get(PAST_RETURNS_INDEX));
    }

    public void createNewEtf() {
        newInstrument = new Etf(nameParameter, currentPriceParameter,
                sentimentParameter, pastReturnParameter, remarkParameter);
    }

    @Override
    public String execute() throws IOException {
        setAddGeneralParameters();
        setEtfParameters();
        createNewEtf();
        instrumentManager.addInstrument(newInstrument);
        TextUi.displayInstrumentAdded(newInstrument);
        storage.writeFile(instrumentManager);
        return COMMAND_WORD;
    }
}
