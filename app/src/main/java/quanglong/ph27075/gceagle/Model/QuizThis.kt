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
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}