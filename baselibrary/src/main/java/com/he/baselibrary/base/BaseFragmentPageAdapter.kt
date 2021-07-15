package com.he.baselibrary.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Company:看大医(北京)科技发展有限公司
 *
 * Date:2020/9/21 17:11
 *
 * Author:HeJingzhou
 *
 * Email:tcoywork@163.com
 *
 * Description:
 */
open class BaseFragmentPageAdapter(
    var titleList: MutableList<String>,
    fm: FragmentManager,
    var fragmentList: MutableList<Fragment>
) :
    FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titleList[position]
    }
}