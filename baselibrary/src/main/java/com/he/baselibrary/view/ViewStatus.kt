package com.he.baselibrary.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.he.baselibrary.databinding.ViewStatusLayoutBinding

/**
 * Company:看大医(北京)科技发展有限公司
 *
 * Date:2020/9/15 8:59
 *
 * Author:HeJingzhou
 *
 * Email:tcoywork@163.com
 *
 * Description: 状态栏填充
 */
class ViewStatus(context: Context?, attrs: AttributeSet?) : RelativeLayout(context, attrs) {
    private var mView: View? = null
    private var mViewBinding: ViewStatusLayoutBinding =
        ViewStatusLayoutBinding.inflate(LayoutInflater.from(context),null,false)

    init {
        mView = mViewBinding.root
        val layoutParams = mViewBinding.mStatusView.layoutParams
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
        layoutParams.height = getStatusBarHeight(context)
        mViewBinding.mStatusView.layoutParams = layoutParams
        addView(mView)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight(context))
    }

    /**
     * 设置背景颜色
     */
    fun setStatusBarColor(color: Int) {
        mView?.setBackgroundColor(color)
    }


    /**
     * 获取状态栏高度
     */
    private fun getStatusBarHeight(context: Context?): Int {
        var result = 0
        if (context != null) {
            val resourceId =
                context.resources.getIdentifier("status_bar_height", "dimen", "android")
            if (resourceId > 0) {
                result = context.resources.getDimensionPixelSize(resourceId)
            }
        }
        return result
    }

    /**
     * 设置颜色
     */
    fun setColor(color: Int) {
        mViewBinding.mStatusView.setBackgroundColor(color)
    }
}