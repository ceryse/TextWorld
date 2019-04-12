public class TakeCommand implements Command {
    Level level;
    String itemName;

    public TakeCommand(Level level) {
        this.level = level;
    }

    public void init(String userString) {
        this.itemName = getInnerString(userString);
    }

    private String getInnerString(String userString) {
        return userString.substring(userString.indexOf("<") + 1, userString.indexOf(">"));
    }

    public boolean execute() {
        Player p = level.getPlayer();
        boolean success = p.addItem(itemName);
        return success;
    }
}
