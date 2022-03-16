package sync;

import java.util.UUID;

public class OrderServiceSync {

    public void processOrder(ProductOrder order) throws Exception {

        String token = TokenService.getToken();

        if (token != null && !token.isBlank()) {

            boolean res = ProductService.reserve(order.getProduct());

            if (res) {
                ClientDataRepository.save(token);
            } else {
                throw new Exception("Product reservation failed " + token);
            }

        } else {
            throw new Exception("Failed to acquire a token");
        }
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
    static boolean reserve(Product productId) {
        return false;
    }
}


class TokenService {
    static String getToken() {
        return UUID.randomUUID().toString();
    }
}