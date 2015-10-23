package widget;

import android.util.SparseArray;
import android.view.View;

/**
 * @author L.M
 * @since 1.0.0
 */
public class ViewHolder {
    private final SparseArray<View> views;
    private View convertView;

    public ViewHolder(View convertView) {
        this.views = new SparseArray<View>();
        this.convertView = convertView;
        convertView.setTag(this);
    }

    public static ViewHolder get(View convertView) {
        if (convertView == null) {
            return new ViewHolder(convertView);
        }
        ViewHolder existedHolder = (ViewHolder) convertView.getTag();
        return existedHolder;
    }

    public <T extends View> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }
}
