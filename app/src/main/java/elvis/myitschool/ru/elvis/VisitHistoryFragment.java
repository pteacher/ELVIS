package elvis.myitschool.ru.elvis;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by altairlab on 06.07.2017.
 */

public class VisitHistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.visit_history_fragment, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.customlist);
        CustomListAdapter adapter;
        String[] headingList = {"Дон Кихот",
                "Винни Пух",
                "Доктор Айболит",
                "Че Бурашка",
                "Железный Дровосек",

        };
        String[] subHeadingList = {"62 года, нужна кровь ветерану боевых действий",
                "Возраст неизвестен, получил многочисленные ушибы после падения с высоты",
                "65 лет, кровь нужна для животных",
                "7 лет, я ищу друзей",
                "Возраст неизвестен, кровь нужна для сердца, но его пока нет",
        };
        int[] imgList = {R.drawable.ic_blood,
                R.drawable.ic_blood,
                R.drawable.ic_blood,
                R.drawable.ic_blood,
                R.drawable.ic_blood,
        };
        adapter = new CustomListAdapter(headingList, subHeadingList, imgList, rootView.getContext());
        listView.setAdapter(adapter);
        return rootView;
    }

    private class CustomListAdapter extends BaseAdapter {

        private LayoutInflater mInflater;
        private String[] headingList;
        private String[] subHeadingList;
        private int[] imgList;

        public CustomListAdapter(String[] headingList, String[] subHeadingList, int[] imgList, Context context){
            mInflater = LayoutInflater.from(context);
            this.headingList = headingList;
            this.subHeadingList = subHeadingList;
            this.imgList = imgList;
        }

        @Override
        public int getCount() {
            return headingList.length;
        }

        @Override
        public Object getItem(int position) {
            return headingList[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            try{
                final ViewHolder holder;
                if(convertView == null){
                    convertView = this.mInflater.inflate(R.layout.my_text_view, parent, false);
                    holder = new ViewHolder();
                    holder.image = ((ImageView)convertView.findViewById(R.id.image));
                    holder.heading = ((TextView)convertView.findViewById(R.id.title));
                    holder.subHeading = ((TextView)convertView.findViewById(R.id.desc));
                    convertView.setTag(holder);
                }
                else{
                    holder = (ViewHolder)convertView.getTag();
                }
                holder.image.setBackgroundResource(imgList[position]);
                holder.heading.setText(headingList[position]);
                holder.subHeading.setText(subHeadingList[position]);
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }

            return convertView;
        }


    }
    static class ViewHolder{
        ImageView image;
        TextView heading;
        TextView subHeading;
    }
}
