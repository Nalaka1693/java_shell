import java.io.*;

public class Less extends GenericCommand { 

    /* Less command 
     * less fileName.extn 
     * one aregument, the file name you want to read
     */ 
    public void handleCommand(String [] args) { 

		if(!args[0].equals("less")) someThingWrong(); 

		if(args.length != 2) { 
		    System.out.println("Usage: less fileName.extension");
		    return;
		}

		String fileName = args[1];
		try {
			FileReader fileRd = new FileReader(fileName);
			BufferedReader bufferRd = new BufferedReader(fileRd);
			String line = null;

			while( (line = bufferRd.readLine()) != null) {
				System.out.println(line);
			}			
			bufferRd.close();
			fileRd.close();
			commandCount++;

		} catch (FileNotFoundException x) {
			System.out.println("Make sure " + fileName + " is in file directory!");

		} catch (IOException x) {
			System.out.println(x);
		}
    }
}