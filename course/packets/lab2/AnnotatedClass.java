package course.packets.lab2;

public class AnnotatedClass {
    @Repeat(3)
    public String publicMethod1(String message) {
        return("Public method 1: " + message);
    }

    public String publicMethod2(int number) {
        return("Public method 2: " + number);
    }

    @Repeat(2)
    public String publicMethod3(String message, int number) {
        return("Public method 3: " + message + ", " + number);
    }

    @Repeat(4)
    protected String protectedMethod1(String message) {
        return("Protected method 1: " + message);
    }

    protected String protectedMethod2(int number) {
        return("Protected method 2: " + number);
    }

    @Repeat(1)
    protected String protectedMethod3(String message, int number) {
        return("Protected method 3: " + message + ", " + number);
    }

    @Repeat(4)
    private String privateMethod1(String message) {
        return("Private method 1: " + message);
    }

    private String privateMethod2(int number) {
        return ("Private method 2: " + number);
    }

    @Repeat()
    private String  privateMethod3(String message, int number) {
        return("Private method 3: " + message + ", " + number);
    }
}