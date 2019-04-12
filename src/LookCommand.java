public class LookCommand implements Command {
    Player p;

    public LookCommand(Player p) {
        this.p = p;
    }

    @Override
    public void init(String userString) {
    }

    @Override
    public boolean execute() {
        System.out.println("You are in " + p.getCurrentRoom().getDescription());
        System.out.println("You can go to the " + p.getCurrentRoom().getNeighborNames());
        System.out.println("The items in this room are: " + p.getCurrentRoom().displayItems());
        System.out.println("The creatures in this room are " + p.getCurrentRoom().getCreatureNames());
        return true;
    }
}
