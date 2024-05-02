package quanglong.ph27075.gceagle.Model

import androidx.room.Embedded
import androidx.room.Relation

class QuizWithQuesEntities (
    @Embedded
    val quizThis: QuizThis,
    @Relation(
        parentColumn = "id",
        entityColumn = "idQuizThis"
    )
    val otherEntities: List<Question>
)

