package domain.ch6

class ShippingMethod(
        val discountThreshold: Int,
        val discountedFee: Int,
        val feePerCase: Int,
)