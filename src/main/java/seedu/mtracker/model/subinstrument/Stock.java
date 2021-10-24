package seedu.mtracker.model.subinstrument;

import seedu.mtracker.model.Instrument;

public class Stock extends Instrument {

    protected String remark;
    protected static final String STOCK_ICON = "[S]";
    protected static final String TYPE_INSTRUMENT = "Stock";

    public Stock(String name, double currentPrice, String sentiment, String remark) {
        super(name, currentPrice, sentiment);
        this.remark = remark;
    }

    @Override
    public String getRemark() {
        return remark;
    }

    @Override
    public void setRemark(String inputRemark) {
        remark = inputRemark;
    }

    @Override
    public String getSpecificParameter(int index) {
        return null;
    }

    @Override
    public void setSpecificParameter(Double inputReturns, int index) {

    }

    @Override
    public String getType() {
        return TYPE_INSTRUMENT;
    }

    @Override
    public String textFileFormatting() {
        return String.format(super.textFileFormatting()
                + FILE_SEPARATOR + getRemark());
    }

    @Override
    public String getTypeIcon() {
        return STOCK_ICON;
    }

    @Override
    public String getAllParams() {
        return super.getAllParams()
                + REMARKS_FIELD + remark;
    }
}
