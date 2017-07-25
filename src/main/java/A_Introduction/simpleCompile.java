package A_Introduction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qilianshan on 17/7/24.
 */
public class simpleCompile {
    public static void main(String[] args){

        compile("/Users/qilianshan/Documents/mySpace/javaExerciseSet/src/main/resources/compileExercise/main"
                , "/Users/qilianshan/Documents/mySpace/javaExerciseSet/src/main/resources/compileExercise/output");
    }

    public static Stack<String> pathNames=new Stack<String>();

    public static List<String> lines=new ArrayList<String>();

    public static void compile(String start,String output){
        readFile(start);
        try{
            Files.write(Paths.get(output),lines, Charset.forName("UTF-8"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void readFile(String pathName){
         try{
            BufferedReader br=new BufferedReader(new FileReader(pathName));
            for(String line;(line=br.readLine())!=null;){
                if(line.contains("#include")){
                    String subPath= (Paths.get(Paths.get(pathName).getParent().toString(), line.split(" ")[1])).toString();
                    if (!pathNames.contains(subPath)) {
                        pathNames.push(subPath);
                        readFile(subPath);
                    }
                }else{
                    lines.add(line);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
