package com.sunjet.rpc;


import com.sunjet.rpc.api.Book;
import com.sunjet.rpc.api.BookServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;

@Slf4j
@GRpcService
public class BookServiceImpl extends BookServiceGrpc.BookServiceImplBase {

    @Override
    public void getBookById(Book.BookRequest request, StreamObserver<Book.BookResponse> responseObserver) {
        log.info("客户端调用了方法：getBookById");
        Book.BookResponse bookResponse = Book.BookResponse.newBuilder()
                .setBookId(request.getBookId())
                .setBookIsbn("ISBN" + request.getBookId())
                .setBookName("Name" + request.getBookId())
                .setBookPrice(10.6)
                .build();
        responseObserver.onNext(bookResponse);
        responseObserver.onCompleted();
    }
}
