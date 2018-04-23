package br.com.nirm.marciaobet.android.view;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.nirm.marciaobet.android.R;
import br.com.nirm.marciaobet.android.databinding.DialogBetBinding;
import br.com.nirm.marciaobet.android.databinding.ItemBetBinding;
import br.com.nirm.marciaobet.android.model.BetModel;

public class BetAdapter extends RecyclerView.Adapter<BetAdapter.ViewHolder> {
    private ObservableArrayList<BetModel.Bet> mBetList;

    public BetAdapter(ObservableArrayList<BetModel.Bet> list) {
        mBetList = list;
    }

    @NonNull
    @Override
    public BetAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BetModel.Bet bet = mBetList.get(position);
        holder.mBinder.setBet(bet);
        holder.mBinder.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mBetList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBetBinding mBinder;

        public ViewHolder(View view) {
            super(view);
            mBinder = DataBindingUtil.bind(view);
            mBinder.getRoot().findViewById(R.id.text_bet1).setOnClickListener((View v) -> {
                teste(view.getContext(), mBinder.getBet(), true);
            });
            mBinder.getRoot().findViewById(R.id.text_bet2).setOnClickListener((View v) -> {
                teste(view.getContext(), mBinder.getBet(), false);
            });
        }
    }

    private void teste(Context context, BetModel.Bet bet, boolean isTeam1) {
        final DialogBetBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context),
                R.layout.dialog_bet, null, false);
        binding.setBet(bet);
        binding.setIsTeam1(isTeam1);

        new AlertDialog.Builder(context)
                .setView(binding.getRoot())
                .setTitle(R.string.dialog_bet_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editText = binding.getRoot().findViewById(R.id.edit_text_bet);
                        if (binding.getIsTeam1()) {
                            binding.getBet().setBetScore1(Integer.valueOf(editText.getText().toString()));
                        } else {
                            binding.getBet().setBetScore2(Integer.valueOf(editText.getText().toString()));
                        }
                    }
                })
                .setNegativeButton(android.R.string.cancel, null)
                .create()
                .show();
    }
}
