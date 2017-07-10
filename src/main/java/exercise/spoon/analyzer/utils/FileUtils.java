package exercise.spoon.analyzer.utils;
import java.io.*;  


/**
 * File Utility to write a json file to the disk and rename the old one
 * 
 * This class contains an implicit public constructor
 * 
 * @author yehe
 *
 */
public class FileUtils { 
	
	/**
	 * Store the file to disk
	 * @param path
	 * @param json
	 * @param fileName
	 */
    public static void writeJson(String path,Object json,String fileName){
        BufferedWriter writer = null;
        File file = new File(path + fileName );
        //Create a new file if the file not exist
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write the file
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(writer != null){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("File has been created successfully!");
    }
    

	/**
	 * Rename the file
	 * 
	 * @param path
	 *            File path
	 * @param oldname
	 *            Old file name
	 * @param newname
	 *            New file name
	 */
	public static void renameFile(String path, String oldname, String newname) {
		if (!oldname.equals(newname)) {
			File oldfile = new File(path + "/" + oldname);
			File newfile = new File(path + "/" + newname);
			if (!oldfile.exists()) {
				return;// if the file is not exist, nth need to be done
			}
			if (newfile.exists())// 
				System.out.println(newname + "already exist！");
			else {
				oldfile.renameTo(newfile);
				System.out.println("Creat back up file successfully");
			}
		} else {
			System.out.println("New name is same with the old one...");
		}
	}
}