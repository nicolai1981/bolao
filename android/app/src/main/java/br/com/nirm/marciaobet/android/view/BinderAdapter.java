package br.com.nirm.marciaobet.android.view;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.nirm.marciaobet.android.R;
import br.com.nirm.marciaobet.android.model.BetModel;

public class BinderAdapter {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get()
               .load(imageUrl)
               .placeholder(R.drawable.ic_download_error)
               .into(view);
    }

    @BindingAdapter({"betList"})
    public static void bindList(RecyclerView view, ObservableArrayList<BetModel.Bet> betList) {
        view.setAdapter(new BetAdapter(betList));
    }
}
