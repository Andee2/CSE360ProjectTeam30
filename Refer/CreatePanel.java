//  Assignment #     : 6
//  Name             : Arun Das (Teaching Assistant)
//  StudentID        : XXXXXXXXXX
//  Lecture          : T TH 12:00-1:15 PM
//  Arizona State University CSE205
//  Description: The CreatePanel class contains the elements necessary to 
//				 create a Book entry (Title and prublisher) and add it to 
//				 the list of Books.

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class CreatePanel extends JPanel
 {
   //vector contains all books
   private Vector<Book> bookList;
   
   //submit button
   private JButton button1;
   
   //review panel
   private ReviewPanel rPanel;
   
   //two labels besides textfeilds
   private JLabel bookTitle;
   private JLabel publisher;
   
   //notification message
   private JLabel message;
   
   //title text
   private JTextField titleText;
   //publisher text
   private JTextField publishText;
   //display area
   private JTextArea BookInfo;
   
   //scroll panel for display area
   private JScrollPane scroll;
 //Constructor initializes components and organize them using certain layouts
 public CreatePanel(Vector<Book> bookList, ReviewPanel rPanel)
  {
    this.bookList = bookList;
    this.rPanel = rPanel;
    
    //organize components here
    //set layout 
    setLayout(new BorderLayout());
    
    JPanel fieldPanel = new JPanel();
    fieldPanel.setLayout(new GridLayout(2, 2));    
    //create two labels
    bookTitle = new JLabel("Book Title");
    publisher = new JLabel("Publisher");
    titleText = new JTextField();    
    publishText = new JTextField();
    
    fieldPanel.add(bookTitle);
    fieldPanel.add(titleText);    
    fieldPanel.add(publisher);
    fieldPanel.add(publishText);   
    
    
    JPanel leftPanel = new JPanel();
    leftPanel.setLayout(new GridLayout(3, 1));
    message = new JLabel("");   
    message.setForeground(Color.red);
    
    leftPanel.add(message);
    
    leftPanel.add(fieldPanel);
    
    JPanel buttonPanel = new JPanel();
    button1 = new JButton("Create a book");    
    button1.addActionListener(new ButtonListener());    
    buttonPanel.add(button1);
    leftPanel.add(buttonPanel);    
    
    leftPanel.setPreferredSize(new Dimension(200, 0));
    add(leftPanel, BorderLayout.LINE_START);
    
    
    BookInfo = new JTextArea("No Book");
    scroll = new JScrollPane(BookInfo);    
    add(scroll, BorderLayout.CENTER);     
  }


  //ButtonListener is a listener class that listens to
  //see if the button "Create a book" is pushed.
  //When the event occurs, it adds a book's information from
  //the text fields to the text area. It also creates a Book object
  //using these two pieces of information and adds it to the bookList.
  //It also does some error checking.
  private class ButtonListener implements ActionListener
   {
      @Override
    public void actionPerformed(ActionEvent event)
     {
       // if there is no error, add a book to book list
       // otherwise, show an error message
         
         Book book = new Book();
         book.setTitle(titleText.getText());
         book.setPublisher(publishText.getText());
         
         //check if one area is empty
         if(book.getTitle().isEmpty()||book.getPublisher().isEmpty()){
             message.setText("Please fill both title and publisher");
         }
         else{

             if(bookList.isEmpty()) {
                 BookInfo.setText("");
                       
             }
             //adding the book to booklist
             bookList.add(book);
             BookInfo.append(book.toString());
             message.setText("Book added.");             
             titleText.setText("");
             publishText.setText("");
             //update review panel
             rPanel.updateBookList();
         }
         
         
     } //end of actionPerformed method
  } //end of ButtonListener class

} //end of CreatePanel class