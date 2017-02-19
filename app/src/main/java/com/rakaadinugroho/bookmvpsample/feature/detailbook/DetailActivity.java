package com.rakaadinugroho.bookmvpsample.feature.detailbook;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.rakaadinugroho.bookmvpsample.R;
import com.rakaadinugroho.bookmvpsample.base.mvp.MvpActivity;
import com.rakaadinugroho.bookmvpsample.model.Item;

import butterknife.BindView;

public class DetailActivity extends MvpActivity<DetailPresenter>  implements DetailView, View.OnClickListener {
    @BindView(R.id.description)
    TextView description;

    @BindView(R.id.imagedetail)
    ImageView imagedetail;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.buttonRefresh)
    FloatingActionButton buttonRefresh;

    @BindView(R.id.descriptionLayout)
    CardView descriptionLayout;

    private String bookId;

    @Override
    protected DetailPresenter createPresenter() {
        return new DetailPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        buttonRefresh.setOnClickListener(this);
        bookId  = this.getIntent().getStringExtra("id");
        presenter.loadData(bookId);
    }

    @Override
    public void onClick(View view) {
        refreshData();
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        descriptionLayout.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        descriptionLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void getDataSuccess(Item item) {
        description.setText(Html.fromHtml(item.getVolumeInfo().getDescription()));
        Glide.with(this)
                .load(item.getVolumeInfo().getImageLinks().getThumbnail())
                .into(imagedetail);
        collapsingToolbarLayout.setTitle(item.getVolumeInfo().getTitle());
    }

    @Override
    public void getDataFail(String message) {
        Toast.makeText(activity, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshData() {
        presenter.loadData(bookId);
    }

}
