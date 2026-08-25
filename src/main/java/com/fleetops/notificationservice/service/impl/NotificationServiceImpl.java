package com.fleetops.notificationservice.service.impl;

import com.fleetops.notificationservice.dto.notification.CreateNotificationRequest;
import com.fleetops.notificationservice.dto.notification.NotificationResponse;
import com.fleetops.notificationservice.entity.Notification;
import com.fleetops.notificationservice.exception.ResourceNotFoundException;
import com.fleetops.notificationservice.mapper.NotificationMapper;
import com.fleetops.notificationservice.repository.NotificationRepository;
import com.fleetops.notificationservice.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;

    @Override
    public NotificationResponse createNotification(CreateNotificationRequest request) {
        Notification notification = Notification.builder()
                .type(request.getType())
                .referenceId(request.getReferenceId())
                .message(request.getMessage())
                .recipientRole(request.getRecipientRole())
                .read(false)
                .createdAt(Instant.now())
                .build();

        Notification saved = notificationRepository.save(notification);
        log.info("Notification created: type={}, referenceId={}", saved.getType(), saved.getReferenceId());
        return notificationMapper.toResponse(saved);
    }

    @Override
    public List<NotificationResponse> getNotifications(String recipientRole, Boolean read) {
        List<Notification> notifications = (read != null)
                ? notificationRepository.findByRecipientRoleAndRead(recipientRole, read)
                : notificationRepository.findByRecipientRole(recipientRole);
        return notifications.stream().map(notificationMapper::toResponse).toList();
    }

    @Override
    public NotificationResponse markAsRead(String id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found: " + id));
        notification.setRead(true);
        Notification saved = notificationRepository.save(notification);
        return notificationMapper.toResponse(saved);
    }
}