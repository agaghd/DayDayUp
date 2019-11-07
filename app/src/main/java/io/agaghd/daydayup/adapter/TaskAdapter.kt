package io.agaghd.daydayup.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import io.agaghd.daydayup.R
import io.agaghd.daydayup.pojo.Task

class TaskAdapter : RecyclerView.Adapter<TaskAdapter.MyHolder>() {

    var datas = ArrayList<Task>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    lateinit var compelteCallback: CompleteCallback

    override fun onCreateViewHolder(container: ViewGroup, p1: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(container.context).inflate(
                R.layout.item_task,
                container,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(myHolder: MyHolder, position: Int) {
        val task = datas[position]
        myHolder.iconIv.setImageResource(task.imgRes)
        myHolder.nameTv.text = task.name
        myHolder.discriptionTv.text = task.description
        myHolder.completeBtn.setOnClickListener {
            task.completed = true
            compelteCallback.onTaskStateChanged(task)
            notifyItemChanged(position)
        }
        myHolder.completeBtn.isEnabled = !task.completed
        myHolder.completeBtn.text = if (task.completed) ("+ " + task.point) else "完成"
        myHolder.pointTv.text = if (task.completed) "" else task.point.toString()
    }

    class MyHolder(view: View) : RecyclerView.ViewHolder(view) {
        val iconIv: ImageView = view.findViewById(R.id.icon_iv)
        val nameTv: TextView = view.findViewById(R.id.name_tv)
        val discriptionTv: TextView = view.findViewById(R.id.discription_tv)
        val completeBtn: Button = view.findViewById(R.id.complete_btn)
        val pointTv: TextView = view.findViewById(R.id.point_tv)
    }

    interface CompleteCallback {
        fun onTaskStateChanged(task: Task)
    }

}