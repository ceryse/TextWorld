public class EmptyCommand implements Command {

    public void init(String userString) {
    }

    public boolean execute() {
        System.out.println("Type 'go <roomname>' to go to the room\nType 'look' to look around the room\n" +
                "Type 'add room <roomname>' to add a neighbor to your current room.\nType 'take <object>' to pick up an object" +
                "\nType 'drop <object> to drop an object\nType 'inventory' to display your inventory\nType 'quit' to quit");
        return true;
    }
}
