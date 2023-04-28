/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package search_func;
import java.util.Scanner;
/**
 *
 * @author willbarnes
 */
public class search {
    
    
    
    public void doSearch() {
         String topics[] = {
        "Geography",
        "Astronomy",
        "History",
        "Biology",
        "Chemistry",
        "History",
        "Geography",
        "Food",
        "Biology",
        "History"
    };
    
    String questions[] = {
        "What is the capital city of Brazil?",
        "How many planets are there in our solar system?",
        "Who was the first person to set foot on the Moon?",
        "What is the largest mammal on Earth?",
        "What is the chemical symbol for gold?",
        "Who painted the famous artwork \"Starry Night\"?",
        "What is the tallest mountain in the world?",
        "What is the main ingredient in hummus?",
        "What is the largest organ in the human body?",
        "Who wrote the play \"Romeo and Juliet\"?"
    };
    
    String answers[] = {
        "Brasília.",
        "There are eight planets in our solar system: Mercury, Venus, Earth, Mars, Jupiter, Saturn, Uranus, and Neptune.",
        "Neil Armstrong, on July 20, 1969, during the Apollo 11 mission.",
        "The blue whale, which can grow up to 100 feet in length and weigh as much as 200 tons.",
        "Au.",
        "Vincent van Gogh.",
        "Mount Everest, located in the Himalayas between Nepal and China, with a peak that reaches 29,029 feet (8,848 meters) above sea level.",
        "Chickpeas (also known as garbanzo beans).",
        "The skin.",
        "William Shakespeare."
    };
    
        Scanner sc = new Scanner(System.in);
        boolean matchFound = false;
        
        System.out.print("enter search: ");
        String query = sc.next();
        System.out.println("");
        
        for (String str : topics) {
            if (str.toLowerCase().contains(query.toLowerCase())) {
                
                System.out.println("found in topics: " + str);
                
                
            }
        }
        
            for (String str : questions) {
                if (str.toLowerCase().contains(query.toLowerCase())) {
                    
                    System.out.println("found in questions: "  + str);
                }
            }
        
        
            for (String str : answers) {
                if (str.toLowerCase().contains(query.toLowerCase())) {
                    System.out.println("found in answers: "  + str);
                    
                }
            }
        
    }    
}
