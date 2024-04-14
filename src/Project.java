public class Project {
    public int id;
    public String name;
    private String[] commands;
    public String description;

    public Project(int id, String name, String[] cmds, String desc) {
        this.id = id;
        this.name = name;
        this.commands = cmds;
        this.description = desc;
    }

    public Project(int id, String name, String desc) {
        // Remove later once database integration is more fleshed out
        this.id = id;
        this.name = name;
        this.description = desc;
    }

    public void launch() {
        for (int i = 0; i < this.commands.length; i++) {
            // TODO: Run each command on the system
        }
    }
}
