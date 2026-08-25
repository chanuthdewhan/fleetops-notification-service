package com.fleetops.notificationservice.service;

import com.fleetops.notificationservice.dto.notification.CreateNotificationRequest;
import com.fleetops.notificationservice.dto.notification.NotificationResponse;

import java.util.List;

public interface NotificationService {
    NotificationResponse createNotification(CreateNotificationRequest request);
    List<NotificationResponse> getNotifications(String recipientRole, Boolean read);
    NotificationResponse markAsRead(String id);
}