package com.example.id4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.id4.service.ApiService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    @Autowired
    private ApiService apiService;

    private List<Message> messages = new ArrayList<>();

    private static final String UPLOADED_FOLDER = "uploaded_images/";

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("messages", messages);
        return "index";
    }

    @PostMapping("/getAnswer")
    public String getAnswer(@RequestParam("question") String question,
                            @RequestParam("file") MultipartFile file,
                            Model model, RedirectAttributes redirectAttributes) {

        String imageUrl = null;

        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                Path path = Paths.get(UPLOADED_FOLDER + fileName);
                Files.createDirectories(path.getParent());
                Files.write(path, file.getBytes());
                imageUrl = "/uploaded_images/" + fileName;
            } catch (IOException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("error", "Failed to save the image.");
                return "redirect:/";
            }
        }

        messages.add(new Message("user", question, imageUrl));

        String[] answer = apiService.getAnswer(question, file);
        String text = answer[0];
        String botImageUrl = answer[1];

        messages.add(new Message("bot", text, botImageUrl));

        model.addAttribute("messages", messages);
        return "index";
    }

    public static class Message {
        private String type;
        private String text;
        private String imageUrl;

        public Message(String type, String text, String imageUrl) {
            this.type = type;
            this.text = text;
            this.imageUrl = imageUrl;
        }

        public String getType() {
            return type;
        }

        public String getText() {
            return text;
        }

        public String getImageUrl() {
            return imageUrl;
        }
    }
}
