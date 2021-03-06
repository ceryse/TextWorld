public class DropCommand extends InputCommand {
    Player p;
    Item item;

    public DropCommand(Player p) {
        this.p = p;
    }

    @Override
    public void init(String userString) {
        userString = getSecondWord(userString);
        item = p.removeItem(userString);
        if (item == null) {
        }
    }

    @Override
    public boolean execute() {
        if (item != null) {
            p.getCurrentRoom().addItem(item);
            return true;
        } else {
            System.out.println("You do not have that item");
            return false;
        }
    }
}
