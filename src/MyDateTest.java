public class MyDateTest {

    public static void main (String [] args) {
        int errors = 0;
        System.out.println ("Testing begins");
        //********** phase 1 testing ************
        // testing the default constructor
        MyDate today = new MyDate();
        if (today.getMonth() != 10){
            System.out.println("month should be 10");
            errors++;
        }
        if (today.getDay() != 12){
            System.out.println("day should be 12");
            errors++;
        }

        // TO DO: test the year
        today.setYear(1993);

        // testing constructor 2
        MyDate theDay = new MyDate(1, 10, 1995);

        // TO DO: complete the checks for month, day and year
        // testing setter methods
        //testing setMonth
        theDay.setMonth(8);
        // TO DO: complete the code to check for month
        // TO DO: finish testing setDay and setYear
        theDay.setDay(13);
        theDay.setYear(1993);


        MyDate date1 = new MyDate(12, 30, 1945);
        MyDate date2 = new MyDate(12, 7, 1945);

        System.out.println("\nOriginal Date 1: " + date1);
        System.out.println("Original Date 2: " + date2);

        //skip ahead
        System.out.println("\n\n-------------------\n" +
                "Skip ahead and next day testing\n" +
                "-------------------");
        date1.skipAhead(45);
        System.out.println("Skip ahead 45 days from Date 1: " + date1);

        date2.nextDay();
        System.out.println("Next day from Date 2: " + date2);

        //leap year
        System.out.println("\n\n-------------------\n" +
                "Leap Year testing\n" +
                "-------------------");
        System.out.print("Is this year a leap year: " + date1 + "?");
        if(date1.isLeapYear(1945)){
            System.out.println(" This is a Leap Year");
        }
        else {
            System.out.println(" This is not a Leap Year");
        }

        //birthday
        System.out.println("\n\n-------------------\n" +
                "Birthday testing\n" +
                "-------------------");
        if(theDay.isMyBirthday()){
            System.out.println(theDay + ": This date is your birthday!");
        }
        else if(theDay.isMyBirthday()){
            System.out.println(theDay + ": This date is not your birthday");
        }

        //equals
        System.out.println("\n\n------------------\n" +
                "Equal Date testing\n" +
                "-------------------");
        if(date1.equals(date2)){
            System.out.println("Is " + date1 + " equal to " + date2 + "? Yes, the dates are the same");
        }
        else if(!date1.equals(date2)){
            System.out.println("Is " + date1 + " equal to " + date2 + "? No, the dates are not the same");
        }

        //formatting

        System.out.println("\n-------------------\n" +
                "Format testing\n" +
                "-------------------");
        System.out.println("Format 1: " + date1.toString(1));
        System.out.println("Format 2: " + date2.toString(2));
        System.out.println("Format 3: " + date1.toString(3));
        System.out.println("Format 4: " + date1.toString(4) + "\n");

        // TO DO: test the toString method
        System.out.println(theDay.toString());
        System.out.println("Errors: " + errors);
        System.out.println ("Testing ends");
    }

}
