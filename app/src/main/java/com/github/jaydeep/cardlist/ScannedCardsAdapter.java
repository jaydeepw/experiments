package com.github.jaydeep.cardlist;


import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.intouchapp.models.ScannedCard;

import java.util.ArrayList;

public class ScannedCardsAdapter extends RecyclerView.Adapter<ScannedCardsAdapter.ViewHolder> {

    private final View.OnClickListener mConvertCardListener;
    private final View.OnClickListener mDeletedCardListener;
    private final View.OnClickListener mCardClickListener;
    public ArrayList<ScannedCard> data;

    public ScannedCardsAdapter(ArrayList<ScannedCard> data, View.OnClickListener cardLClickistener,
                               View.OnClickListener convertCardListener,
                               View.OnClickListener deleteCardListener) {
        this.data = data;
        mCardClickListener = cardLClickistener;
        mConvertCardListener = convertCardListener;
        mDeletedCardListener = deleteCardListener;
    }

    @Override
    public ScannedCardsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.scanned_card_plank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScannedCardsAdapter.ViewHolder holder, int position) {
        ScannedCard scannedCard = data.get(position);

        // show note for the card if available.
        if (scannedCard != null) {
            String note = scannedCard.getNote();
            if (!TextUtils.isEmpty(note)) {
                holder.cardNote.setText(note);
            }
        }

        holder.cardImage.setTag(scannedCard);
        holder.cardImage.setOnClickListener(mCardClickListener);

        holder.convertCard.setTag(scannedCard);
        holder.convertCard.setOnClickListener(mConvertCardListener);

        holder.deleteCard.setTag(scannedCard);
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

    public void remove(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void clear() {
        int size = data.size();
        data.clear();
        notifyItemRangeRemoved(0, size);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView cardNote;
        public ImageView cardImage;
        public Button convertCard, deleteCard;

        public ViewHolder(View itemView) {
            super(itemView);
            cardNote = (TextView) itemView.findViewById(R.id.textview_card_note);
            cardImage = (ImageView) itemView.findViewById(R.id.card_image);
            convertCard = (Button) itemView.findViewById(R.id.btn_convert_to_contact);
            deleteCard = (Button) itemView.findViewById(R.id.btn_delete);
        }
    }
}
