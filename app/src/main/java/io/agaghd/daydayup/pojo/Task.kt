package io.agaghd.daydayup.pojo

/**
 * 任务对象
 * id:id
 * name：名称
 * point：分数
 * description:描述
 */
data class Task(
    var id: Long,
    val imgRes: Int,
    var name: String,
    var point: Int,
    var description: String,
    var completed: Boolean
)
