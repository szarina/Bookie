package com.example.ass3.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao  {
    @Insert(Book::class)
    fun insertBook(book: Book)
    @Query("SELECT * FROM books")
    fun getAllBooks(): Flow<List<Book>>

    @Update(Book::class)
    fun updateBook(book: Book)

    @Query("DELETE FROM books WHERE id =:myId")
    fun deleteBookById(myId:Int):Int

    @Query("SELECT * FROM books WHERE title LIKE  '%' || :myTitle || '%' ")
    fun searchBooks(myTitle:String):Flow<List<Book>>
    @Insert(User::class)
    fun insertUser(user: User)

    @Query("SELECT * FROM users")
    fun getAllUsers(): Flow<List<User>>


//    @Query("SELECT * FROM users WHERE username = :name and password = :pwd LIMIT 1")
//    fun findUser(name:String,pwd:String):Flow<User?>
}