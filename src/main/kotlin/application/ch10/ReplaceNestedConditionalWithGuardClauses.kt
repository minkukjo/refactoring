package application.ch10

import domain.ch10.Amount
import domain.ch10.Employee

fun payAmount(employee: Employee): Amount {
    var result: Amount = if (employee.isSeparated) {
        Amount(0L, "SEP")
    } else {
        if (employee.isRetired) {
            Amount(0, "RET")
        } else {
            // 급여 계산 로직
            Amount(1000, "")
        }
    }
    return result
}