package qroot;

public class HasNotSolutionException extends Exception {
    public HasNotSolutionException(String equation) {
        super("Equation " + equation + " has not solution.");
    }
}
