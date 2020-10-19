package com.caldremch.andorid.cache

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.caldremch.utils.Utils
import java.lang.RuntimeException

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
@Database(entities = [Cache::class], version = 1, exportSchema = false)
abstract class CacheDataBase : RoomDatabase() {

    companion object {

        private var database: CacheDataBase? = null

        fun get(): CacheDataBase {
            if (database == null) {
                throw RuntimeException("is not init...")
            }
            return database!!
        }

        init {
            database = Room.databaseBuilder<CacheDataBase>(
                Utils.getContext(),
                CacheDataBase::class.java,
                "architecture"
            ).allowMainThreadQueries()
                .addCallback(object : RoomDatabase.Callback() {

                })
//                .setQueryExecutor()
//                .openHelperFactory()
//                .setJournalMode()
//                .addMigrations()  //数据库升级迁移
                .build()

        }

//        private val migration = object:Migration(1,3){
//            override fun migrate(database: SupportSQLiteDatabase) {
//
//                database.execSQL("alter table test rename to student")
//
//            }
//
//        }
    }

    abstract fun getCache(): CacheDao

}