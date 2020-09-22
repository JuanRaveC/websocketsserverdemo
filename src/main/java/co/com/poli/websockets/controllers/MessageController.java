package co.com.poli.websockets.controllers;

import co.com.poli.websockets.model.MessageModel;
import co.com.poli.websockets.model.MessageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageResponse send(MessageModel message) {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        log.info(":: Message received -> " + message.toString());
        return new MessageResponse("Hello! " + message.getFrom(), "This is what i got from you! " + message.getText(), time);
    }

}
