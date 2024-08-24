import java.io.UnsupportedEncodingException;

public class Charset {
    public static void main(String[] args) {
        String name = "Madhav";
        try {
            byte[] array = name.getBytes("UTF-8");

            System.out.println("HexaDecimal: ");
            for(byte i : array){
                System.out.print(String.format("%02x",i) + " ");
            }

            System.out.println("\nOctadecimal");
            for(byte i : array){                
                System.out.print(String.format("%03o", i & 0xFF)+" ");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        
    }
}
