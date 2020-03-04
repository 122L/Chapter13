package youDoIt;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class CreateFilesBasedOnState {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Path inStateFile = Paths.get("C:\\Users\\og153182\\Desktop\\Java\\Chapter13\\src\\youDoIt\\InStateCusts.txt");
        Path outOfStateFile = Paths.get("C:\\Users\\og153182\\Desktop\\Java\\Chapter13\\src\\youDoIt\\OutOfStateCusts.txt");
        final String ID_FORMAT = "000";
        final String NAME_FORMAT = "    ";
        final int NAME_LENGTH = NAME_FORMAT.length();
        final String HOME_STATE = "IA";
        final String BALANCE_FORMAT = "0000.00";
        String delimiter = ",";
        String s = ID_FORMAT + delimiter + NAME_FORMAT + delimiter + HOME_STATE + delimiter + BALANCE_FORMAT +
                System.getProperty("line.separator");
        final int RECSIZE = s.length();
        FileChannel fcIn = null;
        FileChannel fcOut = null;
        String idString;
        int id;
        String name;
        String state;
        double Balance;
        final String QUIT = "999";
        createEmptyFile(inStateFile, s);
        createEmptyFile(outOfStateFile, s);
        try {
            fcIn = (FileChannel)Files.newByteChannel(inStateFile, CREATE, WRITE);
            fcOut = (FileChannel)Files.newByteChannel(outOfStateFile, CREATE, WRITE);
            System.out.println("Enter customer account number >>> ");
            idString = input.nextLine();
            while (!(idString.equals(QUIT))) {
                id = Integer.parseInt(idString);
                System.out.println("Enter name for customer >>> ");
                name = input.nextLine();
                StringBuilder sb = new StringBuilder(name);
                sb.setLength(NAME_LENGTH);
                name = sb.toString();
                System.out.println("Enter a state >>> ");
                state = input.nextLine();
            }
        }
        catch (Exception e) {
            System.out.println("Error message: " + e);
        }
    }
    public static void createEmptyFile(Path file, String s) {
        final int NUMRECS = 1000;
        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
            for(int count = 0; count < NUMRECS; ++count) {
                writer.write(s,0,s.length());
            }
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error message: " + e);
        }
    }
}
