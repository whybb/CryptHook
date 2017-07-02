package test.crypthook.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import test.crypthook.R;
import test.crypthook.bean.AppInfomation;


public class AppAdapter extends BaseAdapter {

    private List<AppInfomation> mlistAppInfo = null;

    LayoutInflater infater = null;

    public AppAdapter(Context context, List<AppInfomation> apps) {
        infater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mlistAppInfo = apps ;
    }

    @Override
    public int getCount() {

        System.out.println("size" + mlistAppInfo.size());
        return mlistAppInfo.size();
    }

    @Override
    public Object getItem(int position) {

        return mlistAppInfo.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup arg2) {
        System.out.println("getView at " + position);
        View view = null;
        ViewHolder holder = null;
        if (convertview == null || convertview.getTag() == null) {
            view = infater.inflate(R.layout.browse_app_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else{
            view = convertview ;
            holder = (ViewHolder) convertview.getTag() ;
        }
        AppInfomation appInfo = (AppInfomation) getItem(position);
        holder.appIcon.setImageDrawable(appInfo.getAppicon());
        holder.tvAppLabel.setText(appInfo.getAppname());
        holder.tvPkgName.setText(appInfo.getPackagename());
        holder.tvAppversionName.setText(appInfo.getVersionname());
        return view;
    }

    class ViewHolder {
        ImageView appIcon;
        TextView tvAppLabel;
        TextView tvPkgName;
        TextView tvAppversionName;

        public ViewHolder(View view) {
            this.appIcon = (ImageView) view.findViewById(R.id.imgApp);
            this.tvAppLabel = (TextView) view.findViewById(R.id.tvAppLabel);
            this.tvPkgName = (TextView) view.findViewById(R.id.tvPkgName);
            this.tvAppversionName=(TextView) view.findViewById(R.id.tvAppversionName);
        }
    }
}
