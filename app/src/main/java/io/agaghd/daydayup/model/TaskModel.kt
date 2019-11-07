package io.agaghd.daydayup.model

import io.agaghd.daydayup.R
import io.agaghd.daydayup.pojo.Task

object TaskModel {
    val taskList = ArrayList<Task>()

    fun init() {
        taskList.clear()
        taskList.add(Task(0, R.drawable.icon_sleep, "充分睡眠", 10, "早睡早起，方能养生!", false))
        taskList.add(Task(1, R.drawable.icon_breakfast, "吃早饭", 5, "一日之计在于晨!", false))
        taskList.add(Task(2, R.drawable.icon_cooking, "早饭自炊", 5, "一晨之计在于饭!", false))
        taskList.add(Task(3, R.drawable.icon_walking, "走路上班", 5, "走れ!走れ!僕たち!", false))
        taskList.add(Task(4, R.drawable.icon_clock, "不迟到", 5, "I won't be late!", false))
        taskList.add(Task(5, R.drawable.icon_code, "LeetCode", 10, "I'm Geek!", false))
        taskList.add(Task(6, R.drawable.icon_laptop, "工作有优质产出", 10, "Work Work!", false))
        taskList.add(Task(7, R.drawable.icon_book, "新的知识收获", 10, "量变引起质变!", false))
        taskList.add(Task(8, R.drawable.icon_launch, "吃午饭", 5, "民以食为天，食以味为先!", false))
        taskList.add(Task(9, R.drawable.icon_dinner, "吃晚饭", 5, "吃饱好赚钱！", false))
        taskList.add(Task(10, R.drawable.icon_dinner, "晚饭自炊", 5, "自给自足！", false))
        taskList.add(Task(11, R.drawable.icon_calories, "低卡晚饭", 5, "管住嘴！", false))
        taskList.add(Task(12, R.drawable.icon_dumbbell, "锻炼", 10, "多动腿!", false))
        taskList.add(Task(13, R.drawable.icon_desk_lamp, "晚自习", 10, "生无所息!", false))
    }

    fun getPoint(): Int {
        var result = 0
        for (task in taskList) {
            if (task.completed) {
                result += task.point
            }
        }
        return result
    }
}