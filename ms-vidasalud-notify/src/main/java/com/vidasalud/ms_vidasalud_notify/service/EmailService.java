package com.vidasalud.ms_vidasalud_notify.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void enviarNotificacion(String destinatario, String asunto, String mensaje) {
        System.out.println("==========================================");
        System.out.println("📩 PROCESANDO NOTIFICACIÓN VÍA EMAIL");
        System.out.println("Destinatario: " + destinatario);
        System.out.println("Asunto:       " + asunto);
        System.out.println("Contenido:    " + mensaje);
        System.out.println("==========================================");
    }
}