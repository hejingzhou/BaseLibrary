package com.he.baselibrary.utils

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.he.baselibrary.BaseLibraryManager

/**
 * Company:看大医(北京)科技发展有限公司
 *
 * Date:2021/7/15 10:57
 *
 * Author:HeJingzhou
 *
 * Email:tcoywork@163.com
 *
 * Description:
 */

/**
 * 获取状态栏高度
 */
fun getStatusBarHeight(): Int {
    var result = 0
    val resourceId =
        BaseLibraryManager.mContext.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        result = BaseLibraryManager.mContext.resources.getDimensionPixelSize(resourceId)
    }
    return result
}


fun Int.dp(): Int {
    val scale = BaseLibraryManager.mContext.resources.displayMetrics.density
    return ((this * scale + 0.5f).toInt())
}

fun Float.dp(): Int {
    val scale = BaseLibraryManager.mContext.resources.displayMetrics.density
    return ((this * scale + 0.5f).toInt())
}

fun Int.px(): Int {
    val scale = BaseLibraryManager.mContext.resources.displayMetrics.density
    return ((this / scale + 0.5f).toInt())
}

fun Float.px(): Int {
    val scale = BaseLibraryManager.mContext.resources.displayMetrics.density
    return ((this / scale + 0.5f).toInt())
}

/**
 * 绑定线性适配器
 */
fun RecyclerView.bindLinearVerticalAdapter(
    context: Context,
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
): RecyclerView.Adapter<RecyclerView.ViewHolder> {
    this.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
    this.adapter = adapter
    return adapter
}

/**
 * 绑定线性适配器
 */
fun RecyclerView.bindLinearHorizontalAdapter(
    context: Context,
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
): RecyclerView.Adapter<RecyclerView.ViewHolder> {
    this.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    this.adapter = adapter
    return adapter
}

/**
 * 绑定线性适配器倒叙
 */
fun RecyclerView.bindLinearAdapterByFlashBack(
    context: Context,
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
): RecyclerView.Adapter<RecyclerView.ViewHolder> {
    this.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, true)
    this.adapter = adapter
    return adapter
}

