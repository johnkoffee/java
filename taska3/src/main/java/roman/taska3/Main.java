package roman.taska3;

import java.io.IOException;

public class Main {
    public static void main(String[] args){
        Integer arg_in = 0;
        Integer arg_out = 1;
        Integer arg_w = 2;
        Integer arg_h = 3;
        try{
            String input = args[arg_in];
            String output = args[arg_out];
            Integer width;
            Integer height;
            try{
                width = Integer.parseInt(args[arg_w]);
                height = Integer.parseInt(args[arg_h]);
            }catch(Exception ex0){
                width = 1000;
                height = 1000;
            }
            ImageEdit
                    .FileOnDisk(input, output)
                    .Resize(width, height)
                    .Release();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
