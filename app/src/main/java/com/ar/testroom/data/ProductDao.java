package com.ar.testroom.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;
import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by RadyaLabs PC on 15/12/2017.
 */
@Dao
public interface ProductDao {

    @Query("select * from Product where id = :id")
    Product loadProductById(int id);

    @Insert(onConflict = IGNORE)
    void insertProduct(Product product);

    @Update(onConflict = REPLACE)
    void updateProduct(Product product);

}
