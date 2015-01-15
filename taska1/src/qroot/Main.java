package qroot;

public class Main {
    public static void main(String[] args) {
        int t = 3;
        String s = "";
        for (int a = -t; a <= t; a++){
            for (int b = -t; b <= t; b++){
                for (int c = -t; c <= t; c++){
                    s = a + "x^2 " + (b<0?"- "+Math.abs((double)b):"+ "+b) + "x "+ (c<0?"- "+Math.abs((double)c):"+ "+c) + " = 0";
                    try{
                        double[] xs = Mathematics.QuadraticEquation(a,b,c);
                        int i = 1;
                        for (double x : xs){
                            System.out.println( s + "\tx"+ i++ +" = "+ x );
                        }
                    }catch (Exception e){
                        System.out.println("ERROR:" + e);
                    }
                }
            }
        }
    }
}
