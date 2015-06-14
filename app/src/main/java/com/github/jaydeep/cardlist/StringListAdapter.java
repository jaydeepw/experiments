package com.github.jaydeep.cardlist;


import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class StringListAdapter extends RecyclerView.Adapter<StringListAdapter.ViewHolder> {

    private final View.OnClickListener mConvertCardListener;
    private final View.OnClickListener mDeletedCardListener;
    public ArrayList<String> data;

    public StringListAdapter(ArrayList<String> data, View.OnClickListener convertCardListener,
                             View.OnClickListener deleteCardListener) {
        this.data = data;
        mConvertCardListener = convertCardListener;
        mDeletedCardListener = deleteCardListener;
    }

    @Override
    public StringListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scanned_card_plank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StringListAdapter.ViewHolder holder, int position) {
        holder.cardNote.setText(data.get(position));
        holder.convertCard.setOnClickListener(mConvertCardListener);
        holder.deleteCard.setOnClickListener(mDeletedCardListener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void add(String string) {
        insert(string, data.size());
    }

    public void insert(String string, int position) {
        data.add(position, string);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = data.size();
        data.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void addAll(String[] strings) {
        int startIndex = data.size();
        data.addAll(startIndex, Arrays.asList(strings));
        notifyItemRangeInserted(startIndex, strings.length);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cardNote;
        public ImageView cardImage;
        public Button convertCard;
        public Button deleteCard;

        public ViewHolder(View itemView) {
            super(itemView);
            cardNote = (TextView) itemView.findViewById(R.id.textview_card_note);
            cardImage = (ImageView) itemView.findViewById(R.id.card_image);
            convertCard = (Button) itemView.findViewById(R.id.btn_convert_to_contact);
            deleteCard = (Button) itemView.findViewById(R.id.btn_delete);
        }
    }
}
