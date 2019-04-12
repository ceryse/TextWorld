import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, Command> commands;

    public static void main(String[] args) {
        Level l = setUpLevel();
        Player p = setUpPlayer(l);
        l.setPlayer(p);
        ArrayList<Creature> creatures = setUpCreatures(l, p);
        initCommands(l, p);

        String response = "";
        Scanner in = new Scanner(System.in);

        displayOptions();
        do {
            System.out.println("You are in the " + p.getCurrentRoom().getName());
            System.out.print("What do you want to do? >");
            response = in.nextLine();
            response.trim();

            moveCreatures(creatures);
            Command command = lookupCommand(response);
            command.execute();

//            if (response.contains("go") && containsTwoBrackets(response)) {
//                response = getInnerString(response);
//                if (!p.moveRoom(l.getRoom(response))) {
//                    System.out.println("You can't go to " + response);
//                }
//            } else if (response.equals("look")) {
//                look(p);
//            } else if (response.contains("add room") && containsTwoBrackets(response)) {
//                System.out.print("Type a description >");
//                String description = in.nextLine();
//                l.addRoom(getInnerString(response), description);
//                l.addUndirectedEdge(p.getCurrentRoom().getName(), getInnerString(response));
//                p.setCurrentRoom(l.getRoom(getInnerString(response)));
//            } else if (response.contains("take") && containsTwoBrackets(response)) {
//                response = getInnerString(response);
//                Item temp = p.getCurrentRoom().removeItem(response);
//                if (temp == null) {
//                    System.out.println(response + " doesn't exist!");
//                } else {
//                    p.addItem(temp);
//                }
//            } else if (response.contains("drop") && containsTwoBrackets(response)) {
//                response = getInnerString(response);
//                Item temp = p.removeItem(response);
//                if (temp == null) {
//                    System.out.println("You do not have a " + response);
//                } else {
//                    p.getCurrentRoom().addItem(temp);
//                }
//            } else if (response.contains("inventory")) {
//                System.out.println(p.getInventory());
//            } else if (response.equals("quit")) {
//                continue;
//            } else {
//                displayOptions();
//            }

        } while (!response.equals("quit"));
    }

    private static Command lookupCommand(String response) {
        String commandWord = getCommandName(response);
        Command c = commands.get(commandWord);
        if (c == null) return new EmptyCommand();
        c.init(response);

        return c;
    }

    private static String getCommandName(String response) {
        String[] response1 = response.split("<");
        return response1[0];
    }

    private static void initCommands(Level l, Player p) {
        commands = new HashMap<String, Command>();
        commands.put("take", new TakeCommand(l));
        commands.put("look", new LookCommand(p));
        commands.put("add room", new AddRoomCommand(p, l));
    }

    private static Player setUpPlayer(Level g) {
        Player p = new Player("Cerys", "me");
        p.setCurrentRoom(g.getRoom("hall"));
        return p;
    }

    private static ArrayList<Creature> setUpCreatures(Level g, Player p) {
        ArrayList<Creature> creatures = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            creatures.add(new Chicken(p, g.getRandomRoom()));
        }

        creatures.add(new Wumpus(p, g.getRandomRoom()));
        creatures.add(new Popstar(p, g.getRandomRoom()));

        return creatures;
    }

    private static Level setUpLevel() {
        Level l = new Level();
        l.addRoom("hall", "a long dark hallway");
        l.addRoom("closet", "a dark, dark closet");
        l.addRoom("dungeon", "a dank dark dungeon");
        l.addRoom("bedroom", "a cozy bedroom");
        l.addRoom("bathroom", "a cold, tiled bathroom");
        l.addRoom("ladder", "a long ladder");

        l.addUndirectedEdge("hall", "bedroom");
        l.addUndirectedEdge("hall", "closet");
        l.addUndirectedEdge("bedroom", "bathroom");
        l.addDirectedEdge("ladder", "hall");
        l.addUndirectedEdge("ladder", "dungeon");
        l.addDirectedEdge("bathroom", "dungeon");

        l.getRoom("hall").addItem(new Item("lobster", "a red lobster"));
        l.getRoom("closet").addItem(new Item("duck", "a mallard"));
        l.getRoom("bathroom").addItem(new Item("water bottle", "a green metallic water bottle"));

        return l;
    }

    private static void moveCreatures(ArrayList<Creature> creatures) {
        for (Creature c : creatures) {
            c.move();
        }
    }

    private static void displayOptions() {
        System.out.println("Type 'go <roomname>' to go to the room\nType 'look' to look around the room\n" +
                "Type 'add room <roomname>' to add a neighbor to your current room.\nType 'take <object>' to pick up an object" +
                "\nType 'drop <object> to drop an object\nType 'inventory' to display your inventory\nType 'quit' to quit");
    }

    private static void look(Player p) {
        System.out.println("You are in " + p.getCurrentRoom().getDescription());
        System.out.println("You can go to the " + p.getCurrentRoom().getNeighborNames());
        System.out.println("The items in this room are: " + p.getCurrentRoom().displayItems());
        System.out.println("The creatures in this room are " + p.getCurrentRoom().getCreatureNames());
    }

    private static boolean containsTwoBrackets(String response) {
        return response.indexOf("<") != -1 && response.indexOf(">") != -1 && response.indexOf("<") < response.indexOf(">");
    }

    private static String getInnerString(String response) {
        return response.substring(response.indexOf("<") + 1, response.indexOf(">"));
    }
}
