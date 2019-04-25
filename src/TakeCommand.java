public class TakeCommand extends InputCommand {
    Player p;
    String itemName;

    public TakeCommand(Player p) {
        this.p = p;
    }

    public void init(String userString) {
        this.itemName = getSecondWord(userString);
    }

    public boolean execute() {
        boolean success = p.addItem(itemName);
        p.getCurrentRoom().removeItem(itemName);
        return success;
    }
}
