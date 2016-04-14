//  Assignment #     : 6
//  Name             : Arun Das (Teaching Assistant)
//  StudentID        : XXXXXXXXXX
//  Lecture          : T TH 12:00-1:15 PM
//  Arizona State University CSE205
//  Description: The ReviewPanel class contains the elements necessary to 
//				 submit reviews for a created Book. The reviews get updated
//				 and reported once the user submits a review for a Book.

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;

public class ReviewPanel extends JPanel
 {
     private JList <Book>list;
     private JLabel title;
     private JRadioButton radio1, radio2, radio3, radio4, radio5;
     private JButton submit;
     private int review = 0;
     private Book selectedBook;
     private ButtonGroup bg;
     //Constructor initializes each component and arranges them
     
   public ReviewPanel(Vector<Book> bookList)
     {
	     setLayout(new BorderLayout());
	     
         title = new JLabel("Choose a book to give a review, and select a rating:");
         add(title, BorderLayout.PAGE_START);
         
         //create new Jlist
         list = new JList<Book>(bookList);         
         JScrollPane listScrollPane = new JScrollPane(list);
         add(listScrollPane, BorderLayout.CENTER);
         
         //create five radio buttons and add them to one group
         JPanel radioPanel = new JPanel();
         radioPanel.setLayout(new GridLayout(1, 5));
         radio1 = new JRadioButton("1 Poor");
         radio2 = new JRadioButton("2 Fair");
         radio3 = new JRadioButton("3 Average");
         radio4 = new JRadioButton("4 Good");
         radio5 = new JRadioButton("5 Excellent");
         bg = new ButtonGroup();
         bg.add(radio1);
         bg.add(radio2);
         bg.add(radio3);
         bg.add(radio4);
         bg.add(radio5);
         
         //set a rating listener to each radio button
         radio1.addActionListener(new RatingListener());
         radio2.addActionListener(new RatingListener());
         radio3.addActionListener(new RatingListener());
         radio4.addActionListener(new RatingListener());
         radio5.addActionListener(new RatingListener());
         radioPanel.add(radio1);
         radioPanel.add(radio2);
         radioPanel.add(radio3);
         radioPanel.add(radio4);
         radioPanel.add(radio5);
         
         JPanel boxPanel = new JPanel();	   	 
	   	 boxPanel.setLayout(new GridLayout(4, 1));
         boxPanel.add(radioPanel);
         
         //create the submit button
         submit = new JButton("Submit Review");
                  
         boxPanel.add(submit);
         submit.addActionListener(new ButtonListener());
         add(boxPanel, BorderLayout.PAGE_END);         
     }

 //This method  refreshes the JList with
 //updated vector information
 public void updateBookList()
  {
      //call updateUI() for the JList object
      list.updateUI();
  }


 //RatingListener class listens to see the radio buttons
 //to keep track of a chosen rating for a book.
 private class RatingListener implements ActionListener
     {
         public void actionPerformed(ActionEvent event)
         {
             //check which radio button is selected
            if(radio1.isSelected()){
                review = 1;
            }else if(radio2.isSelected()){
                review = 2;
            }else if(radio3.isSelected()){
                review = 3;
            }else if(radio4.isSelected()){
                review = 4;
            }else if(radio5.isSelected()){
                review = 5;
            }
            
         }
     }



 //ButtonListener class listens to see the button "Submit Review" is pushed.
 //A user can choose which book to give a rating/review, and that will update the
 //average rating of such book.
 private class ButtonListener implements ActionListener
  {
       public void actionPerformed(ActionEvent event)
        {
    	   // error checking
    	   if (list.getSelectedValue() == null)	// if no books are selected from the JList
    		   return;
    	   
    	   // if no rating is selected from the radio buttons 
    	   // This checks for review == 0 as review is set to 0 only at the start of the program, 
    	   // once this value is changed based on a user's rating, the user cannot set it back to 0    	   
    	   if (review == 0)	
    		   return;
    	   
          //get the rating from radio buttons and
          //update the average rating and the number of reviews
          //for the chosen book in the JList.
    	   
    	   
    	    selectedBook = (Book)list.getSelectedValue();
            selectedBook.addRating(review);
            updateBookList();
        }
  } //end of ButtonListener class

} //end of ReviewPanel class