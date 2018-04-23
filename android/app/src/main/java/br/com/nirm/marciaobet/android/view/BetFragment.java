package br.com.nirm.marciaobet.android.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;

import br.com.nirm.marciaobet.android.R;
import br.com.nirm.marciaobet.android.databinding.FragmentBetBinding;
import br.com.nirm.marciaobet.android.model.BetModel;
import br.com.nirm.marciaobet.android.model.UserModel;

public class BetFragment extends Fragment {
    private UserModel.User mUser;
    private LinearLayoutManager mLayoutManager;

    public BetFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentBetBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bet, container, false);
        mUser = new UserModel.User("Old Name", "https://icon-icons.com/icons2/510/PNG/256/person_icon-icons.com_50075.png");
        BetModel.Bet bet = new BetModel.Bet("place1");
        BetModel.Team team = new BetModel.Team("Germany", "https://cdn2.iconfinder.com/data/icons/world-flag-icons/256/Flag_of_Germany.png");
        bet.setTeam1(team);
        team = new BetModel.Team("Brazil", "https://cdn2.iconfinder.com/data/icons/world-flag-icons/256/Flag_of_Brazil.png");
        bet.setTeam2(team);
        Calendar calendar = Calendar.getInstance();
        bet.setDate(calendar.getTime());
        mUser.addBet(bet);
        bet = new BetModel.Bet("place2");
        calendar.add(Calendar.DAY_OF_YEAR, -10);
        calendar.add(Calendar.HOUR_OF_DAY, -5);
        calendar.add(Calendar.MINUTE, -50);
        bet.setDate(calendar.getTime());
        mUser.addBet(bet);
        bet = new BetModel.Bet("place3");
        calendar.add(Calendar.DAY_OF_YEAR, 4);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        calendar.add(Calendar.MINUTE, -43);
        bet.setDate(calendar.getTime());
        mUser.addBet(bet);
        bet = new BetModel.Bet("place4");
        calendar.add(Calendar.DAY_OF_YEAR, 40);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        calendar.add(Calendar.MINUTE, -43);
        bet.setDate(calendar.getTime());
        mUser.addBet(bet);
        bet = new BetModel.Bet("place5");
        calendar.add(Calendar.DAY_OF_YEAR, 21);
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        calendar.add(Calendar.MINUTE, -43);
        bet.setDate(calendar.getTime());
        mUser.addBet(bet);

        binding.setUser(mUser);
        View view = binding.getRoot();
        view.findViewById(R.id.button_action).setOnClickListener((View v) -> {
            Log.e(">>>>>>", "action pressed");
            mUser.setName("New user " + Calendar.getInstance().getTimeInMillis());
            mUser.getBetList().get(1).setPlace("new place " + Calendar.getInstance().getTimeInMillis());
        });

        mLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView recycler = view.findViewById(R.id.bet_recycler);
        recycler.setLayoutManager(mLayoutManager);

        return view;
    }
}
