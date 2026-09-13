package com.vidasalud.ms_vidasalud_notify.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class NotificationEnvelope<T> {
    private String eventId;
    private String type;
    private String timestamp;
    private String traceId;
    private String correlationId;
    private T payload;
}
