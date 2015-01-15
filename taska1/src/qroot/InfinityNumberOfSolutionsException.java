package qroot;

public class InfinityNumberOfSolutionsException extends Exception {
    public InfinityNumberOfSolutionsException(String equation) {
        super("Equation " + equation + " has infinity number of solutions.");
    }
}
