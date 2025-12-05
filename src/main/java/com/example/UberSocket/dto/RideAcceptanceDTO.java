package com.example.UberSocket.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RideAcceptanceDTO {
    private Integer driverId;
    private Integer bookingId;
}
