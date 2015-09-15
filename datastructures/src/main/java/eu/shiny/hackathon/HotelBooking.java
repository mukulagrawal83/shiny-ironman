package eu.shiny.hackathon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * Problem Statement

Destinations often have different type of accommodations and each one of them offers a different combination of facilities. 
Every traveler has a different set of requirements and constraints when preparing they trip and choosing where to stay. 
Some of them are business travelers, so they often look for more comfortable places to stay. 
Others travel with family and their ideal places offer some fun activities for the children.Travelers ask you to help them to find the perfect accommodation!
=================
Input Format

The first line contains an integer N, which indicates the number of hotels that follow. 
Each hotel is represented by a single line of space-separated values, where the first value is the hotel ID (integer), 
the second value is its average price (integer) and the other values are the facilities offered by the hotel (space-separated strings). 
Each hotel has at least one facility. This is followed by another line containing an integer M, that indicates the number of test cases that follows. 
Each test case is represented by a single line of space-separated values, where the first value is the maximum budget for the guest (integer) and the rest forms a 
list of the guest’s required facilities (space separated strings). Each test case has at least one facility.

Notes:

All integers are unsigned integers with values between 0 and 2^32.
All strings are 7-bit ASCII strings (this means they may contain no code above 127).
Assume that N < 100, M <100
Output Format

The output is precisely M lines, each one containing a space-separated list of hotel IDs. Each line will contain the IDs of the hotels that match up to the guest requirements, both in terms of price as well as facilities. The ID list should first be sorted in descending order by number of facilities. In case two hotels have the same number of facilities they should be sorted by price, starting with the cheapest. In case they have the same price, they should be sorted by ID starting with the smallest. If no hotel matches the requirements, a blank line should be produced.
==========================
Sample Input

4
1 70 wifi pool restaurant bathtub kitchenette
2 80 pool spa restaurant air-conditioning bathtub wifi
3 60 restaurant air-conditioning wifi
4 50 kitchenette
4
65 wifi
50 wifi
100 pool restaurant
80 kitchenette
===============
Sample Output

3

2 1
1 4
 *
 */
public class HotelBooking {
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int nos = Integer.parseInt(in.nextLine());
        List<Hotel> hotels = new ArrayList<HotelBooking.Hotel>();
        
        while(nos > 0){
            hotels.add(new Hotel(in.nextLine()));
            nos--;
        }
        
        int testcases = Integer.parseInt(in.nextLine());
        
        Match match = new Match();
        
        while(testcases > 0){
            Criteria criteria = new Criteria(in.nextLine());
            for(Hotel hotel : hotels){
                if(hotel.price <= criteria.price && hotel.containsAll(criteria.facillities)){
                    match.add(hotel);
                }
            }
            System.out.println(match);
            match.clear();
            testcases--;
        }
        
    }
    
    public static class Match {
        
        private List<Hotel> hotels = new ArrayList<HotelBooking.Hotel>();
        
        public void add(Hotel hotel){
            hotels.add(hotel);
        }
        
        @Override
        public String toString(){
            Collections.sort(hotels);
            StringBuffer buff = new StringBuffer();
            for(Hotel hotel : hotels){
                buff.append(hotel.id);
                buff.append(" ");
            }
            
            return buff.toString().trim();
        }
        
        public void clear(){
            hotels.clear();
        }
    }
    public static class Criteria{
        private final int price ;
        private final String[] facillities;
        
        public Criteria(String str){
            String[] arr = str.split(" ");
            this.price = Integer.parseInt(arr[0]);
            this.facillities = Arrays.copyOfRange(arr, 1, arr.length);
        }

        public int getPrice() {
            return price;
        }

        public String[] getFacillities() {
            return facillities;
        }
        
        
    }
    
    public static class Hotel implements Comparable<Hotel>{
        private final int id;
        private final int price;
        private final String[] facilities;
        
        public Hotel(String str){
            String[] hotel = str.split(" ");
            this.id = Integer.parseInt(hotel[0]);
            this.price = Integer.parseInt(hotel[1]);
            this.facilities = Arrays.copyOfRange(hotel, 2, hotel.length);
        }
        
        @Override   
        public int compareTo(Hotel hotel) {
            if(this.facilities.length != hotel.facilities.length) 
                    return hotel.facilities.length - this.facilities.length ;
            else if(this.price != hotel.price)
                return this.price - hotel.price;
            else
                return this.id - hotel.id;
        }
        
        public boolean containsAll(String[] facs){
            return Arrays.asList(facilities).containsAll(Arrays.asList(facs));
        }
        
        @Override
        public String toString(){
            return String.valueOf(this.id);
            }
        }
        
}

