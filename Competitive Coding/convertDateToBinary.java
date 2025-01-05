import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class convertDateToBinary {
    public static void main(String[] args) {
        String stringDate = "22-11-2024";
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try{
            Date date = dateFormat.parse(stringDate);

            Calendar calender = Calendar.getInstance();
            calender.setTime(date);

            int Year = calender.get(Calendar.YEAR);
            int Month = calender.get(Calendar.MONTH) + 1;
            int day_of_month = calender.get(Calendar.DAY_OF_MONTH);

            System.out.println("Year- " + Year + " Month- " + Month + " Day of month- " + day_of_month);
            System.out.println(Integer.toBinaryString(Year) + "-" + Integer.toBinaryString(Month) + "-" + Integer.toBinaryString(day_of_month));

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
