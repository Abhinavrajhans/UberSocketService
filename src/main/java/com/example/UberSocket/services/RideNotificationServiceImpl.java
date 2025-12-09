package com.example.UberSocket.services;

import com.example.UberSocket.RideNotificationRequest;
import com.example.UberSocket.RideNotificationResponse;
import com.example.UberSocket.RideNotificationServiceGrpc;
import com.example.UberSocket.dto.RideRequestDTO;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RideNotificationServiceImpl extends RideNotificationServiceGrpc.RideNotificationServiceImplBase {

    private final SocketService socketService;

    @Override
    public void notifyDriversForNewRide(RideNotificationRequest request, StreamObserver<RideNotificationResponse> responseObserver) {
        RideRequestDTO rideRequestDTO = RideRequestDTO.builder()
                        .pickUpLocationLatitude(request.getPickUpLocationLatitude())
                        .pickUpLocationLongitude(request.getPickUpLocationLongitude())
                        .bookingId(request.getBookingId())
                        .driverIds(request.getDriverIdsList())
                        .build();



        socketService.notifyDriversForNewRide(rideRequestDTO);
        responseObserver.onNext(RideNotificationResponse.newBuilder().setSuccess(true).build());
        responseObserver.onCompleted();

    }

}
