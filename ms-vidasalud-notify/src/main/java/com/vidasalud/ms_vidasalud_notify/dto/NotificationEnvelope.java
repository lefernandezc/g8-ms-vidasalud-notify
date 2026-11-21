package com.vidasalud.ms_vidasalud_notify.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEnvelope {
    private String type;
    private String eventId;
    private LocalDateTime timestamp;
    private String traceId;
    private String correlationId;
    
    // Payload con los datos del mensaje (ej: correo, idAtencion, etc.)
    private Object payload; 
}