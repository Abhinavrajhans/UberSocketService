package com.example.UberSocket.client;

import com.example.UberSocket.RideAcceptanceRequest;

import com.example.UberSocket.RideAcceptanceResponse;
import com.example.UberSocket.RideServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class GrpcClient {


    @Value("${grpc.server.port:9090}")
    private int grpcServerPort;

    @Value("${grpc.server.host:localhost}")
    private String grpcServerHost;

    private ManagedChannel channel;

    private RideServiceGrpc.RideServiceBlockingStub rideServiceBlockingStub;


    @PostConstruct
    public void init(){
        channel = ManagedChannelBuilder.forAddress(grpcServerHost, grpcServerPort)
                .usePlaintext().build();

        rideServiceBlockingStub = RideServiceGrpc.newBlockingStub(channel);
    }

    public boolean acceptRide(Integer driverId,Integer bookingId){
        RideAcceptanceRequest request = RideAcceptanceRequest.newBuilder()
                .setDriverId(driverId)
                .setBookingId(bookingId)
                .build();

        RideAcceptanceResponse response = rideServiceBlockingStub.acceptRide(request); // This is the place where u make the grpc call
        return response.getSuccess();
    }

}
