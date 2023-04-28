import java.util.ArrayList;

public class Accounts {
    private ArrayList<String> librarianUser;
    private ArrayList<String> librarianPass;
    private ArrayList<String> adminUser;
    private ArrayList<String> adminPass;

    public Accounts() {
        librarianUser = new ArrayList<>();
        librarianPass = new ArrayList<>();
        adminUser = new ArrayList<>();
        adminPass = new ArrayList<>();

        // Librarians Accounts
        // #1
        librarianUser.add("Librarian_01");
        librarianPass.add("LibOne");
        // #2
        librarianUser.add("Librarian_02");
        librarianPass.add("LibTwo");
        // #3
        librarianUser.add("Librarian_03");
        librarianPass.add("LibThree");
        
        // Admin Accounts
        // #1
        adminUser.add("Admin_01");
        adminPass.add("AdminOne");
        // #2
        adminUser.add("Admin_02");
        adminPass.add("AdminTwo");
        // #3
        adminUser.add("Admin_03");
        adminPass.add("AdminThree");
    }

    public ArrayList<String> getlibrarianUser() {
        return librarianUser;
    }

    public ArrayList<String> getlibrarianPass() {
        return librarianPass;
    }
    
    public ArrayList<String> getadminUser() {
        return adminUser;
    }

    public ArrayList<String> getadminPass() {
        return adminPass;
    }
}
