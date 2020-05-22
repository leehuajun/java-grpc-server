package com.sunjet.rpc;

import com.sunjet.rpc.api.Book;
import com.sunjet.rpc.api.BookServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.junit.jupiter.api.Test;

class GrpcTests {

    @Test
    void clientTest(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8088)
                .usePlaintext()
                .build();
        BookServiceGrpc.BookServiceBlockingStub bookStub = BookServiceGrpc.newBlockingStub(channel);
        Book.BookRequest bookRequest = Book.BookRequest.newBuilder().setBookId(5).build();
        Book.BookResponse bookResponse = bookStub.getBookById(bookRequest);
        System.out.println(bookResponse);
    }
}
