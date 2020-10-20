package com.caldremch.andorid.architecture.bean

import androidx.annotation.Keep

/**
 *
 * @author Caldremch
 *
 * @date 2020-10-20
 *
 * @email caldremch@163.com
 *
 * @describe
 *
 **/
@Keep
class ItemBean {
    var name:String? = null
    var id:String? = null
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ItemBean

        if (name != other.name) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }


}