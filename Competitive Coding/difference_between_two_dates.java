import java.time.format.DateTimeFormatter;
import java.time.LocalDate;


import java.time.Period;

public class difference_between_two_dates {
    public static void main(String[] args) {
        String stringDate1 = "12-12-1990";
        String stringDate2 = "17-12-2004";

        try{
            LocalDate date1 = LocalDate.parse(stringDate1, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate date2 = LocalDate.parse(stringDate2, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

            

            Period period = Period.between(date1, date2);

            int Year = period.getYears();
            int Month = period.getMonths();
            int Days = period.getDays();

            System.out.println("Year-: " + Year + "\nMonth-: " + Month + "\nDays-: " + Days);
        }catch(Exception e){
            e.printStackTrace();
        }




    }
}
