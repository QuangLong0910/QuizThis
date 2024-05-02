package quanglong.ph27075.gceagle.Model


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "Question",
    foreignKeys = [
        ForeignKey(
            entity = QuizThis::class,
            parentColumns = ["id"], // Các cột trong bảng QuizThis mà trường idQuizThis của Question tham chiếu đến
            childColumns = ["idQuizThis"], // Trường idQuizThis của Question
            onDelete = ForeignKey.CASCADE // Hành động khi bảng cha (QuizThis) bị xóa
        )
    ]
)
class Question(
    var nameQuestion: String = "",
    var idQuizThis: String = "", // Trường khóa ngoại tham chiếu đến id của QuizThis
    var date: String = "",
    var creat: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}