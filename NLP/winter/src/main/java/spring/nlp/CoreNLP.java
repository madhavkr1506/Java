package spring.nlp;

import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;

public class CoreNLP {

    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Properties properties = new Properties();
        properties.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner,parse,sentiment");

        Set<String> stopwords = new HashSet<>(Arrays.asList("is", "it", "be", "the", "a", "an"));

        StanfordCoreNLP pipeline = new StanfordCoreNLP(properties);

        String string = "Madhav is a good boy";
        Annotation annotation = new Annotation(string);

        pipeline.annotate(annotation);

        List<CoreMap> sentences = annotation.get(CoreAnnotations.SentencesAnnotation.class);

        for(CoreMap sentence : sentences){
            System.out.println("Sentence: " + sentence);
            String sentiment = sentence.get(SentimentCoreAnnotations.SentimentClass.class);
            System.out.println("Sentiment: " + sentiment);

            List<CoreLabel> tokens = sentence.get(CoreAnnotations.TokensAnnotation.class);
            for(CoreLabel token : tokens){
                String lemma = token.lemma();

                
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                if(pos.equals(",") || pos.equals(".") || pos.equals("''") || pos.equals("``") || pos.equals("?") || pos.equals("/") || pos.equals("\\") || pos.equals(";")){
                    continue;
                }
                if(!stopwords.contains(lemma.toLowerCase())){
                    System.out.println("Token: " + token.lemma());
                }
                
            }
        }

        scanner.close();
        
    }
}