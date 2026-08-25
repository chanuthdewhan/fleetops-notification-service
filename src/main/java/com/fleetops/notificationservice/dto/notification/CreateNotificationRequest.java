package com.fleetops.notificationservice.dto.notification;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateNotificationRequest {
    @NotBlank
    private String type;
    @NotNull
    private Long referenceId;
    @NotBlank
    private String message;
    @NotBlank
    private String recipientRole;
}