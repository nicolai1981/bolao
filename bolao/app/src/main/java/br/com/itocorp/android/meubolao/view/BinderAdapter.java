package br.com.itocorp.android.meubolao.view;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import br.com.itocorp.android.meubolao.R;

public class BinderAdapter {
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.get()
                .load(imageUrl)
                .placeholder(R.drawable.ic_download_error)
                .into(view);
    }

}
