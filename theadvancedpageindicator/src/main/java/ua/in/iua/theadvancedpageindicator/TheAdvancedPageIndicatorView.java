package ua.in.iua.theadvancedpageindicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * VUDUU application.
 * Created by rusin on 04.12.15.
 */
public class TheAdvancedPageIndicatorView extends View {

    private Drawable mInactiveIndicator = new ColorDrawable();
    private Drawable mSelectedIndicator = new ColorDrawable();
    private int mIndicatorPadding = 0;
    private int mIndicatorsCount = 5;

    private int mIndicatorSize = 10;
    private int mCurrentSelectedItem = 0;

    public TheAdvancedPageIndicatorView(Context context) {
        super(context);
    }

    public TheAdvancedPageIndicatorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public TheAdvancedPageIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TheAdvancedPageIndicatorView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.TheAdvancedPageIndicatorView,
                0, 0);
        try {
            mIndicatorsCount = a.getInt(R.styleable.TheAdvancedPageIndicatorView_indicatorsCount, 5);
            mIndicatorSize = a.getDimensionPixelSize(R.styleable.TheAdvancedPageIndicatorView_indicatorSize, 5);
            mIndicatorPadding = a.getDimensionPixelSize(R.styleable.TheAdvancedPageIndicatorView_indicatorPadding, 5);
            mIndicatorSize = mIndicatorSize + mIndicatorPadding;

            try {
                mInactiveIndicator = a.getDrawable(R.styleable.TheAdvancedPageIndicatorView_indicatorInactiveDrawable);
            } catch (UnsupportedOperationException e) {
                if (Build.VERSION.SDK_INT >= 21) {
                    mInactiveIndicator = context.getResources().getDrawable(R.drawable.page_indicator_inactive, context.getTheme());
                } else {
                    mInactiveIndicator = context.getResources().getDrawable(R.drawable.page_indicator_inactive);
                }
            }
            try {
                mSelectedIndicator = a.getDrawable(R.styleable.TheAdvancedPageIndicatorView_indicatorSelectedDrawable);
            } catch (UnsupportedOperationException e) {
                if (Build.VERSION.SDK_INT >= 21) {
                    mSelectedIndicator = context.getResources().getDrawable(R.drawable.page_indicator_selected, context.getTheme());
                } else {
                    mSelectedIndicator = context.getResources().getDrawable(R.drawable.page_indicator_selected);
                }
            }
        } finally {
            a.recycle();
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //Get size requested and size mode
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width, height;

        //Determine Width
        switch (widthMode) {
            case MeasureSpec.EXACTLY:
                width = widthSize;
                break;
            case MeasureSpec.AT_MOST:
                width = Math.min((mIndicatorsCount * (mIndicatorSize + mIndicatorPadding) - mIndicatorPadding), widthSize);
                break;
            case MeasureSpec.UNSPECIFIED:
            default:
                width = mIndicatorSize * mIndicatorSize;
                break;
        }

        //Determine Height
        switch (heightMode) {
            case MeasureSpec.EXACTLY:
                height = heightSize;
                break;
            case MeasureSpec.AT_MOST:
                height = Math.min(mIndicatorSize, heightSize);
                break;
            case MeasureSpec.UNSPECIFIED:
            default:
                height = mIndicatorSize;
                break;
        }

        setMeasuredDimension(width, height);
    }

    public void setCurrentSelectedItem(int itemIndex) {
        if (itemIndex >= 0 && itemIndex < mIndicatorsCount) {
            mCurrentSelectedItem = itemIndex;
            invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int left = 0;
        int top = 0;
        int right = 0;
        int bottom = mIndicatorSize;

        for (int i = 0; i < mIndicatorsCount; i++) {
            right = left + mIndicatorSize;

            if (mCurrentSelectedItem == i) {
                mSelectedIndicator.setBounds(left, top, right, bottom);
                mSelectedIndicator.draw(canvas);
            } else {
                mInactiveIndicator.setBounds(left, top, right, bottom);
                mInactiveIndicator.draw(canvas);
            }

            left += mIndicatorSize + mIndicatorPadding;
        }
    }
}
