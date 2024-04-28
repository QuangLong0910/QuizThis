package quanglong.ph27075.gceagle.Adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import quanglong.ph27075.gceagle.Model.QuizThis
import quanglong.ph27075.gceagle.R


class AdapterRecycleview(
    private val context: Context,
    private val onClick: (QuizThis) -> Unit,
    private val onDelete: (QuizThis) -> Unit

) : RecyclerView.Adapter<AdapterRecycleview.QuizThisViewHolder>() {
    private var quizThis: List<QuizThis> = listOf()

    inner class QuizThisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTen: TextView = itemView.findViewById(R.id.tvitem)
        private val image: TextView = itemView.findViewById(R.id.imageView)

        private val layoutitem: LinearLayout = itemView.findViewById(R.id.layoutitem)
        fun onBind(quizThis: QuizThis) {
            tvTen.text = quizThis.title
            image.text = quizThis.description
            layoutitem.setOnClickListener { onClick(quizThis) }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizThisViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_recy, parent, false)
        return QuizThisViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return quizThis.size

    }

    override fun onBindViewHolder(holder: QuizThisViewHolder, position: Int) {
        holder.onBind(quizThis[position])
    }

    fun setData(quizThis: List<QuizThis>) {
        this.quizThis = quizThis
        Log.d("Sai",quizThis.toString())
        notifyDataSetChanged()
    }


}