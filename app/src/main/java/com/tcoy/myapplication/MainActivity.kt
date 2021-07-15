package com.tcoy.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log.i
import com.he.baselibrary.BaseLibraryManager
import com.he.baselibrary.utils.L
import com.he.baselibrary.view.TitleView
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BaseLibraryManager.init(this,true)
        findViewById<TitleView>(R.id.mTitleView).setTitle("哈哈哈").hintViewStatus()
    }
}