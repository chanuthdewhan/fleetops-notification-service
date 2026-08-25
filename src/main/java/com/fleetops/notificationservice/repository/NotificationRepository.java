package com.fleetops.notificationservice.repository;

import com.fleetops.notificationservice.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    List<Notification> findByRecipientRoleAndRead(String recipientRole, boolean read);
    List<Notification> findByRecipientRole(String recipientRole);
}