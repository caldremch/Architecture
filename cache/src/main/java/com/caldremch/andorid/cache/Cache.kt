package com.caldremch.andorid.cache

import androidx.room.*
import java.io.Serializable

/**
 *
 * @author Caldremch
 *
 * @date 2020-10-19
 *
 * @email caldremch@163.com
 *
 * @describe
 *
 **/
@Entity(tableName = "cache")
class Cache : Serializable {
    @PrimaryKey
    var key: String = ""
    var data: ByteArray? = null
}

