public abstract class InputCommand implements Command {

    public abstract void init(String userString);

    public abstract boolean execute();

    protected String getSecondWord(String userString) {
        return userString.split(" ")[1];
    }

}
