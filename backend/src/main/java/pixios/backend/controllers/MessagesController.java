package pixios.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MessagesController {
    @GetMapping("/messages")
    public ResponseEntity<List<String>> message(){
        return ResponseEntity.ok().body(Arrays.asList("first", "second"));
    }

}
