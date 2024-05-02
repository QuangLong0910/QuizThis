package quanglong.ph27075.gceagle.Adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import quanglong.ph27075.gceagle.Model.Question

import quanglong.ph27075.gceagle.Model.QuizWithQuesEntities
import quanglong.ph27075.gceagle.R

class AdapterRecycleviewQuestion (private val context: Context,
                                  private val onClick: (Question, Int) -> Unit,
                                  private val onDelete: (Question) -> Unit) :RecyclerView.Adapter<AdapterRecycleviewQuestion.QuestionViewHolder>(){


    private var quizList  = emptyList<QuizWithQuesEntities>()
  inner  class QuestionViewHolder (itemView: View) :RecyclerView.ViewHolder(itemView) {
      private val textviewNameQuizThis: TextView = itemView.findViewById(R.id.textviewNameQuizThis)
      private val textviewNameQuestion: TextView = itemView.findViewById(R.id.textviewNameQuestion)


      private var itemId: Int = -1

      fun onBind(quiz: QuizWithQuesEntities) {
          itemId = quiz.quizThis.id
          textviewNameQuizThis.text = quiz.quizThis.title

          for (question in quiz.otherEntities) {

              textviewNameQuestion.text = question.nameQuestion


          }
      }
  }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.itemrecyquestion, parent, false)
        return QuestionViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return  quizList.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val quiz = quizList[position]
        holder.onBind(quiz)
//        holder.onBind(question[position])
//        holder.itemView.setOnClickListener {
//            onClick(question[position], question[position].id )// Truyền ID của mục vào hàm OnItemClick
//        }
    }
    fun setData(quizList: List<QuizWithQuesEntities>) {
        this.quizList = quizList

        notifyDataSetChanged()
    }

}