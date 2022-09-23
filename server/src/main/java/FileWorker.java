import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;

public class FileWorker {

    public static String getRandomLine() {
        String line = "";
        File f = new File("strings.txt");
        if(!f.exists() || f.isDirectory()) {
            try{
                File file = new File("strings.txt");
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            List<String> lines = Files.readAllLines(Path.of("strings.txt"), StandardCharsets.UTF_8);
            line = lines.get(new Random().nextInt(lines.size()));
        }catch (IOException e){
            e.printStackTrace();
        }



        return line;
    }
}
