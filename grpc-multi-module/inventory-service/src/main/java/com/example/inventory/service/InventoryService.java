package com.example.inventory.service;

import com.example.common.inventory.InventoryServiceGrpc.InventoryServiceImplBase;
import com.example.common.inventory.ProductRequest;
import com.example.common.inventory.StockResponse;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class InventoryService extends InventoryServiceImplBase{

    @Override
    public void checkStock(ProductRequest request, StreamObserver<StockResponse> responseObserver) {
        String productId = request.getProductId();

        // productId : 999는 재고 없는 것으로 가정
        int stock = 100;
        if (productId.equals("999")) {
            stock = 0;
        }

        StockResponse response = StockResponse.newBuilder()
                .setProductId(productId)
                .setQuantity(stock)
                .setInStock(stock > 0)
                .build();
        
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
