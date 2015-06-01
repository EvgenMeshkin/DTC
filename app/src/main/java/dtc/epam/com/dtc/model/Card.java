package dtc.epam.com.dtc.model;

import android.provider.BaseColumns;

import dtc.epam.com.dtc.R;
import dtc.epam.com.dtc.holder.CommonHolder;
import dtc.epam.com.dtc.holder.GoldHolder;
import dtc.epam.com.dtc.holder.PlatinumHolder;
import dtc.epam.com.dtc.holder.UltimateHolder;


public class Card implements BaseColumns {

    public static enum Type {
        ULTIMATE(UltimateHolder.class, R.layout.holder_ultimate),
        PLATINUM(PlatinumHolder.class, R.layout.holder_platinum),
        GOLD(GoldHolder.class, R.layout.holder_gold),
//        SQUARE_IMAGE_TEXT(SquareImageTextHolder.class, R.layout.holder_square_image_text),

        ;

        private Class<? extends CommonHolder> mHolderClass;

        private int mLayout;

        Type(Class<? extends CommonHolder> holderClass, int layout) {
            mHolderClass = holderClass;
            mLayout = layout;
        }

        public Class<? extends CommonHolder> getHolderClass() {
            return mHolderClass;
        }

        public int getLayout() {
            return mLayout;
        }
    }


}
