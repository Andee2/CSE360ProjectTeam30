//  Assignment #     : 6
//  Name             : Arun Das (Teaching Assistant)
//  StudentID        : XXXXXXXXXX
//  Lecture          : T TH 12:00-1:15 PM
//  Arizona State University CSE205
//  Description: The class Review represent reviews of a book.

import java.text.DecimalFormat;

public class Review
 {
   private int numberOfReviews;
   private double sumOfRatings;
   private double average;

   //Constructor to initialize all member variables
   public Review()
    {
     numberOfReviews = 0;
     sumOfRatings = 0.0;
     average = 0.0;
    }

   //The updateRating takes a new rating as its parameter
   //and update its number of reviews, sum of ratings, and average.
   public void updateRating(double rating)
    {
      numberOfReviews++;
      sumOfRatings += rating;
      if (numberOfReviews > 0)
       {
        average = sumOfRatings/numberOfReviews;
       }
      else
        average = 0.0;
    }

   //toString() method returns a string containg its review average
   //and te number of Reviews
   public String toString()
    {
      DecimalFormat fmt = new DecimalFormat("0.00");
      String result = "Reviews:\t" + fmt.format(average) + "("
                    + numberOfReviews + ")";
      return result;
     }
  }