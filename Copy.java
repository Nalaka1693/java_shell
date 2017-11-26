import java.io.*;

public class Copy extends GenericCommand { 

    /* Copy command 
     * copy destinationFileName sourceFileName 
     * two aregument, first the destination file second the source file
     */ 
    public void handleCommand(String [] args) { 

		if(!args[0].equals("copy")) someThingWrong(); 

		if(args.length != 3) { 
		    System.out.println("Usage: copy destFileName sourceFileName");
		    return;
		}

		String dstFileName = args[1];
		String srcFileName = args[2];
		try {
			FileReader readFD = new FileReader(srcFileName);
			BufferedReader readbuf = new BufferedReader(readFD);
			BufferedWriter outbuff = new BufferedWriter(new	FileWriter(dstFileName));
			String line = null;

			StringBuffer strbff = new StringBuffer();

			while( (line = readbuf.readLine()) != null) {
				strbff.append(line);					/*append each read line to the stringBuffer*/
				strbff.append(System.lineSeparator());	/*add ew line after a line*/
			}
			outbuff.write(strbff.toString());			/*write stringBuffer to the file*/
			outbuff.close();
			readbuf.close();
			commandCount++;

		} catch (FileNotFoundException x) {
			System.out.println("Make sure " + srcFileName + " is in file directory!");

		} catch (IOException x) {
			System.out.println(x);
		}
    }
}