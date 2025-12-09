package com.example.UberSocket.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RideAcceptanceDTO {
    private Long driverId;
    private Long bookingId;
}
