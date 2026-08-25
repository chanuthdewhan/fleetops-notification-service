package com.fleetops.notificationservice.dto.notification;

import lombok.*;
import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotificationResponse {
    private String id;
    private String type;
    private Long referenceId;
    private String message;
    private String recipientRole;
    private boolean read;
    private Instant createdAt;
}