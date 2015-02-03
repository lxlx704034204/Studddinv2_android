package in.tosc.studddin.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.tosc.studddin.R;
import in.tosc.studddin.fragments.notes.NotesSearchFragment;
import in.tosc.studddin.fragments.people.PeopleNearmeFragment;
import in.tosc.studddin.fragments.people.PeopleSameInstituteFragment;
import in.tosc.studddin.fragments.people.PeopleSameInterestsFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PeopleFragment extends Fragment {


    ViewPager peoplePager;
    FragmentPagerAdapter fragmentPagerAdapter;
    private Toolbar toolbar;

    public PeopleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //ActionBar actionBar = ((ActionBarActivity)getActivity()).getSupportActionBar();
        //ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.peopleColorPrimary));
        //actionBar.setBackgroundDrawable(colorDrawable);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        /*
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((ActionBarActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_drawer);
        */

        fragmentPagerAdapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0:
                        return (new PeopleNearmeFragment());
                    case 1:
                        return (new PeopleSameInstituteFragment());
                    case 2:
                        return (new PeopleSameInterestsFragment());

                }
                return new NotesSearchFragment();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Near Me";
                    case 1:
                        return "Same Institute";
                    case 2:
                        return "Same Interests";
                }

                return null;
            }

            @Override
            public int getCount() {
                return 3;
            }
        };

        peoplePager = (ViewPager) view.findViewById(R.id.people_pager);
        peoplePager.setAdapter(fragmentPagerAdapter);
        peoplePager.setOffscreenPageLimit(3);
        return view;
    }


}