public class InventoryCommand implements Command {
    Player p;

    public InventoryCommand(Player p) {
        this.p = p;
    }

    @Override
    public void init(String userString) {
    }

    @Override
    public boolean execute() {
        System.out.println(p.getInventory());
        return true;
    }
}
