package async;


import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class OrderServiceWithCompletableFuture {

    public void processOrder(ProductOrder order) throws Exception {
        CompletableFuture<String> future = TokenService.getToken().thenCompose(token -> {
            try {
                ProductService.reserve(order.getProduct()).thenAccept(res -> {
                    if (res) {
                        ClientDataRepository.save(token);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });
        future.get();
    }

}


class Product {

}


class ProductOrder {
    Product product;

    public Product getProduct() {
        return product;
    }
}

class ClientDataRepository {
    static void save(String token) {

    }
}

class ProductService {
    static CompletableFuture<Boolean> reserve(Product product) {
        return CompletableFuture.completedFuture(false); //stub
    }
}


class TokenService {
    static CompletableFuture<String> getToken() {
        return CompletableFuture.completedFuture(UUID.randomUUID().toString()); //stub
    }
}