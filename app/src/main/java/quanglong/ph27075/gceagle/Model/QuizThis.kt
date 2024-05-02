package quanglong.ph27075.gceagle.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "QuizThiz")
class QuizThis(
    @ColumnInfo(name = "Description") var description: String = "",
    @ColumnInfo(name = "Title") var title: String = "",
    @ColumnInfo(name = "Date") var date: String = "",
    @ColumnInfo(name = "Creat by") var creat: String = "",
    @ColumnInfo(name = "Storage") var storage: Boolean = false,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    override fun toString(): String {
        return "QuizThis(description='$description', title='$title', date='$date', creat='$creat', storage=$storage, id=$id)"
    }

}