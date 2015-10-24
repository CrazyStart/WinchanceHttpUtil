/*
 * Copyright 2015 LuMeng
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Layout;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Because it is a common utils, so we just consider common elements in ListView.
 * ImageView, TextView, Button and so on.
 *
 * We add some common method in this class.
 *
 * You can {@link #setText(int, String)} for TextView or Button
 *         {@link #setImageResource(int, int)} for ImageView
 *         {@link #setImageBitmap(int, Bitmap)} for ImageView
 *
 * We will add more elements in the future.
 *
 * @author L.M
 * @version 1.0.2
 */
public class ViewHolder {
    private final SparseArray<View> views;

    private int position;

    private View convertView;

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.position = position;
        this.views = new SparseArray<View>();
        convertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        convertView.setTag(this);
    }

    /**
     * Get a ViewHolder
     *
     * @param context context
     * @param convertView convertView
     * @param parent parent
     * @param layoutId layoutId of item
     * @param position position of item
     * @return 1.new ViewHolder if convertView is null
     *         2.a ViewHolder get by tag
     */
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    public View getConvertView() {
        return convertView;
    }

    /**
     * Get view through viewId, add new view if it don's exist
     * @param viewId id of the view
     * @param <T> T
     * @return T type of {@link View}
     */
    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * Set text for {@link TextView}
     * @param viewId id of view
     * @param text content of text
     */
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        view.setText(text);
        return this;
    }

    /**
     * Use resource id to set Image for {@link ImageView}
     * @param viewId id of view
     * @param drawableId resource id
     */
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * Use {@link Bitmap} to set Image for {@link ImageView}
     * @param viewId id of view
     * @param bitmap bitmap
     */
    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bitmap);

        return this;
    }

    /**
     * Get position of item in it's parent
     */
    public int getPosition() {
        return position;
    }
}
