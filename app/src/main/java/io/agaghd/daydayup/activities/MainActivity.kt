package io.agaghd.daydayup.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.text.TextUtils
import android.widget.Toast
import io.agaghd.daydayup.R
import io.agaghd.daydayup.adapter.TaskAdapter
import io.agaghd.daydayup.model.TaskModel
import io.agaghd.daydayup.pojo.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    fun initView() {
        taskAdapter = TaskAdapter()
        val linearLayoutManager = LinearLayoutManager(this)
        task_rv.layoutManager = linearLayoutManager
        task_rv.itemAnimator = DefaultItemAnimator()
        task_rv.adapter = taskAdapter
        taskAdapter.compelteCallback = object : TaskAdapter.CompleteCallback {
            override fun onTaskStateChanged(task: Task) {
                score_tv.text = "今日得分: " + TaskModel.getPoint()
            }
        }
    }

    fun initData() {
        TaskModel.init()
        taskAdapter.datas = TaskModel.taskList
        score_tv.text = "今日得分: " + TaskModel.getPoint()
    }
}
