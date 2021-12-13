package application.ch10

import domain.ch10.Amount
import domain.ch10.Employee

fun payAmount(employee: Employee): Amount {
    if (employee.isSeparated) {
        return Amount(0L, "SEP")
    }
    if (employee.isRetired) {
        return Amount(0, "RET")
    }
    // 급여 계산 로직
    return Amount(1000, "")
}