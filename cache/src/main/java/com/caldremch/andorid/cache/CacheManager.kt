package com.caldremch.andorid.cache

import java.io.ByteArrayOutputStream
import java.io.ObjectOutputStream
import java.lang.Exception

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
object CacheManager {

   inline fun <reified T> save(key:String, cacheContent:T){

       var baos:ByteArrayOutputStream? = null
       var oos:ObjectOutputStream? = null
       var byteArray:ByteArray? = null

       try {
           baos = ByteArrayOutputStream()
           oos = ObjectOutputStream(baos)
           oos.writeObject(cacheContent)
           oos.flush()
           byteArray = baos.toByteArray()
       }catch (e:Exception){
           e.printStackTrace()
       }finally {
           try {
               baos?.close()
               oos?.close()
           }catch (e:Exception){
               e.printStackTrace()
           }
       }

       val cache = Cache()
       cache.key = key
       cache.data = byteArray
       CacheDataBase.get().getCache().save(cache)
   }


    fun findCache(key: String):Cache?{
       return CacheDataBase.get().getCache().getCache(key)
    }
}