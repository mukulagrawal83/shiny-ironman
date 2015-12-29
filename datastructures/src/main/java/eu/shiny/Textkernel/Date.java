package eu.shiny.Textkernel;


public class Date {

    private final int month;

    private final int day;

    private final int year;

    private static final int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public Date(int day, int month, int year) {
        validateYear(year);
        validateMonth(month);
        validateDay(day, month, year);

        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static int calculateDaysBetweenDates(Date date1, Date date2){
        int result = calculateDayofYear(date1) - calculateDayofYear(date2) ;

        return result < 0 ? -1* result : result;
    }

    private static int calculateDayofYear(Date date){
        int monthIndex = date.getMonth() -1;
        int result = 0;

        for(int i = 0; i < monthIndex; ++i){
            result = result + daysInMonths[i];
        }

        if(date.isLeapYear()){
            result++;
        }

        return result + date.getDay();
    }

    public int getMonth() {
        return month;
    }


    public int getDay() {
        return day;
    }

    public boolean isLeapYear(){
        return this.year % 4 ==0;
    }

    private void validateYear(int year) {
        if(year < 0){
            throw new IllegalArgumentException("illegal year");
        }
    }

    private void validateDay(int day, int month, int year) {
        if(day < 1 || day > 31){
            throw new IllegalArgumentException("illegal day");
        }

        if(month ==4 || month ==6 || month ==9 || month ==11){
            if(day > 30){
                throw new IllegalArgumentException("invalid number of days for this month of year");
            }
        }

        if(month == 2 ){
            if (year % 4 == 0 && day > 29){
                throw new IllegalArgumentException("invalid number of days for this month of year");
            }else if(day > 28){
                throw new IllegalArgumentException("invalid number of days for this month of year");
            }
        }

    }

    private void validateMonth(int month) {
        if(month < 1 || month > 12){
            throw new IllegalArgumentException("illegal month");
        }
    }

    public static void main(String[] args) {
        Date date1 = new Date(12, 1, 2000);
        Date date2 = new Date(20, 12, 2000);

        System.out.print(Date.calculateDaysBetweenDates(date1, date2));

    }
}
