package com.tcoy.myapplication

import android.os.Bundle
import androidx.core.content.ContextCompat
import com.he.baselibrary.BaseLibraryManager
import com.he.baselibrary.base.RootActivity
import com.he.baselibrary.view.TitleView

class MainActivity : RootActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BaseLibraryManager.init(this, true)
        val titleView = findViewById<TitleView>(R.id.mTitleView)
        titleView.fullScreen(this, false).setTitle("测试标题").getViewStatus().setColor(
            ContextCompat.getColor(this, R.color.color_test)
        )

    }
}