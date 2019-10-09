package com.oppo.finance.core.db

import androidx.room.*
import com.oppo.finance.core.db.entity.User

@Dao
interface DatabaseService {
    @Query("SELECT * FROM todo_items")
    fun getAll(): List<User>

    @Query("SELECT * FROM todo_items WHERE title LIKE :title")
    fun findByTitle(title: String): User

    @Insert
    fun insertAll(vararg todo: User)

    @Delete
    fun delete(todo: User)

    @Update
    fun updateTodo(vararg todos: User)
}