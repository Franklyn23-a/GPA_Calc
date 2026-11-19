
public class Person {

    private String name;
    private String email;

    // Constructor
    public Person(String name, String email) {
        setName(name);
        setEmail(email);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name is required.");
        }
        this.name = name;
    }

    public void setEmail(String email) {
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Enter a valid email.");
        }
        this.email = email;
    }

    // Method that can be overridden by Student
    public void introduce() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
