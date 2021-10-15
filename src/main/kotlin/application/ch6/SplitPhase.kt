package application.ch6

import domain.ch6.PriceData
import domain.ch6.Product
import domain.ch6.ShippingMethod

fun applyShipping(priceData: PriceData, shippingMethod: ShippingMethod): Int {
    val shippingPerCase = if (priceData.basePrice > shippingMethod.discountThreshold) {
        shippingMethod.discountedFee
    } else {
        shippingMethod.feePerCase
    }
    val shippingCost = priceData.quantity * shippingPerCase
    return priceData.basePrice - priceData.discount + shippingCost;
}

fun calculatePricingData(product: Product, quantity: Int): PriceData {
    val basePrice = product.basePrice * quantity
    val discount = (quantity - product.discountThreshold).coerceAtLeast(0)
    return PriceData(basePrice, quantity, discount)
}

fun priceOrder(product: Product, quantity: Int, shippingMethod: ShippingMethod): Int {
    val priceData = calculatePricingData(product, quantity)
    return applyShipping(priceData, shippingMethod)
}