package example.com.library.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/6/21 0021.
 * 首选项工具类
 */

public class SaveSharedPreferencesUtil {
    private static final String PFNAME = "save_shared_preferences";

    /**
     * 保存信息
     *
     * @param context 上下文
     * @param key     键
     * @param value   值
     */
    public static void save(Context context, String key, Object value) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        //判断要保存的数据
        if (value instanceof String) {
            sp.edit().putString(key, (String) value).apply();
        } else if (value instanceof Integer) {
            sp.edit().putInt(key, (int) value).apply();
        } else if (value instanceof Boolean) {
            sp.edit().putBoolean(key, (boolean) value).apply();
        } else if (value instanceof Float) {
            sp.edit().putFloat(key, (Float) value).apply();
        }
    }

    /**
     * 获取String类型的数据
     *
     * @param context 上下文
     * @param key     键
     * @return 返回值
     */
    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        return sp.getString(key, "");
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        return sp.getString(key, defValue);
    }

    /**
     * 获取int类型的数据
     *
     * @param context
     * @param key
     * @return
     */
    public static Integer getInt(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        return sp.getInt(key, 0);
    }

    public static Integer getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        return sp.getInt(key, defValue);
    }

    /**
     * 获取float类型数据
     *
     * @param context
     * @param key
     * @return
     */
    public static Float getFloat(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        return sp.getFloat(key, 0);
    }

    public static Float getFloat(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        return sp.getFloat(key, defValue);
    }

    /**
     * 获取boolean类型数据
     *
     * @param context
     * @param key
     * @return
     */
    public static Boolean getBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        return sp.getBoolean(key, false);
    }

    public static Boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        return sp.getBoolean(key, defValue);
    }


    /**
     * 删除首选项中的数据
     *
     * @param context
     * @param key
     */
    public static void deleteData(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(PFNAME, 0);
        sp.edit().remove(key).commit();
    }

}
