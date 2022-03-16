import kotlinx.coroutines.async
import java.util.*


suspend fun processOrder(order: ProductOrder) {
    val token = TokenService.getToken()
    if (token.isNotBlank()) {
        val res = ProductService.reserve(order.product)
        if (res) {
            ClientDataRepository.save(token)
        } else {
            throw Exception("Product reservation failed $token")
        }
    } else {
        throw Exception("Failed to acquire a token")
    }
}


class Product

class ProductOrder(val product: Product)

internal object ClientDataRepository {
    fun save(token: String) {}
}

internal object ProductService {
    suspend fun reserve(product: Product) = false
}

object TokenService {
    suspend fun getToken() = UUID.randomUUID().toString()
}

