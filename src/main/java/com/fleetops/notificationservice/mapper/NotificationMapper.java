package com.fleetops.notificationservice.mapper;

import com.fleetops.notificationservice.dto.notification.NotificationResponse;
import com.fleetops.notificationservice.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationMapper {

    public NotificationResponse toResponse(Notification notification) {
        return NotificationResponse.builder()
                .id(notification.getId())
                .type(notification.getType())
                .referenceId(notification.getReferenceId())
                .message(notification.getMessage())
                .recipientRole(notification.getRecipientRole())
                .read(notification.isRead())
                .createdAt(notification.getCreatedAt())
                .build();
    }
}