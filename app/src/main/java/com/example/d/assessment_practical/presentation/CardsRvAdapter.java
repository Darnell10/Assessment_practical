package com.example.d.assessment_practical.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.d.assessment_practical.MainActivity;
import com.example.d.assessment_practical.R;
import com.example.d.assessment_practical.model_packages.CardModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardsRvAdapter extends RecyclerView.Adapter<CardsRvAdapter.CardViewHolder> {


    List<CardModel> cardModelList;

    public CardsRvAdapter(List<CardModel> cardModelList) {
        this.cardModelList = cardModelList;
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_itemview,parent,false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        CardModel cardModel = cardModelList.get(position);
        holder.onBind(cardModel);

    }


    @Override
    public int getItemCount() {
        return cardModelList.size();
    }

    public void moreCards(List<CardModel> cardModels){

        cardModelList.addAll(cardModels);
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        private ImageView cardImageView;

        public CardViewHolder(View itemView) {
            super(itemView);

            cardImageView = itemView.findViewById(R.id.cards);


        }

        public void onBind(CardModel cardModel) {
            Picasso.with(itemView.getContext())
                    .load(cardModel.getImage())
                    .into(cardImageView);
            cardModel.getValue();
            cardModel.getSuit();
        }
    }


}

