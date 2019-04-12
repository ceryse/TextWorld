public class TakeCommand extends InputCommand {
    Level level;
    String itemName;

    public TakeCommand(Level level) {
        this.level = level;
    }

    public void init(String userString) {
        this.itemName = getInnerString(userString);
    }

    public boolean execute() {
        Player p = level.getPlayer();
        boolean success = p.addItem(itemName);
        return success;
    }
}
