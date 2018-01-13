
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class NoteManager {
    public static ArrayList<String> getNotes(String notesLocation){
        ArrayList<String> notes = new ArrayList<>();
        File folder = new File(notesLocation);
        File[] files = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File fileName) {
                return fileName.getName().endsWith(".note");
            }
        });
        for(File file : files){
            notes.add(file.getName());
        }
        return notes;
    }
    
    public static String loadNote(String notesLocation, String fileName){
        File file = new File(notesLocation, fileName);
        if(!file.exists()){
            return "";
        }
        String content = "";
        try(FileReader reader = new FileReader(file)){
            char[] arr = new char[(int)file.length()];
            reader.read(arr);
            content = new String(arr);
        }catch(Exception ex){
            
        }
        return content;
    }

    public static void saveNote(String notesLocation, String fileName, String content) {
        File file = new File(notesLocation, fileName);
        try(FileWriter writer = new FileWriter(file)){
            char[] data = content.toCharArray();
            writer.write(data);
        }catch(Exception ex){}
    }

    public static void deleteNote(String notesLocation, String fileName) {
        File file = new File(notesLocation, fileName);
        if(file.exists()){
            file.delete();
        }
    }
}
