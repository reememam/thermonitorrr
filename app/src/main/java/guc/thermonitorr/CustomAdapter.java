package guc.thermonitorr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends ArrayAdapter<String> {
    public CustomAdapter(Context context, String[] strings) {

        super(context, R.layout.customlist, strings);

    }
    @Override
    public View getView(int i , View v , ViewGroup vg){
        View customList = LayoutInflater.from(getContext()).inflate(R.layout.customlist,vg,false);
        TextView textView = customList.findViewById(R.id.textView4);
        ImageView imageView = customList.findViewById(R.id.imageView2);
        String s = getItem(i);
        textView.setText(s);
        switch (s){
            case "SQL":
                imageView.setImageResource(R.drawable.sql);
               break;
            case "JAVA":
                imageView.setImageResource(R.drawable.java);
                break;
            case "JAVASCRIPT":
                imageView.setImageResource(R.drawable.javascript);
                break;
            case"C#":
                imageView.setImageResource(R.drawable.csharp);
                break;
            case "PYTHON":
                imageView.setImageResource(R.drawable.python);
                break;
            case"C++":
                imageView.setImageResource(R.drawable.cplusplus);
                break;
            case "PHP":
                imageView.setImageResource(R.drawable.php);
                break;
        }
        return customList;
    }
}
