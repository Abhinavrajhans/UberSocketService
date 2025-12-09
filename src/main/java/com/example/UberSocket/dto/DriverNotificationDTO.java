package com.example.UberSocket.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DriverNotificationDTO {
    private String pickUpLocationLatitude;
    private String pickUpLocationLongitude;
    private Long bookingId;
}



