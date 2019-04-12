import com.sun.corba.se.impl.orbutil.graph.Graph;

public class GoCommand extends InputCommand {
    Level l;
    Player p;
    String room;

    public GoCommand(Level l, Player p) {
        this.l = l;
        this.p = p;
    }

    @Override
    public void init(String userString) {
        room = getInnerString(userString);
    }

    @Override
    public boolean execute() {
        if (!p.moveRoom(l.getRoom(room))) {
            System.out.println("You can't go to " + room);
            return false;
        } else {
            return true;
        }
    }
}
