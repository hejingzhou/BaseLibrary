package com.he.baselibrary.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import com.he.baselibrary.databinding.TitleLayoutBinding


/**
 * Company:看大医(北京)科技发展有限公司
 *
 * Date:2020/9/23 14:53
 *
 * Author:HeJingzhou
 *
 * Email:tcoywork@163.com
 *
 * Description:
 */
class TitleView(context: Context, attributeSet: AttributeSet) :
    RelativeLayout(context, attributeSet) {

    private var titleLayout: View? = null
    private val mViewBinding = TitleLayoutBinding.inflate(LayoutInflater.from(context), null, false)
    private var onTitleListener: TitleListener? = null
    private var mViewRoot: RelativeLayout? = null
    private var mImgIcon: ImageView? = null
    private var mViewStatus: ViewStatus? = null

    init {
        titleLayout = mViewBinding.root
        mViewRoot = mViewBinding.mRoot
        mImgIcon = mViewBinding.mImgIcon
        mViewStatus = mViewBinding.mViewStatus
        addView(titleLayout)
        mViewBinding.mImgBack.setOnClickListener {
            if (onTitleListener != null) {
                onTitleListener?.titleBack()
            }
        }
        mImgIcon?.setOnClickListener {
            onTitleListener?.rightIconClick()
        }
    }

    fun getViewStatus(): ViewStatus {
        return mViewStatus!!
    }

    fun hintViewStatus(): TitleView {
        mViewBinding.mViewStatus.visibility = View.GONE
        return this
    }

    fun setTitle(title: String): TitleView {
        mViewBinding.mTvTitle.text = title
        return this
    }

    fun setTitle(title: String, onTitleListener: TitleListener): TitleView {
        mViewBinding.mTvTitle.text = title
        this.onTitleListener = onTitleListener
        return this
    }


    /**
     * 显示隐藏线
     */
    fun hintBottomLine(): TitleView {
        mViewBinding.mViewLine.visibility = GONE
        return this
    }

    /**
     * 设置Title事件监听
     */
    fun setTitleListener(onTitleListener: TitleListener): TitleView {
        this.onTitleListener = onTitleListener
        return this
    }

    /**
     * 设置背景色
     */
    fun setBgColor(color: Int): TitleView {
        mViewRoot?.setBackgroundColor(color)
        hintBottomLine()
        return this
    }

    /**
     * 设置TitleColor
     */
    fun setTitleTextColor(color: Int): TitleView {
        mViewBinding.mTvTitle.setTextColor(color)
        return this
    }

    /**
     * 设置返回键颜色
     */
    fun setBackIconColor(color: Int): TitleView {
        mViewBinding.mImgBack.setColorFilter(color)
        return this
    }

    /**
     * 隐藏发挥按钮
     */
    fun hiddenBackIcon(hidden: Boolean): TitleView {
        mViewBinding.mImgBack.visibility = if (hidden) View.GONE else View.VISIBLE
        return this
    }

    /**
     * 设置右边按钮
     */
    fun setRightIcon(imgRes: Int): TitleView {
        mImgIcon?.setImageResource(imgRes)
        return this
    }

    abstract class TitleListener {

        /**
         * 返回
         */
        abstract fun titleBack()

        /**
         * 右Icon点击
         */
        abstract fun rightIconClick()

    }

}