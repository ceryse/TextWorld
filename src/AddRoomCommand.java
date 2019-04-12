import java.util.Scanner;

public class AddRoomCommand implements Command {
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
        System.out.print("Type a description >");
        String description = in.nextLine();
        l.addRoom(getInnerString(userString), description);
        l.addUndirectedEdge(p.getCurrentRoom().getName(), getInnerString(userString));
        p.setCurrentRoom(l.getRoom(getInnerString(userString)));
    }

    @Override
    public boolean execute() {
        return false;
    }

    private static String getInnerString(String response) {
        return response.substring(response.indexOf("<") + 1, response.indexOf(">"));
    }
}
