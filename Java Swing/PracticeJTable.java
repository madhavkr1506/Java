import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

public class PracticeJTable {
    public static void main(String[] args) {
        try{
            @SuppressWarnings("deprecation")
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Phagwara&appid=1abda653c4c413b0f3be7e69d5ce7e12");

            URLConnection connection = url.openConnection();

            String inputLine;
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);

            }

            JSONObject responsObject = new JSONObject(response.toString());

            double temperature = responsObject.getJSONObject("main").getDouble("temp");
            double feelslike = responsObject.getJSONObject("main").getDouble("feels_like");
            double pressure = responsObject.getJSONObject("main").getDouble("pressure");
            double humidity = responsObject.getJSONObject("main").getDouble("humidity");
            double sealevel = responsObject.getJSONObject("main").has("sea_level")
                    ? responsObject.getJSONObject("main").getDouble("sea_level")
                    : Double.NaN;

            JFrame frame = new JFrame("Weather Data");
            frame.setLayout(null);
            frame.setSize(500,300);
            frame.setLocationRelativeTo(null);
            
            String[] column = {"Temperature","FeelsLike","Pressure","Humidity","SeaLevel"};

            String data[][] = {{String.valueOf(temperature),String.valueOf(feelslike),String.valueOf(pressure),String.valueOf(humidity),sealevel != Double.NaN ? String.valueOf(sealevel) : "N/A" }};

            DefaultTableModel model = new DefaultTableModel(data,column);
            JTable table = new JTable(model);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(40,40,400,200);
            frame.add(scrollPane);

            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
