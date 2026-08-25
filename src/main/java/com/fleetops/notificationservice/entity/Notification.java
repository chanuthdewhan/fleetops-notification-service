package com.fleetops.notificationservice.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

@Document(collection = "notifications")
public class Notification {
    @Id
    private String id;

    private String type;
    private Long referenceId;
    private String message;
    private String recipientRole;
    private boolean read;
    private Instant createdAt;
}