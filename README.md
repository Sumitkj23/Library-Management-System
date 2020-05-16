# Library-Management-System
Java Swing Project With JDBC

download some jar file
1. sqlite-jdbc-3.20.0.jar   // jdbc driver  
2. jCalendar-1.4.jar        // jDateChooser for 'issue book date' & 'return book date'
3. JTattoo-1.6.13.jar       // for attractive look and feel
4. rs2xml.jar               // for jtabel model or put the data from db to jTable directly

Add all these library add into project
----------------------------------------------------------------------------------------------------------------------
    
package & classes -:
    Account - Login.java (main function), Signup.java, Forgot.java
    Helper - javaConnect.java, Loading.java
    Action - Home.java, New_Book.java, Statistics.java, Student.java, Issue_Book.java, Return_Book.java, About.java     
-----------------------------------------------------------------------------------------------------------------------

Database info -:
    use sqlite database
    database name   :   library.sqlite
    path  :   src\\library.sqlite
----------------------------------------------------------------------------------------------------------------------

Database Table With Column Description -:
    'Account' : Username, Name, Password, Sec_Q, Answer
    'Book'  : Book_Id, Name, Edition, Publisher, Price
    'Student' : Student_Id, Name, Father_Name, Course, Branch, Year, Semester
    'Issue_book' : Book_Id, Name, Edition, Publisher, Price, Student_Id, S_Name, Father_Name, Course, Branch, Year, Semester, Issue_Date
    'Return_book' : Student_Id, S_Name, F_Name, Course, Branch, Year, Semester, Book_Id, B_Name, Edition, Publisher, Price, Return_Date
---------------------------------------------------------------------------------------------------------------------------------------

Class Description -:

    javaConnect.java  :   having static method 'ConnectDb' for establising connection with database 'library'
    
                                ------------------------------------------
    
    Login.java    :   having 3 button 'Login', 'Signup' and 'Forgot'
    
            Signup button call 'Signup.java'
    Signup.java   :   create user and all the information save into 'Account' tabel
    
            Forgot button call 'Forgot.java'
    Forgot.java   :   fetch userPassword by the help of Username & Security Answer from 'Account' tabel
    
            Login Button : fetch data from 'Account' tabel and check user exist or not, 
                          if user exist then open 'Loading.java'
                          
                              --------------------------------------------
    
    Loading.java  :   show an loader and opening book image icon
                      after that call 'Home.java'
                      
                              --------------------------------------------
                      
    Home.java   :   Open menu for 'New_Book', 'Statistics', 'Student', 'Issue_Book', 'Return_Book', 'About'
                    These all are jButton, by clicking on this button it perform operation as given name
                    
                              ----------------------------------------------
                    
            New_book Button calls 'New_Book.java'
    New_Book.java   :   Take new book information and add into 'Book' tabel
    
                              ------------------------------------------------
    
            Statistics Button calls 'Statistics.java'
    Statistics.java   :   There are two tabel for showing 'issue book' and 'return book' information
                            jTabel1 fetch all data from 'Isuue_Book' tabel
                            jTabel2 fetch all data from 'Return_Book' tabel
                            
                             -------------------------------------------------
                            
            Student Button calls 'Student.java'
    Student.java   :   Take data for add new student in library(entry data)
                        all the data save into 'Student' tabel
                 
                            --------------------------------------------------
                    
            Issue_Book Button call 'Issue_Book.java'
    Issue_Book.java   :   Enter here 'bookId' and 'studentId'
                          entering 'bookId' and click on search button  (fetch the data from 'New_Book' tabel)
                              if book exist in library then it will automatically fill all data into textfields
                          entering 'studentId' and click on search button (fetch the data from 'Student' tabel)
                              if student exist in library entry then it will automatically fill all data into textfields
                    If all data filled coorectly then all the data will store into 'Issue_Book' tabel
                        
                          ----------------------------------------------------         
                        
            Return_Book Button call 'Return_Book.java'
    Return_Book.java   :   Enter here 'studentId' for check this studentId's student have any issued book 
                           entering 'studentId' and click on search button  (fetch the data from 'Issue_Book' tabel)
                              if book issued then it will automatically field all data into textfields
                    If all data filled coorectly then all the data will store into 'Return_Book' tabel
                    
                            ---------------------------------------------------    
                    
            About button call 'About.java'
    About.java    :   open about me page...
    
    ------------------------------------------------------------------------------------------------------------------------------
    
                  If you like this project or helpful for you then you plese give an star to this project
                                                    Thankyou!!!
