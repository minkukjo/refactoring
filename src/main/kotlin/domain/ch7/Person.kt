package domain.ch7

class Person(
        val name: String,
        private val telephoneNumber: TelephoneNumber
) {
    fun getOfficeAreaCode(): Int {
        return telephoneNumber.areaCode
    }

    fun setOfficeAreaCode(areaCode: Int) {
        this.telephoneNumber.areaCode = areaCode;
    }

    fun getOfficeNumber(): Int {
        return telephoneNumber.number
    }

    fun setOfficeNumber(number: Int) {
        this.telephoneNumber.number = number;
    }
}