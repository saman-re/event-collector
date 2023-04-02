package com.example.tapselltask

class Event(
    val impressionId:String,
    val eventType:String,
    val eventTime:Long,
    val advertiserId: Int?,
    val publisherId: Int?,
    val advertiserExpenseType:String?,
    val publisherIncomeType:String?,
    val advertiserExpense: Int?,
    val publisherIncome: Int?
){
    override fun toString(): String {
        return "Event(impressionId='$impressionId', eventType='$eventType', eventTime=$eventTime, advertiserId=$advertiserId, publisherId=$publisherId, advertiserExpenseType='$advertiserExpenseType', publisherIncomeType='$publisherIncomeType', advertiserExpense=$advertiserExpense, publisherIncome=$publisherIncome)"
    }
}