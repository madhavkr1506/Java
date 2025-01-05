package com.example.id5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.id5.model.ChatModel;
import com.example.id5.service.ChatService;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;
    
    // @PostMapping("/")
    // public ChatModel inputquestion(@RequestBody ChatModel chatModel ){
    //     String question = chatModel.getQuestion();
    //     chatService.getQuestion(question);
    //     ChatModel response = chatService.getAnswer();

        
    //     return response;

    // }

    @PostMapping("/")
    public ChatModel inputquestion(@RequestParam("question") String question, @RequestParam(value = "imagefile",required = false) MultipartFile imagefile ){
        chatService.getQuestion(question);

        if(imagefile != null && !imagefile.isEmpty()){
            chatService.setImagefile(imagefile);
        }
        ChatModel response = chatService.getAnswer();

        
        return response;

    }

    

}
