import org.jetbrains.annotations.NotNull;
import java.text.DecimalFormat;


public class MyDate {

    private int month;
    private int day;
    private int year;
    private final int bdayMonth = 8;
    private final int bdayDay = 13;

    public MyDate() {
        this.month = 10;
        this.day = 12;
        this.year = 2020;
    }

    public MyDate(int month, int day, int year) {

        if(isDateValid(month,day,year)){
            this.month = month;
            this.day = day;
            this.year = year;;
        }
        else{
            this.month = 10;
            this.day = 12;
            this.year = 2020;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if(isDateValid(month,day,year)){
            this.month = month;
        }
        else{
            System.out.println("Invalid Month");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(isDateValid(month,day,year)){
            this.day = day;
        }
        else{
            System.out.println("Invalid Day");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(isDateValid(month,day,year)){
            this.year = year;
        }
        else{
            System.out.println("Invalid Year");
        }
    }

    public void setDate(int m, int d, int y) {

        if(isDateValid(m,d,y)){
            this.month = m;
            this.day = d;
            this.year = y;
        }
        else {
            System.out.println("Invalid Month");
        }
    }

    public String toString() {
        return month + "/" + day + "/" + year;
    }


    public boolean isMyBirthday() {
        if (month == bdayMonth && day == bdayDay) {
            return true;
        }
        else {
            return false;
        }
    }

    public MyDate(String date) {

            String[] arrDate = date.split("/");

                int m = Integer.parseInt(arrDate[0]);
                int d = Integer.parseInt(arrDate[1]);
                int y = Integer.parseInt(arrDate[2]);

            if(isDateValid(m,d,y)){
                month = m;
                day = d;
                year = y;
            }
            else{
                this.month = 10;
                this.day = 12;
                this.year = 2020;
            }
    }

    public boolean isLeapYear(int y) {

        if (y % 4 == 0) {
            if (y % 100 == 0) {
                if (y % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private int getLastDayOfMonth(int m, int y) {

        int d = 0;

        if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            d = 31;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            d = 30;
        } else if (m == 2) {
            if (isLeapYear(y)) {
                d = 29;
            } else {
                d = 28;
            }
        }
        return d;
    }

    private boolean isDateValid(int m, int d, int y) {

        boolean monthValid = false;;
        boolean dayValid = false;;
        boolean yearValid = false;
        boolean isDateValid = false;

        if (y > 0) {
            yearValid = true;

            if (m > 0 && m < 13) {
                monthValid = true;

                if (d > 0 && d <= getLastDayOfMonth(m, y)) {
                    dayValid = true;
                }
            }
        }
        if (yearValid && monthValid && dayValid) {
            isDateValid = true;
        }
        return isDateValid;
    }

    public String toString(int format) {

        DecimalFormat df = new DecimalFormat("00");

        String[] monthDesc = {"", "Jan" , "Feb" , "Mar",
                                "Apr" , "May" , "Jun" , "Jul" , "Aug" ,
                                "Sep", "Oct" , "Nov" , "Dec"};

        String[] monthNames = {"" , "January" , "February" , "March" , "April" ,
                                "May" , "June" , "July" , "August" , "September" , "October" ,
                                "November" , "December"};

        String result = "";

        switch (format) {
            case 1:
                result = this.toString();
                break;
            case 2:
                result = df.format(month) + "/" + df.format(day) + "/" + year;
                break;
            case 3:
                result = monthDesc[month] + " " + day + ", " + year;
                break;
            case 4:
                result = monthNames[month] + " " + day + ", " + year;
                break;
        }
        return result;
    }


    public void nextDay( ) {

        if (month == 12 && day == getLastDayOfMonth(month, year)) {
            year++;
            month = 1;
            day = 1;
        }
        else if(month == 12 && day != getLastDayOfMonth(month, year)){
            day++;
        }
        else if (day == getLastDayOfMonth(month, year) && month != 12) {
            month++;
            day = 1;
        }
        else if(month != 12 && day != getLastDayOfMonth(month, year)){
            day++;
        }
    }

    public boolean equals(@NotNull MyDate otherDate){
        if(day == otherDate.getDay() &&
            month == otherDate.getMonth() &&
                    year == otherDate.getYear()){
            return true;
        }
        else {
            return false;
        }
    }

    public void skipAhead(int numDays ){

        if(numDays > 0){
            for(int i = 1; i <= numDays; i++){
                nextDay();
            }
        }
        else {
            System.out.println("Invalid");
        }
    }
}

