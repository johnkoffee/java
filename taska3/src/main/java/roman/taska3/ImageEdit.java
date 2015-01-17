package roman.taska3;

import java.io.*;
import org.imgscalr.Scalr;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class ImageEdit {
    private String fileName = "";
    private String outFileName = "";
    private Boolean autoWrite = false; //after any operation will be file saving
    
    BufferedImage src = null;
    
    private String GetExtension(String name){
        if (name.length() < 1) return "";
        String res = "";
        char[] chars = name.toCharArray();
        Integer i = name.length();
        char c = chars[i-- - 1];
        while( c != '.' && i != 0){
            res = c + res;
            c = chars[i-- - 1];
        }
        return res;
    }
    
    public ImageEdit(String fileName, String outFile, Boolean autoWrite) throws IOException{
        this.fileName = fileName;
        this.outFileName = outFile;
        this.autoWrite = autoWrite;
        ReadFile();
    }
    
    public static ImageEdit FileOnDisk(String inputFile, String outputFile) throws IOException{
        ImageEdit ie = new ImageEdit( inputFile, outputFile, true);
        return ie;
    }
    
    public ImageEdit Resize(Integer width, Integer height) throws IOException{
        //TODO: resize loaded image
        src = Scalr.resize(src, Scalr.Mode.AUTOMATIC, width, height);
        if (autoWrite){
            WriteFile();
        }
        return this;
    }
    
    public void WriteFile() throws IOException{
        //write output file
        if (src != null){
            File outputFile = new File(this.outFileName);
            ImageIO.write(src, GetExtension(outFileName), outputFile);
        }
    }
    
    public void ReadFile() throws IOException{
        //read input file
        File imgFile = new File(this.fileName);
        src = ImageIO.read(imgFile);
    }
    
    public void Release(){
        //clean the object
        src = null;
    }
}
