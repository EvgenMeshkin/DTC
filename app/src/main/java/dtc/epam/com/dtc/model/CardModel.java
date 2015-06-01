package dtc.epam.com.dtc.model;


public class CardModel<Model> implements ICardType {

    private Card.Type mType;

    private Model mModel;

    public CardModel(Card.Type type, Model model) {
        this.mType = type;
        this.mModel = model;
    }

    @Override
    public int getType() {
        return mType.ordinal();
    }

    public Card.Type getCardType() {
        return mType;
    }

    public Model getModel() {
        return mModel;
    }
}
