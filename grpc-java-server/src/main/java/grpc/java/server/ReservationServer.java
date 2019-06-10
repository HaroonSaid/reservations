/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package grpc.java.server;

import java.io.IOException;
import java.util.UUID;

import io.grpc.BindableService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import com.reservation.schema.TransactionProtos;
import com.reservation.schema.TransactionProtos.*;
import com.reservation.schema.*;

/**
 * Created by rayt on 5/16/16.
 */
public class ReservationServer {
  static public void main(String [] args) throws IOException, InterruptedException {
    ReservationServiceImpl impl = new ReservationServiceImpl();
    Server server = ServerBuilder.forPort(8080)
        .addService(impl).build();

    System.out.println("Starting server...");
    server.start();
    System.out.println("Server started!");
    server.awaitTermination();
  }

  public static class ReservationServiceImpl extends ReservationServiceGrpc.ReservationServiceImplBase  {
    @Override
    public void reserve(TransactionProtos.TransactionRequest request, StreamObserver<TransactionProtos.TransactionResponse> responseObserver) {
      System.out.println(request);
      String id = UUID.randomUUID().toString();
      String msg = "Hello from Java Rpc:" + id;

      TransactionProtos.TransactionResponse response =TransactionProtos.TransactionResponse.newBuilder().setMessage(msg).build();

      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }
  }
}