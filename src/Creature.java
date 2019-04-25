public abstract class Creature {
    Level.Room currentRoom;
    Player player;

    public Creature(Player p, Level.Room r) {
        player = p;
        currentRoom = r;
        currentRoom.addCreature(this);
    }

    public Level.Room getCurrentRoom() {
        return currentRoom;
    }

    private void setCurrentRoom(Level.Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public abstract void move();

    protected abstract Level.Room findNextRoom();

    protected void moveTo(Level.Room newRoom) {
        currentRoom.moveCreature(newRoom, this);
        this.setCurrentRoom(newRoom);
    }

    protected Level.Room moveRandom() {
        return currentRoom.getRandomNeighbor();
    }
}
