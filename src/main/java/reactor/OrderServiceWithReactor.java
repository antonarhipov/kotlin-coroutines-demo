package reactor;

import reactor.core.publisher.Mono;

import java.util.UUID;

public class OrderServiceWithReactor {

    private static String t = null;

    public void processOrder(ProductOrder order) throws Exception {
        TokenService.getToken().flatMap(token -> {
            t = token;
            try {
                return ProductService.reserve(order.getProduct());
            } catch (Exception e) {
                System.err.println("Product reservation failed");
            }
            return Mono.empty();
        }).mapNotNull(res -> {
            if (res) {
                ClientDataRepository.save(t);
            }
            return null;
        }).subscribe();
    }

}


class Product { }


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
    static Mono<Boolean> reserve(Product productId) {
        return Mono.just(false);
    }
}


class TokenService {
    static Mono<String> getToken() {
        return Mono.just(UUID.randomUUID().toString());
    }
}
