public class Popstar extends Creature {

    public Popstar(Player p, Level.Room r) {
        super(p, r);
    }

    public void move() {
        moveTo(findNextRoom());
    }

    protected Level.Room findNextRoom() {
        Level.Room newRoom;
        if (currentRoom.hasNeighbor(player.getCurrentRoom())) {
            newRoom = player.getCurrentRoom();
        } else if (currentRoom == player.getCurrentRoom()) {
            newRoom = currentRoom;
        } else {
            newRoom = moveRandom();
        }
        for (Level.Room r : this.currentRoom.getNeighborsList()) {
            for (Level.Room r2 : r.getNeighborsList()) {
                if (player.getCurrentRoom() == r2) {
                    newRoom = r;
                }
            }
        }
        return newRoom;
    }
}
