import java.security.MessageDigest;

public class SHA_HashingAlgo {
    public static void main(String[] args) {
        try{
            String string = "";
            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            byte[] hash = digest.digest(string.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for(byte in : hash){
                String hex = Integer.toHexString(0xff & in);
                if(hex.length() == 1){
                    hexString.append("0");

                }
                hexString.append(hex);
            }

            System.out.println("SHA-1 Hashing: " + hexString.toString());


        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
