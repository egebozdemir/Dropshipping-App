import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileIO2 {
    private String path;
    private BufferedReader reader;
    private DynamicArray<StringTokenizer> tokens = new DynamicArray<>();;

    public FileIO2(String path) {
        this.tokens = tokens;
        this.path = path;
        try {
            reader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public DynamicArray<StringTokenizer> readLines() throws IOException {
        String line = null;
        reader.readLine();
        while ((line = reader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(line, ",");
            tokens.addItem(tokenizer);
        }

        return tokens;

    }
}
