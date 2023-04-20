package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        File newDir = new File(dirPath);
        if (newDir.exists()){
            System.out.println(newDir + " directory already exists");            
        } else {
            newDir.mkdir();
        }

        File newFile = new File(dirPathFileName);
        if (!newFile.exists()){
            System.out.println(dirPathFileName + " file does not exist");
            System.exit(0);
        }

        FileReader fr = new FileReader(new File(dirPathFileName));
        BufferedReader br = new BufferedReader(fr);
        
        StringBuilder sbFileContent = new StringBuilder();
        String lineInput = "";

        while ((lineInput = br.readLine()) != null){
            sbFileContent.append(lineInput);
        }


        br.close();
        fr.close();

        System.out.println(sbFileContent);
        System.out.println("\n");

        System.out.println(sbFileContent.toString().toUpperCase() + "\n");

        String fileContent = sbFileContent.toString();
        fileContent = fileContent.replace('.', ' ');
        fileContent = fileContent.replace(',', ' ');

        fileContent = fileContent.replace('(', ' ');
        fileContent = fileContent.replace(')', ' ');
        fileContent = fileContent.replace('[', ' ');
        fileContent = fileContent.replace(']', ' ');
        fileContent = fileContent.replace('"', ' ');
        fileContent = fileContent.replace('?', ' ');
        fileContent = fileContent.replace('!', ' ');

        String [] fileContentArray = fileContent.split(" ");
        Map<String, Integer> words = new HashMap<>();

        for(String word: fileContentArray){
            Integer wordExists = words.get(word);
            
            if (wordExists == null){
                words.put(word, 1);
            } else {
                words.put(word, wordExists + 1);
            }

        }

        System.out.println(words + "\n");


    }
}
