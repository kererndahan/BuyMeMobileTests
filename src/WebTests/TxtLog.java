package WebTests;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.reporters.jq.BasePanel.C;

public class TxtLog {
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();
        public void write(String string,String FilePath) {
            String date = dtf.format(now);
            try {
                File f = new File(FilePath);
                //Second param for FileWrite is append - true means it will concat the text at the end of the file
                FileWriter fileWriter = new  FileWriter(FilePath, true);
                BufferedWriter bWriter = new BufferedWriter(fileWriter);

                f.createNewFile();
                f.canWrite();
                bWriter.newLine();
                bWriter.write(date+ "  " + string );
                bWriter.newLine();
                bWriter.close();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public String read(String FilePath) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            String everything = sb.toString();
            return everything;
        }
}
}
