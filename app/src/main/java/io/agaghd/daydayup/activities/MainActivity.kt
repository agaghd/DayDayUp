package io.agaghd.daydayup.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.agaghd.daydayup.R
import io.agaghd.daydayup.pojo.Task

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var testTask = Task(2, "ss", 2, "ttt")
    }
}
