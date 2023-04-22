package com.example.movieappmad23.utils

import androidx.room.TypeConverter
import com.example.movieappmad23.models.Genre

class CustomConverters {

    @TypeConverter
    fun fromGenreList(genreList: List<Genre>): String {
        return genreList.joinToString(separator = ",") { it.ordinal.toString() } //Weil Genre ein Enum ist müssen wir "ordinal" verwenden
    }

    @TypeConverter
    fun toGenreList(genreString: String): List<Genre> {
        return genreString.split(",").map { Genre.values()[it.toInt()] }
    }

    @TypeConverter
    fun fromStringList(stringList: List<String>): String {
        return stringList.joinToString(separator = ",")
    }

    @TypeConverter
    fun toStringList(stringListString: String): List<String> {
        return stringListString.split(",")
    }
}
