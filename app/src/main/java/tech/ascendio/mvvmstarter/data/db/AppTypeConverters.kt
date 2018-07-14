package tech.ascendio.mvvmstarter.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

/**
 * Type converters to allow Room to reference complex data types.
 */
class AppTypeConverters {
    @TypeConverter
    fun calendarToDatestamp(calendar: Calendar): Long = calendar.timeInMillis

    @TypeConverter
    fun datestampToCalendar(value: Long): Calendar =
            Calendar.getInstance().apply { timeInMillis = value }

    @TypeConverter
    fun stringToStringList(data: String?): List<String> {
        if (data == null) return Collections.emptyList()
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun stringListToString(objects: List<String>): String = Gson().toJson(objects)
}