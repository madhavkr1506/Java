package spring.nlp;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;

import org.bson.Document;

public class DB {

    public static void main(String[] args) {
        
        try{
            MongoClient client = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase database = client.getDatabase("shop");

            MongoCollection<Document> collection = database.getCollection("products");

            if(collection == null){
                System.out.println("Collection not found");
            }

            Document doc1 = new Document("$and", Arrays.asList(new Document("price",new Document("$gt",10)), new Document("name","Notebook Collection")));

            collection.find(doc1).forEach(doc -> System.out.println(doc));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
