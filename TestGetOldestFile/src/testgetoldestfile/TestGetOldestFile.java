/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testgetoldestfile;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Shereef Sakr
 */
public class TestGetOldestFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis() ;
        
        File file = getOldestFile( "/media/sda5/TestDR") ;
        
        System.out.println( file.filename + " : " + file.lastModified );
        
        System.out.println( ( System.currentTimeMillis() -  startTime ) + " msecs" );
    }
    
    public static File getOldestFile(String fileDirectory) {

        java.io.File dir = new java.io.File(fileDirectory);
        FileFilter fileFilter = new FileFilter() {

            public boolean accept(java.io.File file) {
                return (file.getName().endsWith("txt") );
            }
        };
        java.io.File[] files = dir.listFiles(fileFilter);

        try {
            if (files != null && files.length != 0) {
                File[] files1 = sortFilesByLastModDate(convert(files));
                
                System.out.println( files1[0].filename + " : " + files1[0].lastModified );
                System.out.println( files1[1].filename + " : " + files1[1].lastModified);
                System.out.println( files1[2].filename + " : " + files1[2].lastModified);
                System.out.println( files1[3].filename + " : " + files1[3].lastModified);
                System.out.println( files1[4].filename + " : " + files1[4].lastModified);
                System.out.println( files1[5].filename + " : " + files1[5].lastModified);
                
                return files1[0];
            }

        } catch (Exception ex) {
            System.out.println( ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
    
    public static class File {

        public File( String filename , long lastModified ) {
            this.filename = filename ;
            this.lastModified = lastModified ;
        }
        
        String filename = null ;
        long lastModified = -1 ;
    }
    
    /**
     * Sorts an array of Files by the last modified date property; if the second
     * parameter is "desc", then sorting is done descending order, otherwise
     * it will be ascending.
     * @param fList : An array of Java "File" objects, not sorted
     * @return File[] : An array of Java "File" objects, sorted by last modified date
     * @author C. Peter Chen http://dev-notes.com
     * @date 20080527
     */
    public static File[] sortFilesByLastModDate(File[] fList) {
        //*
        Arrays.sort(fList, new Comparator<File>() {
            @Override
            public int compare(File file1, File file2) {

                return (int) (((File) file1).lastModified - ((File) file2).lastModified);

            }
        });
        //*/
        return fList;
    }
    
    public static File[] convert ( java.io.File[] file ) {
        ArrayList<File> files = new ArrayList<File> () ;
        
        for ( java.io.File myFile : file ) {
            files.add( new File ( myFile.getAbsolutePath() , myFile.lastModified() ) );
        }
        
        return ( files.toArray(new File[] {} ) ) ;
    }
}
