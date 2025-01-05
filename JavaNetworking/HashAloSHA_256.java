// it is secure hash algorithm 256 bit is a part of the sha-2 family of cryptographic hash functions.
// it is widely used in security application and protocols, including ssl/tls and cryptocurrencies like bitcoins.

// key characteristic:
// 1. fixed output length: regradless of input size, it always produce a 32 byte hash.

// deterministic: the same input will produce same output.

// fast computation
// collision resistant: it is very hard to find two different inputs that produce the same hash.

// pre image resistance
// it's computationally infeasible to reverse it to find the original input.




import java.security.MessageDigest; //--> it will generate cryptographic hash.
public class HashAloSHA_256 {
    public static void main(String[] args) {
        
        try{
            String userName = "Madhav kumar";
            
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] hash = digest.digest(userName.getBytes("UTF-8"));

            StringBuilder hexString = new StringBuilder();

            for(byte b : hash){
                String hex = Integer.toHexString(0xff & b);
                if(hex.length() == 1){
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            System.out.println("SHA-256 hash: " + hexString.toString());

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


