public class TakeCommand extends InputCommand {
    Player p;
    String itemName;

    public TakeCommand(Player p) {
        this.p = p;
    }

    public void init(String userString) {
        this.itemName = getInnerString(userString);
    }

    public boolean execute() {
        boolean success = p.addItem(itemName);
        return success;
    }
}
