package com.rakaadinugroho.bookmvpsample.feature.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rakaadinugroho.bookmvpsample.R;
import com.rakaadinugroho.bookmvpsample.adapter.BookAdapter;
import com.rakaadinugroho.bookmvpsample.base.mvp.MvpActivity;
import com.rakaadinugroho.bookmvpsample.model.Books;
import com.rakaadinugroho.bookmvpsample.model.Item;
import com.rakaadinugroho.bookmvpsample.util.RecyclerItemClickListener;

import java.util.List;

import butterknife.BindView;

public class MainActivity extends MvpActivity<MainPresenter> implements MainView, SearchView.OnQueryTextListener {
    private String query    = "Programming";
    private List<Item> list;

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.addOnItemTouchListener(selectItemOnRecyclerView());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        presenter.loadData(query);
    }

    private RecyclerView.OnItemTouchListener selectItemOnRecyclerView() {
        return new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                presenter.getItem(list.get(position), activity);
            }

            @Override
            public void onLongItemClick(View view, int position) {
                presenter.getItem(list.get(position), activity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        getData(query);
        return false;
    }

    private void getData(String query) {
        if (query != null){
            this.query  = query;
            presenter.loadData(query);
        }
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        presenter.stop();
        getData(newText);
        return false;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void getDataSuccess(Books model) {
        this.list   = model.getItems();
        recyclerView.setAdapter(new BookAdapter(list, R.layout.item, getApplicationContext()));
    }

    @Override
    public void getDataFail(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void moveToDetail(Intent intent) {
        startActivity(intent);
    }

    public void refresh(View view){
        presenter.loadData(query);
    }
}
