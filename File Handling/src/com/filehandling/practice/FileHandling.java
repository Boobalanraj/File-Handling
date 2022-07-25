package com.filehandling.practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;

public class FileHandling {
	public File file;

	public File getfile() {
		return file;
	}
	
	//Create new file
	public File createFile(String fileName) {
		try {
			 file = new File(fileName);
			 if (file.exists()){
				 System.out.println(fileName +" Already Exist\n");
				 return(file);
			 }
			 file.createNewFile();
			 System.out.println(fileName + " created\n");
			 
		}
		catch (Exception message) {
			System.out.println(message.getMessage());
		}
		return file;
	}

	//Write given text in a file
	public boolean writeFile(String write) {
	FileWriter writer=null;
	try {
		writer = new FileWriter(file);
		writer.write(write);
		System.out.println("File Write Successfully\n");
		return true;
	}
	catch(IOException message) {
		System.out.println("Failed to write in file\n");
	}
	catch(NullPointerException e) {
		System.out.println("File not exist\n");
	}
	finally {
		try {
			if(writer != null){
				writer.close();
			}
		}catch(Exception message) {
			message.printStackTrace();
		}
	}
	return false;
}
	
	//read text inside the file
	public void readFile(String fileName) {
		try {
			file = new File(fileName);
			Scanner read = new Scanner(file);
			while(read.hasNextLine()) {
				String data = read.nextLine();
				System.out.println(data);
				System.out.println("\nFile read Successfully\n");
			}
		}
		catch(Exception e) {
			System.out.println("Error: "+e);
		}
	}
	
	public void appendFile(String write,String path) {
		FileWriter read;
		PrintWriter printwriter;
		try {
			read = new FileWriter(path, true);
			printwriter = new PrintWriter(read);
			printwriter.println(write);
			printwriter.close();
			System.out.println("Append successfully\n");
		}
		catch(IOException message) {
			System.out.println("Error Occured: "+message);
		}
	}
	public static void main(String[] args) {
		String filename= "File Handling.txt";
		Path path=FileSystems.getDefault().getPath(filename).toAbsolutePath();
		System.out.println(path+"\n");
		FileHandling fileHandle = new FileHandling();
		
		System.out.println("Start File Handling\n");
		File file = fileHandle.createFile("File Handling.txt");
		
		fileHandle.writeFile("Welcome to File Handle");
		
		fileHandle.readFile("File Handling.txt");
		
		System.out.println("End of File Handling\n");
		
		System.out.println("Welcome to the Append tool in File Handling\n");
	
		fileHandle.appendFile(" Program..!",path.toString());
		
		fileHandle.readFile("File Handling.txt");
	}
}

