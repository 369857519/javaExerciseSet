package A_Introduction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

/**
 * Created by qilianshan on 17/7/24.
 */
public class simpleCompile {
    public static void main(String[] args){

        readFile("/Users/qilianshan/Documents/mySpace/javaExerciseSet/src/main/resources/compileExercise/main");
    }

    public static Stack<String> pathNames=new Stack<String>();
    public static void readFile(String pathName){
        try{
            BufferedReader br=new BufferedReader(new FileReader(pathName));
            for(String line;(line=br.readLine())!=null;){
                if(line.contains("#include")){
                    String subPath=line.split(" ")[1];
                    if (!pathNames.contains(subPath)) {
                        readFile(subPath);
                    }
                    pathNames.push(subPath);
                }
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
