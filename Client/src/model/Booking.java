package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Booking implements Serializable {
    private LocalDateTime localDateTime;
    private int bookingNumber;
    private String userName;


    public Booking(String userName,int bookingNumber){
        this.userName=userName;
        this.bookingNumber=bookingNumber;
    }
    public String getBookingNumber(){
        localDateTime=LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return "[" + dateFormatter.format(localDateTime) + "]" + " " + userName + ": " + bookingNumber;
    }
}

