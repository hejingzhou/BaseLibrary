package com.he.baselibrary;

import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Company:看大医(北京)科技发展有限公司
 * <p>
 * Date:2021/7/14 18:18
 * <p>
 * Author:HeJingzhou
 * <p>
 * Email:tcoywork@163.com
 * <p>
 * Description:
 */
public class BaseLibraryManager {

    public static Context mContext = null;
    public static boolean mIsOpenDebug = false;


    /**
     * 初始化Sdk
     *
     * @param context context : Application
     */
    public static void init(Context context, boolean isOpenDebug) {
        mContext = context;
        mIsOpenDebug = isOpenDebug;
        Logger.addLogAdapter(new AndroidLogAdapter());
    }


}
