package com.example.loadingutilslibrary;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class LoadingUtils {

    private static LoadingUtils mUtils;
    private static Context mContext;

    private static Dialog mDialog;

    private static int mBackGroundRes;
    private static String mText;
    private static int mTextColorRes;
    private static int mTextSize;
    private static boolean mShowText;

    public static LoadingUtils init(Context context){

        if (mUtils == null){
            mUtils = new LoadingUtils();
        }
        mContext = context;

        setDefaultSettings();
        return mUtils;

    }

    private static void setDefaultSettings(){
        mBackGroundRes = R.drawable.utils_bg;
        mShowText = true;
        mText = "加载中...";
        mTextColorRes = android.R.color.white;
        mTextSize = 15;
    }

    private static void build(){

        mDialog = new Dialog(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.loading_dialog_layout,null);
        LinearLayout mBackGroundLayout = view.findViewById(R.id.loading_background_layout);
        TextView mTextView = view.findViewById(R.id.loading_dialog_title);

        mDialog.setContentView(view);
        Objects.requireNonNull(mDialog.getWindow()).setBackgroundDrawableResource(android.R.color.transparent);
        mDialog.setCanceledOnTouchOutside(false);

        mBackGroundLayout.setBackgroundResource(mBackGroundRes);
        if (mShowText){
            mTextView.setVisibility(View.VISIBLE);
            mTextView.setText(mText);
            mTextView.setTextColor(mContext.getResources().getColor(mTextColorRes));
            mTextView.setTextSize(mTextSize);
        }else {
            mTextView.setVisibility(View.GONE);
        }

        mDialog.show();

    }

    /**
     * 加载框背景
     * @param backGroundRes default #333333 Corner radius 6dp
     */
    public void setBackGroundRes(int backGroundRes){
        mBackGroundRes = backGroundRes;
    }

    /**
     * 是否显示加载文字
     * @param showText default true
     */
    public void showText(boolean showText){
        mShowText = showText;
    }

    /**
     * 加载文字
     * @param text default 加载中...
     */
    public void setText(String text){
        mText = text;

    }

    /**
     * 文字颜色
     * @param colorRes default #ffffff
     */
    public void setTextColorRes(int colorRes){
        mTextColorRes = colorRes;
    }


    /**
     * 字体大小
     * @param textSize default 15
     */
    public void setTextSize(int textSize){
        mTextSize = textSize;
    }

    /**
     * 开始加载动画
     */
    public void startLoading(){
        build();
    }

    /**
     * 停止动画
     */
    public void finishLoading(){
        if (mDialog != null){
            mDialog.dismiss();
            mDialog = null;
        }
    }

}
