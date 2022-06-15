import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String COMMENT_PATTERN = "//.*|(\"(?:\\\\[^\"]|\\\\\"|.)*?\")|(?s)/\\*.*?\\*/";

    private static final Pattern pattern = Pattern.compile(COMMENT_PATTERN);

    public static void main(String[] args) {

        try {
            File file = new File("editedCode.txt");
            file.createNewFile();

            FileReader fileReader = new FileReader("code.txt");
            FileWriter fileWriter = new FileWriter("editedCode.txt");

            int n = 0;
            String text = "";
            while((n = fileReader.read()) != -1){
                text += (char)n;
            }

            String c = text.replaceAll(COMMENT_PATTERN, "$1 ");

            fileWriter.write(c);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}