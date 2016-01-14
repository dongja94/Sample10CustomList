package com.example.dongja94.samplecustomlist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dongja94 on 2016-01-14.
 */
public class PersonAdapter extends BaseAdapter implements PersonView.OnImageClickListener {
    List<Person> items = new ArrayList<Person>();

    public PersonAdapter() {
    }

    public void add(Person p) {
        items.add(p);
        notifyDataSetChanged();
    }

    public void addAll(List<Person> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void remove(Person p) {
        items.remove(p);
        notifyDataSetChanged();
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public void sort(Comparator<Person> comparator) {
        Collections.sort(items, comparator);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Person getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PersonView view;
        if (convertView == null) {
            view = new PersonView(parent.getContext());
            view.setOnImageClickListener(this);
        } else {
            view = (PersonView)convertView;
        }
        view.setPerson(items.get(position));
        return view;
    }

    public interface OnAdapterItemClickListener {
        public void onAdapterItemImageClick(PersonAdapter adapter, PersonView view, Person person, int position);
    }
    OnAdapterItemClickListener mAdapterListener;
    public void setOnAdapterItemClickListener(OnAdapterItemClickListener listener) {
        mAdapterListener = listener;
    }

    @Override
    public void onImageClick(PersonView view, Person person) {
        if (mAdapterListener != null) {
            int index = items.indexOf(person);
            mAdapterListener.onAdapterItemImageClick(this, view, person, index);
        }
    }
}
