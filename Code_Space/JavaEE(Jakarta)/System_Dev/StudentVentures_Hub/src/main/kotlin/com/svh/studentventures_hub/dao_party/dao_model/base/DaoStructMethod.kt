package com.svh.studentventures_hub.dao_party.dao_model.base

interface DaoStructMethod<T> {


    val tableName:String

    fun save(targetObject:T):Boolean

    fun update(targetObject:T):Boolean

    fun delete(deleteString:String):Boolean

    fun completeQuery():MutableList<T>

    fun filterQuery(filterString:String):MutableList<T>

    fun exactQuery(filterString:String):T?

}