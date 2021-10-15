package application.ch6

import domain.ch6.Product
import domain.ch6.ShippingMethod

fun applyShipping(basePrice: Int, shippingMethod: ShippingMethod, quantity: Int, discount: Int): Int {
    val shippingPerCase = if (basePrice > shippingMethod.discountThreshold) {
        shippingMethod.discountedFee
    } else {
        shippingMethod.feePerCase
    }
    val shippingCost = quantity * shippingPerCase
    return basePrice - discount + shippingCost;
}

fun priceOrder(product: Product, quantity: Int, shippingMethod: ShippingMethod): Int {
    val basePrice = product.basePrice * quantity
    val discount = (quantity - product.discountThreshold).coerceAtLeast(0)
    
    return applyShipping(basePrice, shippingMethod, quantity, discount)
}