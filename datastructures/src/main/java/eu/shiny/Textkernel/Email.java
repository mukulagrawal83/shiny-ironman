package eu.shiny.Textkernel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Email implements Comparable<Email>{

    private final String email ;

    public static final String VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).pattern();

    public Email(String email) {
        this.email = email;
    }

    /**
     * @param src for example "C:\\testing.txt"
     * This method takes a text file as input and finds all email addresses within the text and then prints all
     * email addresses sorted and alphabetically ordered by domain name.*/
    public void printAllEmails(String src){
        List<Email> emails = new ArrayList<Email>();

        //reading of emails
        BufferedReader br = null;

        try {
            String sCurrentLine;
            br = new BufferedReader(new FileReader(src));
            while ((sCurrentLine = br.readLine()) != null) {
                String[] tokens = sCurrentLine.split(" ");
                for(String token: tokens){
                    if(VALID_EMAIL_ADDRESS_REGEX.matches(token)){
                        emails.add(new Email(token));
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //sorting of emails as per the domain names
        Collections.sort(emails);
        for(Email email : emails){
            System.out.println(email);
        }

    }


    public int compareTo(Email email) {
        return this.getDomainName().compareTo(email.getDomainName());
    }

    public String getDomainName(){
        return this.email.substring(this.email.indexOf("@") + 1, this.email.indexOf("."));
    }

    public String toString(){
        return this.email;
    }

    public static void main(String[] args) {
        Email email = new Email("xyz@abc.com");
        email.printAllEmails("C:\\Users\\e1065894\\docs\\testing.txt");
    }

}
