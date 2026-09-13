package com.vidasalud.ms_vidasalud_notify.consumer;


import com.vidasalud.ms_vidasalud_notify.config.RabbitMQConfig;
import com.vidasalud.ms_vidasalud_notify.dto.NotificationEnvelope;
import com.vidasalud.ms_vidasalud_notify.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class EmailConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE_EMAIL)
    public void consumirMensajeEmail(NotificationEnvelope<Map<String, Object>> mensaje) {
        System.out.println("-> Evento recibido en q.cmd.email [TraceID: " + mensaje.getTraceId() + "]");

        Map<String, Object> payload = mensaje.getPayload();
        String destinatario = payload != null ? (String) payload.getOrDefault("to", "paciente@vidasalud.cl") : "paciente@vidasalud.cl";
        String asunto = payload != null ? (String) payload.getOrDefault("subject", "Actualización de Atención") : "Atención VidaSalud";
        String contenido = payload != null ? (String) payload.getOrDefault("body", "Detalles de la cita.") : "Sin contenido";

        emailService.enviarNotificacion(destinatario, asunto, contenido);
    }
}