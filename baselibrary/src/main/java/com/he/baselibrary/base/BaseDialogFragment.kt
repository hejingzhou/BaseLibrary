package com.he.baselibrary.base

import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.view.Gravity
import android.view.ViewGroup
import android.view.WindowManager


/**
 * Company:看大医(北京)科技发展有限公司
 *
 * Date:2020/9/18 11:52
 *
 * Author:HeJingzhou
 *
 * Email:tcoywork@163.com
 *
 * Description: BaseDialog
 */
open class BaseDialogFragment(context: Context, style: Int) : Dialog(context, style) {

    /**
     * 判断当前软键盘是否打开
     *
     * @return
     */
    open fun isSoftShowing(): Boolean {
        //获取当前屏幕内容的高度
        val screenHeight = window!!.decorView.height
        //获取View可见区域的bottom
        val rect = Rect()
        window!!.decorView.getWindowVisibleDisplayFrame(rect)
        return screenHeight - rect.bottom != 0
    }


    override fun show() {
        if (window != null) {
            this.window!!.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            )
        }
        super.show()
        this.window!!.clearFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE)
        val layoutParams = window!!.attributes
        if (layoutParams != null) {
            layoutParams.gravity = Gravity.CENTER
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
            layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
            window!!.decorView.setPadding(0, 0, 0, 0)
            window!!.attributes = layoutParams
        }
    }

    /**
     * 获取状态栏高度
     * @param context
     * @return
     */
    open fun getStatusBarHeight(context: Context): Int {
        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier("status_bar_height", "dimen", "android")
        return resources.getDimensionPixelSize(resourceId)
    }

}