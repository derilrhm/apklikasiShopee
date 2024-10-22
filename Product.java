import java.util.List;

class Product {
    String productName;
    double price;
    int stock;


    public Product(String productName, double price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }
}

class CartItem {
    Product product;
    int quantity;

  
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

class Order {
    List<CartItem> cartItems;
    double totalPrice;

    public Order(List<CartItem> cartItems) {
        this.cartItems = cartItems;
        this.totalPrice = calculateTotalPrice();
    }

    
    double calculateTotalPrice() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.product.price * item.quantity;
        }
        return total;
    }
}
