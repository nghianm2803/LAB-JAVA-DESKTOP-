package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.DefaultListModel;

/**
 *
 * @author Nghia
 */
public class Controller {

    /**
     * List all files from a folder
     *
     * @param path: the path of the folder
     * @return: all files in the folder
     */
    public DefaultListModel listFiles(String path) {
        DefaultListModel dlm = new DefaultListModel();
        File folder = new File(path);
        File[] files = folder.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                dlm.addElement(f.getName());
            }
        }

        return dlm;
    }

    /**
     * Read a file (Open file)
     *
     * @param path: the path of the file
     * @return: the content of the file Su dung stringBuilder
     */
    public String readFile(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }

    /**
     * Write a file (Update file)
     *
     * @param path: the path of the file
     * @param content: the content of the file
     */
    public void writeFile(String path, String content) {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
        }
    }

    /**
     * Delete a file
     *
     * @param path: the path of the file
     */
    public void deleteFile(String path) {
        File f = new File(path);
        f.delete();
    }
}
