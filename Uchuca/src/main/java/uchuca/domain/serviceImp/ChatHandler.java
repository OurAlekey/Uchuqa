package uchuca.domain.serviceImp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class ChatHandler extends TextWebSocketHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatHandler.class);

    private final Map<Integer, CopyOnWriteArrayList<WebSocketSession>> chatSessions = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // Obtener el ID de la sala de chat de la URI
        Map<String, Object> attributes = session.getAttributes();
        Integer roomId = Integer.parseInt(attributes.get("roomId").toString());

        // Agregar la sesión a la sala de chat correspondiente
        chatSessions.computeIfAbsent(roomId, k -> new CopyOnWriteArrayList<>()).add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // Obtener el ID de la sala de chat de la URI
        Map<String, Object> attributes = session.getAttributes();
        Integer roomId = Integer.parseInt(attributes.get("roomId").toString());

        // Remover la sesión de la sala de chat correspondiente
        chatSessions.computeIfPresent(roomId, (k, v) -> {
            v.remove(session);
            return v;
        });
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Obtener el ID de la sala de chat de la URI
        Map<String, Object> attributes = session.getAttributes();
        Integer roomId = Integer.parseInt(attributes.get("roomId").toString());

        // Enviar el mensaje a todas las sesiones en la sala de chat
        chatSessions.getOrDefault(roomId, new CopyOnWriteArrayList<>())
                .forEach(webSocketSession -> {
                    try {
                        webSocketSession.sendMessage(message);
                    } catch (IOException e) {
                        LOGGER.error(e.getMessage(), e);
                    }
                });
    }
}