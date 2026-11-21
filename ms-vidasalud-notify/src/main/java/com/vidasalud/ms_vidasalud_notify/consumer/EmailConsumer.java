package com.vidasalud.ms_vidasalud_notify.consumer;

import com.rabbitmq.client.Channel;
import com.vidasalud.ms_vidasalud_notify.dto.NotificationEnvelope;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class EmailConsumer {

    //  Escuchar la cola de Email
    @RabbitListener(queues = "${messaging.queue.email}")
    public void processEmail(NotificationEnvelope envelope, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            System.out.println("Procesando envío de EMAIL: " + envelope);
            // lógica de enviar el correo 
            
            channel.basicAck(tag, false); // ACK manual si es exitoso
        } catch (Exception e) {
            System.err.println("Error enviando email: " + e.getMessage());
            channel.basicNack(tag, false, false); // NACK manual  se va a la DLQ
        }
    }

    // Escuchar la cola de Admisión Tickets
    @RabbitListener(queues = "${messaging.queue.admission}")
    public void processAdmission(NotificationEnvelope envelope, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            System.out.println("Procesando TICKET DE ADMISIÓN: " + envelope);
            channel.basicAck(tag, false);
        } catch (Exception e) {
            channel.basicNack(tag, false, false);
        }
    }

    // Escuchar la cola de Records PDFs
    @RabbitListener(queues = "${messaging.queue.record}")
    public void processRecord(NotificationEnvelope envelope, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        try {
            System.out.println("Procesando generación de PDF (Record): " + envelope);
            channel.basicAck(tag, false);
        } catch (Exception e) {
            channel.basicNack(tag, false, false);
        }
    }
}