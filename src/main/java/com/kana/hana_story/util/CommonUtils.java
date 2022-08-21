package com.kana.hana_story.util;

import com.kana.hana_story.hana_story;

/**
 * @author kana
 * @decription TODO
 * @date 2022/8/20 17:09
 */
public class CommonUtils {


    public CommonUtils()
    {

    }


    public String getRegisteryName(String itemName)
    {
        if (itemName == null)
        {
            throw new NullPointerException();
        }
        return hana_story.MODID + ":" + itemName;
    }
}
