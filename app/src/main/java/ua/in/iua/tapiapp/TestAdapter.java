package ua.in.iua.tapiapp;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * VUDUU application.
 * Created by rusin on 04.12.15.
 */
public class TestAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.content_test_item, container, false);

        TextView tvItem = (TextView) view.findViewById(R.id.tvItem);
        tvItem.setText(String.format("%d", position + 1));

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
