package com.hungnt.funny.Dialogs;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hungnt.funny.R;


/**
 * Created by HungNT on 26/July/2015.
 */
public class ShareTweetDialog extends DialogFragment implements View.OnClickListener {

    private TextView tvContent;
    private View btClose,btSend;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_share_tweeter,container,false);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        getDialog().getWindow().requestFeature(STYLE_NO_TITLE);

        tvContent = (TextView) view.findViewById(R.id.tvContent);
        btClose = view.findViewById(R.id.btClose);
        btSend = view.findViewById(R.id.btSend);

        tvContent.setText(Html.fromHtml("Praesent <font color='#1889d7'>#commdo</font> cursus magna, vel nisl consectetur et <font color='#1889d7'>@msenyil</font>"));

        btClose.setOnClickListener(this);
        btSend.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int button = v.getId();
        if (button == R.id.btClose){
            getDialog().cancel();
        }
        else if (button == R.id.btSend){
            Log.d("DialogClass","Send clicked");
            getDialog().cancel();
        }
    }
}
