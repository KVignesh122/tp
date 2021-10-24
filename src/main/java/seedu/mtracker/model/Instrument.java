package seedu.mtracker.model;

import java.util.HashSet;

public abstract class Instrument {
    protected String name;
    protected double currentPrice;
    protected String sentiment;
    protected boolean isDone;

    protected static final String EMPTY_STRING = "";
    protected static final String FILE_SEPARATOR = ";";
    public static final String SEMICOLON_SEP = "; ";
    public static final String SPACE = " ";

    private static final String TYPE_FIELD = "Type: ";
    private static final String NAME_FIELD = "Name: ";
    private static final String CURRENT_PRICE_FIELD = "Current Price: ";
    private static final String SENTIMENT_FIELD = "Sentiment: ";
    protected static final String REMARKS_FIELD = "Remarks: ";

    protected static final String DONE_SYMBOL = "[X]";
    protected static final String NOT_DONE_SYMBOL = "[ ]";

    protected static final String NAME_ATTRIBUTE = "name";
    protected static final String CURRENT_PRICE_ATTRIBUTE = "current-price";
    protected static final String SENTIMENT_ATTRIBUTE = "sentiment";
    protected static final String REMARK_ATTRIBUTE = "remark";
    protected static HashSet<String> validAttribute;

    public Instrument(String name, double currentPrice, String sentiment) {
        this.name = name;
        this.currentPrice = currentPrice;
        this.sentiment = sentiment;
        this.isDone = false;
        validAttribute = new HashSet<>();
    }

    public boolean getIsDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    public String getStatusIcon() {
        return (getIsDone() ? DONE_SYMBOL : NOT_DONE_SYMBOL);
    }

    public String getName() {
        return name;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public String getSentiment() {
        return sentiment;
    }

    public abstract String getType();

    public String textFileFormatting() {
        return String.format(getType() + FILE_SEPARATOR + getName() + FILE_SEPARATOR
                + getCurrentPrice() + FILE_SEPARATOR + getSentiment() + FILE_SEPARATOR
                + getIsDone());
    }

    public abstract String getTypeIcon();

    public String getAllParams() {
        return TYPE_FIELD + getType() + getStatusIcon() + System.lineSeparator()
                + NAME_FIELD + name + System.lineSeparator()
                + CURRENT_PRICE_FIELD + currentPrice + System.lineSeparator()
                + SENTIMENT_FIELD + sentiment + System.lineSeparator();
    }

    public String getGeneralParams() {
        return getTypeIcon() + getStatusIcon()
                + SPACE + name + SEMICOLON_SEP + currentPrice + SEMICOLON_SEP + sentiment;
    }


    public void setName(String inputName) {
        name = inputName;
    }

    public void setCurrentPrice(double inputCurrentPrice) {
        currentPrice = inputCurrentPrice;
    }

    public void setSentiment(String inputSentiment) {
        sentiment = inputSentiment;
    }

    public abstract String getRemark();

    public abstract void setRemark(String currentPrice);

    public abstract String getSpecificParameter(int index);

    public abstract void setSpecificParameter(Double inputReturns,int index);

    public HashSet<String> getValidAttribute() {
        validAttribute.add(NAME_ATTRIBUTE);
        validAttribute.add(CURRENT_PRICE_ATTRIBUTE);
        validAttribute.add(SENTIMENT_ATTRIBUTE);
        validAttribute.add(REMARK_ATTRIBUTE);
        return validAttribute;
    }
}
