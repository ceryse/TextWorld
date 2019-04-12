public abstract class InputCommand implements Command {

    public abstract void init(String userString);

    public abstract boolean execute();

    protected String getInnerString(String userString) {
        return userString.substring(userString.indexOf("<") + 1, userString.indexOf(">"));
    }

}
