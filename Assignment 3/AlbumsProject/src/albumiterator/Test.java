package albumiterator;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        AlbumComponent album2019 = new ListAlbum("Album of 2019");
        AlbumComponent album2020 = new ListAlbum("Album of 2020");
        AlbumComponent album2021 = new ArrayAlbum(4, "Album of 2021");
        AlbumComponent vacations2021 = new ListAlbum("2021 holiday album");
        
        AlbumComponent allAlbums = new ListAlbum("All albums");
        allAlbums.add(album2019);
        allAlbums.add(album2020);
        allAlbums.add(album2021);
        
        // ALBUM 2019
        album2019.add(new AlbumItem(
                "02-11-2019","Henry birthday"));
        album2019.add(new AlbumItem(
                "03-02-2019","Smith family reunion"));
        album2019.add(new AlbumItem(
                "05-17-2019","Henry and his friends, Thomas, Dave and Richard"));
        album2019.add(new AlbumItem(
                "07-21-2019","Smith family in San Diego, California"));
        
        // ALBUM 2020
        album2020.add(new AlbumItem(
                "01-27-2020","Henry and Thomas at Thomas's birthday"));
        album2020.add(new AlbumItem(
                "02-11-2020","Henry birthday"));
        album2020.add(new AlbumItem(
                "04-30-2020","Kiara Smith and Sherlyn Smith"));
        album2020.add(new AlbumItem(
                "06-05-2020","Smith family reunion"));
        album2020.add(new AlbumItem(
                "09-19-2020","Our dog, Andy"));
        album2020.add(new AlbumItem(
                "24-12-2020","The Smith and Brown family reunited for Christmas"));
        
        // ALBUM 2021
        album2021.add(new AlbumItem(
                "01-01-2021","Cristopher after celebrating new year"));
        album2021.add(new AlbumItem(
                "01-27-2021","Henry and his friends celebrating Thomas birthday"));
        album2021.add(new AlbumItem(
                "02-11-2021","Henry birthday with our dog Andy"));
        album2021.add(vacations2021);
        
        // ALBUM 2021 - SUB ALBUM 'VACATIONS'
        vacations2021.add(new AlbumItem(
                "03-10-2021","Arriving in New Orleans"));
        vacations2021.add(new AlbumItem(
                "03-11-2021","Visiting the National Museum of New Orleans"));
        vacations2021.add(new AlbumItem(
                "03-12-2021","In the Garden District of New Orleans"));
        vacations2021.add(new AlbumItem(
                "03-13-2021","The Smith family at the amazing Audubon Zoo of New Orleans!"));
        vacations2021.add(new AlbumItem(
                "03-14-2021","The city park of New Orleans"));
        vacations2021.add(new AlbumItem(
                "03-15-2021","The French Quarter of New Orleans"));
        
        
        // Printing albums
        Operator op = new Operator(allAlbums);
        System.out.println("+++++++++++++++++++++++");
	System.out.println("      All albums       ");
	System.out.println("+++++++++++++++++++++++");
        
        op.printAlbums();

        // Open the menu to search a photo
        menu(op);
    }
    
    /**
     * Principal menu
     * @param op 
     */
    private static void menu(Operator op){
        int option = 0;
        do{
            System.out.println("\n+++ MENU +++");
            System.out.println("\t> 1. Search for a photo");
            System.out.println("\t> 2. Exit");
            System.out.print("> Your option: ") ; option = sc.nextInt();
            
            switch(option){
                case 1:
                    submenu(op);
                    break;
                case 2:
                    break;
                default:
                    System.err.println("\n[!] Non-existent option\n");
                    break;
            }
            
        }while(option != 2);
    }
    
    /**
     * Menu to choose search filter
     * @param op 
     */
    private static void submenu(Operator op){
        int option2 = 0;
        
        System.out.println("\nInsert a search filter: ");
        System.out.println("\t> 1. By year");
        System.out.println("\t> 2. According to keyword");
        System.out.println("\t> 3. Back");
        System.out.print("> Your option: ");
        option2 = sc.nextInt();

        sc.nextLine(); // cleaning the scanner buffer

        switch (option2) {
            case 1:
                System.out.print("\n> Insert a year: ") ; String year = sc.nextLine();
                
                System.out.println("\nSEARCHING FOR \'"+year+"'...");
                sleep();
                System.out.println("+++ Results: ");
                
                op.printAlbumsByYear(year);
                break;
            case 2:
                System.out.print("\n> Insert a keyword (remember to respect upper and lower case): ") ; String word = sc.nextLine();
                
                System.out.println("\nSEARCHING FOR \'"+word+"'...");
                sleep();
                System.out.println("+++ Results: ");
                
                op.printAlbumsByWord(word);
                break;
            case 3:
                break;
            default:
                System.err.println("\n[!] Non-existent option\n");
                break;
        }
    }
    
    /**
     * Put the program to sleep to avoid combinations of messages
     * in the console
     */
    public static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
