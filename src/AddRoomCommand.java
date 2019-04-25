import java.util.Scanner;

public class AddRoomCommand extends InputCommand {
    Player p;
    Level l;
    Scanner in;

    public AddRoomCommand(Player p, Level l) {
        this.p = p;
        this.l = l;
        in = new Scanner(System.in);
    }

    @Override
    public void init(String userString) {
        l.addRoom(getSecondWord(userString), "");
        l.addUndirectedEdge(p.getCurrentRoom().getName(), getSecondWord(userString));
        p.setCurrentRoom(l.getRoom(getSecondWord(userString)));
    }

    @Override
    public boolean execute() {
        return true;
    }
}
