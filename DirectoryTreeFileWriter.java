import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *Given the name of a directory as a command line argument,
 *this program outputs that directory's subdirectories in a
 *tree format, into a text file called dir_tree.txt.
 *
 *@version 1.0 20 Nov 2017
 *@author Andrea Dewhirst
 */
public class DirectoryTreeFileWriter {

	/**
	 *Takes the name of a directory from the command line and
	 *attempts to write the directory's subdirectory tree into
	 *dir_tree.txt.
	 *
	 *@param args name of directory whose subdirectories will be output
	 */
	public static void main(String[] args) {
		String filename = args[0];
		File f = new File(filename);
		try {
		   Writer w = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("dir_tree.txt"), "utf-8"));
		   outputTree(f,0,w);
		} catch(Exception e){
		   System.out.println("Failed to create file.");
		}
		//https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
	}

	/**
	 *Formats and outputs the directory tree.
	 *
	 *@param f the file being parsed
	 *@param indent the amount of space before each branch
	 *@param writer the file output stream of @f
	 */
	public static void outputTree(File f, int indent, Writer writer) {
		ArrayList<File> dirs = new ArrayList<File>(getDirectoriesOnly(f));
		if(dirs.isEmpty()) return;
		try{
		  for(int i=0; i<dirs.size(); i++) {
		     for(int j=0; j<indent; j++) {
			writer.write("|   ");
		     }
		     writer.write("└---" + dirs.get(i).toString().replaceAll(f.toString(),"") + "\n");
		     outputTree(dirs.get(i), indent+1, writer);
		  }
		     writer.flush();
		} catch(Exception e){
		     System.out.println(e);
		}
		
	}

	/**
	 *Selects only the directories from the files in @f.
	 *
	 *@param f the file to be parsed
	 *@return directoriesOnly ArrayList containing only directory files
	 */
	public static ArrayList<File> getDirectoriesOnly(File f) {
		ArrayList<File> allFiles = new ArrayList<File>(Arrays.asList(f.listFiles()));
		ArrayList<File> directoriesOnly = new ArrayList<File>();
		for(int i=0; i<allFiles.size(); i++)
			if(allFiles.get(i).isDirectory()) directoriesOnly.add(allFiles.get(i));
		return directoriesOnly;
	}
}
		
