import jdk.jshell.spi.ExecutionControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Window {
    private ArrayList<Project> projects = new ArrayList<>();

    private static Connection connectDb() {
        Connection cnct = null;
        try {
            String url = "jdbc:sqlite:db/vti2_base0.db";
            cnct = DriverManager.getConnection(url);
            System.out.println("Connection to database established!");

        } catch (SQLException e) {
            System.out.println("There was an error connecting to the database:");
            System.out.println(e.getMessage());
        }
        return cnct;
    }

    private static void closeConnection(Connection cnct) {
        if (cnct != null) {
            try {
                cnct.close();
            } catch (SQLException e) {
                System.out.println("There was an error closing the database:");
                System.out.println(e.getMessage());
            }
        }
    }

    private void readProjects() {
        // TODO: Read list of projects from a SQLite database
        String sqlstmt = "SELECT * FROM Projects";
        try (
                Connection conn = connectDb();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqlstmt)) {
            while (rs.next()) {
                assert this.projects != null;
                // TODO: Fix the above
                this.projects.add(new Project(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description")));
            }
            closeConnection(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        // Project[] projects = {new Project(0, "VTI2", new String[] {"cd 'C:\\!Library\\Rhys\\source\\VTI2"}, "Dev Tool Switcher")};
        // return projects;
    }

    public Window() {
        readProjects();
    }

    public void show() {
        for (Project project : this.projects) {
            System.out.printf("%d: %s \t %s\n", project.id, project.name, project.description);
        }
    }

    public void getUserCmd() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("implement this");
    }

}
