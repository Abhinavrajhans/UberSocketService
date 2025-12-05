package com.example.UberSocket.services;

import com.example.UberSocket.dto.DriverNotificationDTO;
import com.example.UberSocket.dto.RideRequestDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class SocketService {

    private final SimpMessagingTemplate messagingTemplate;

    public void notifyDriversForNewRide(RideRequestDTO rideRequestDTO) {
        DriverNotificationDTO driverNotificationDTO = DriverNotificationDTO.builder()
                .pickUpLocationLongitude(rideRequestDTO.getPickUpLocationLatitude())
                .pickUpLocationLatitude(rideRequestDTO.getPickUpLocationLatitude())
                .bookingId(rideRequestDTO.getBookingId())
                .build();

        for(Integer driverId : rideRequestDTO.getDriverIds()) {
            messagingTemplate.convertAndSend("/topic/new-ride/"+driverId,driverNotificationDTO);
        }
    }
}
