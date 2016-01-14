package com.example.dongja94.samplecustomlist;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dongja94 on 2016-01-14.
 */
public class PersonView extends FrameLayout {
    public PersonView(Context context) {
        super(context);
        init();
    }

    ImageView iconView;
    TextView nameView, descriptionView;
    Person person;

    public interface OnImageClickListener {
        public void onImageClick(PersonView view, Person person);
    }
    OnImageClickListener mImageClickListener;
    public void setOnImageClickListener(OnImageClickListener listener) {
        mImageClickListener = listener;
    }

    private void init() {
        inflate(getContext(), R.layout.view_person, this);
        iconView = (ImageView)findViewById(R.id.image_icon);
        nameView = (TextView)findViewById(R.id.text_name);
        descriptionView = (TextView)findViewById(R.id.text_description);

        iconView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImageClickListener != null) {
                    mImageClickListener.onImageClick(PersonView.this, person);
                }
            }
        });
    }

    public void setPerson(Person p) {
        person = p;
        if (p.getIcon() != null) {
            iconView.setImageDrawable(p.getIcon());
        } else {
            iconView.setImageResource(R.mipmap.ic_launcher);
        }
        nameView.setText(p.getNameAndAge());
        descriptionView.setText(p.getDescription());
    }
}
