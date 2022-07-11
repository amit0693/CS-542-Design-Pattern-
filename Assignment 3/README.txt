Name-	Amit Pandit
Email-  apandit1@binghamton.edu


Name-	Manikya Pandey
Email-  mpandey2@binghamton.edu




The 'Test.java' class is in charge of executing the main method, through which photo albums and photo, albums with sub menus can be added.

The program displays all menus and all their photos at startup with the 'printAlbums()' method which now prints all album objects by implementing the Visitor class.

Subsequently, the user is allowed to search for a photo or exit the program, in case the user decides to search for a photo, You will be prompted for a search filter (search by year, or search by keyword).

After entering the search keyword or the year, all the resulting photos will be displayed regardless of the album that contains them through the printAlbumByYear(String) or printAlbumByWord(String) methods that are responsible for going through the albums looking for matches by implementing the Visitor class