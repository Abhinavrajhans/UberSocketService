package com.example.UberSocket.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RideRequestDTO {

    private String pickUpLocationLatitude;
    private String pickUpLocationLongitude;
    private Integer bookingId;
    private List<Integer> driverIds;
}
