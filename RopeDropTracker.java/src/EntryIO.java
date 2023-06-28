/* Imports. */
import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;

public class EntryIO {

    /* This sets the file name and creates the file. */
    final private static String FILE_NAME = "ropeDrop.csv";
    private static File file = new File(FILE_NAME);

    /* This inserts the entered data into the file. */
    public static void insert(ArrayList<Entry> entries) throws IOException{
        FileWriter output = null;

        /* Begin if/else statement to create a new file based on if one exists or not. */
        if (file.exists()){
            output = new FileWriter(FILE_NAME, true);
        }
        else {
            output = new FileWriter(FILE_NAME);
            CSVWriter writer = new CSVWriter(output);

            /* This creates the header row. */
            String[] headers = {"First Name", "Last Name", "Course", "Grade" };
            writer.writeNext(headers);
        }
        /* This records the student data fields for every student. It uses commas to delimit the columns. It also adds a split to separate student entries so we can have multiple entries in the file and display them accordingly.  */
        for (Entry entry: entries){
            output.write("" + entry.getHarnessID() + ",");
            output.write("" + entry.getHarnessCount() + ",");
            output.write("" + entry.getCarabinerCount() + ",");
            output.write("" + entry.getSRCount() + ",");
            output.write("" + entry.getQRCount() + ",");
            output.write("" + entry.getIndyName() + ",");
            output.write("" + entry.getIndyWeight() + ",");
            output.write("" + entry.getDropDistance() + ",");
            output.write("" + entry.getTechName() + ",");
            output.write("" + entry.getTemp() + ",");
            output.write("" + entry.getHumidity() + ",");
            output.write(System.lineSeparator()); 
        }
        /* This closes the output stream. */
        output.close();
    }

    /* This finds all the students and sets those data fields. */
    public static ArrayList<Entry> findAll() throws IOException{
        Scanner input = new Scanner(new File(FILE_NAME));
        ArrayList<Entry> entries = new ArrayList<>();

        boolean isHeader = true;

        /* This while loop iterates through the students and returns them to the program. */
        while (input.hasNext()){
            /* This helps ignore the header. */
            if (isHeader){
                input.nextLine();
                isHeader = false;
                continue;
            }

            /* This helps split the students up by commas and display them according to the entries in the column based on the index in a list. 
            This change was based on peer review of Joseph Polen's and Joshua Bollman's projects. 
            It made more sense to use a list format and set items that way that using input.next() in my eyes. Especially because I used this with the header row. */
            String entryLine = input.nextLine();
            String[] ropeDropEntry = entryLine.split(",");
            if (ropeDropEntry.length > 0){ 
                Entry entry = new Entry();
                entry.setHarnessID(ropeDropEntry[0]);
                entry.setHarnessCount(ropeDropEntry[1]);
                entry.setCarabinerCount(ropeDropEntry[2]);
                entry.setSRCount(ropeDropEntry[3]);
                entry.setQRCount(ropeDropEntry[4]);
                entry.setIndyName(ropeDropEntry[5]);
                entry.setIndyWeight(ropeDropEntry[6]);
                entry.setDropDistance(ropeDropEntry[7]);
                entry.setTechName(ropeDropEntry[8]);
                entry.setTemp(ropeDropEntry[9]);
                entry.setHumidity(ropeDropEntry[10]);
                entries.add(entry);
            }
        }
        input.close();
        return entries;
    }
} /* End Student IO Class. */

