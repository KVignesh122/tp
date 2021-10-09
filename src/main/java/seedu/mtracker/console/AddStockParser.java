package seedu.mtracker.console;

import seedu.mtracker.commands.AddInstrumentCommand;
import seedu.mtracker.commands.AddStockCommand;
import seedu.mtracker.ui.TextUi;

public class AddStockParser extends AddInstrumentParser {

    public static String STOCK_TYPE = "stock";

    public String getStockRemarksFromUser() {
        TextUi.displayAddRemarksInstruction();
        return getUserInput();
    }

    public void addStockRemarksToParameters() {
        String remarks = getStockRemarksFromUser();
        parameters.add(remarks);
    }

    public void getStockSpecificParameters() {
        addStockRemarksToParameters();
    }

    @Override
    public AddInstrumentCommand getInstrumentParameters() {
        getGeneralParameters(STOCK_TYPE);
        getStockSpecificParameters();

        return new AddStockCommand();
    }
}