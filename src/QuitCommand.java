public class QuitCommand implements Command {
    @Override
    public void init(String userString) {

    }

    @Override
    public boolean execute() {
        System.exit(0);
        return true;
    }
}
