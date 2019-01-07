package xw.gank.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xw.gank.R;
import com.xw.library.utils.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xw.gank.adapter.BookRecycleViewAdapter;
import xw.gank.adapter.NewMoveRecycleViewAdapter;
import xw.gank.config.Config;
import xw.gank.info.BookBean;
import xw.gank.info.MoviesBean;
import xw.gank.request.RequestListern;
import xw.gank.request.SearchBookRequest;
import xw.gank.request.SearchMoveRequest;

public class SearchActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener, View.OnClickListener {


    @BindView(R.id.select_image)
    ImageView selectImage;
    @BindView(R.id.select_layout)
    LinearLayout selectLayout;
    @BindView(R.id.view)
    View view;
    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.searchview)
    SearchView searchview;
    @BindView(R.id.no_data)
    TextView noData;
    @BindView(R.id.smartRefreshlayout)
    SmartRefreshLayout smartRefreshlayout;
    private PopupWindow pw;
    private SearchMoveRequest searchMoveRequest;
    private List<MoviesBean.SubjectsBean> subjects;
    private NewMoveRecycleViewAdapter adapter;
    private List<MoviesBean.SubjectsBean> data = new ArrayList<>();

    private List<BookBean.BooksBean> bookData = new ArrayList<>();
    private boolean isFresh = false;
    private boolean isLoadMore = false;
    private int start = 0;
    private String q = "";

    private boolean isMoives = true;//搜索电影
    private boolean isBook = false;//搜索图书
    private SearchBookRequest searchBookRequest;
    private BookRecycleViewAdapter bookRecycleViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        initView();
        searchMoveRequest = new SearchMoveRequest();
        searchBookRequest = new SearchBookRequest();
        initData();
        setListern();
    }

    @Override
    protected void initView() {
        super.initView();
        setStatusBar(this);
        Config.start = "0";
        view.setBackgroundColor(getResources().getColor(R.color.title_layout_color));
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        searchview.setIconifiedByDefault(false);
        searchview.setSubmitButtonEnabled(true);
        smartRefreshlayout.setOnRefreshListener(this);
        smartRefreshlayout.setOnLoadMoreListener(this);
        // searchview.onActionViewExpanded();
    }

    private void initPopuper() {
        @SuppressLint("InflateParams") View myView = getLayoutInflater().inflate(R.layout.pop, null);
        //通过view 和宽·高，构造PopopWindow
        pw = new PopupWindow(myView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        //popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        pw.setBackgroundDrawable(getResources().getColor(
//                //此处为popwindow 设置背景，同事做到点击外部区域，popwindow消失
//                R.drawable.diaolog_bg));
        //设置焦点为可点击
//        pw.setInputMethodMode(PopupWindow.INPUT_METHOD_NEEDED);
        pw.setTouchable(true); // 设置popupwindow可点击
        pw.setOutsideTouchable(true); // 设置popupwindow外部可点击
        pw.setBackgroundDrawable(new BitmapDrawable(null, ""));
        pw.setFocusable(true);//可以试试设为false的结果
        //实例化一个ColorDrawable颜色为半透明，已达到变暗的效果
        // 设置背景颜色变暗
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.7f;
        getWindow().setAttributes(lp);
        pw.showAsDropDown(selectLayout);
        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
            }
        });
        TextView search_book = myView.findViewById(R.id.search_book);
        TextView search_movie = myView.findViewById(R.id.search_movies);
        search_book.setOnClickListener(this);
        search_movie.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        super.initData();
        if (isMoives) {
            adapter = new NewMoveRecycleViewAdapter(this, data);
            adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
            recycleView.setAdapter(adapter);
        }
        if (isBook) {
            bookRecycleViewAdapter = new BookRecycleViewAdapter(bookData);
            recycleView.setAdapter(bookRecycleViewAdapter);
        }
        // initTestData();
    }


    @Override
    protected void setListern() {
        super.setListern();
        searchview.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SearchActivity.this, "哈哈", Toast.LENGTH_SHORT).show();
            }
        });
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("======submit", "" + query);
                showDialog("" + Config.title);
                isFresh = false;
                isLoadMore = false;
                Config.start = "0";
                data.clear();
                bookData.clear();
                q = query;
                if (isMoives) {
                    //initData();
                    searMoviesRequest(query, Config.start);
                }
                if (isBook) {

                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("===onQueryTextChange", "" + newText);
                // searMoviesRequest(newText);
                return false;
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                String small = data.get(position).getImages().getSmall();
                String original_title = data.get(position).getOriginal_title();
                String alt = data.get(position).getAlt();
                Intent intent = new Intent(context, MoveDetailsActivity.class);
                intent.putExtra("alt", alt);
                intent.putExtra("name", original_title);
                intent.putExtra("imageUrl",small);
                startActivity(intent);
            }
        });
    }

    private void searchBookRequest(String query, String start) {
        searchBookRequest.requestBestData(this, query, start, new RequestListern() {
            @Override
            public void OnSucess(String string) {
                if (string != null) {
                    //dissMissDialog();
                    BookBean bookBean = new Gson().fromJson(string, BookBean.class);
                    if (bookBean != null) {
                        List<BookBean.BooksBean> books = bookBean.getBooks();
                        if (books.size() != 0) {
                            if (isFresh) {
                                bookData.clear();
                                smartRefreshlayout.finishRefresh(1500);
                            }
                            if (isLoadMore) {
                                smartRefreshlayout.finishLoadMore(1500);
                            }
                            bookData.addAll(books);
                            recycleView.setVisibility(View.VISIBLE);
                            noData.setVisibility(View.GONE);
                            bookRecycleViewAdapter.notifyDataSetChanged();
                        }
                        if (bookBean.getTotal() == 0) {
                            if (!isLoadMore) {
                                recycleView.setVisibility(View.GONE);
                                noData.setVisibility(View.VISIBLE);
                                noData.setText("没有搜索到相关内容....");
                            }
                            if (isLoadMore) {
                                smartRefreshlayout.finishLoadMore(1500);
                                smartRefreshlayout.finishLoadMoreWithNoMoreData();
                            }

                        }
                    }
                }
            }

            @Override
            public void OnError(Exception error) {
            }
        });

    }

    private void searMoviesRequest(String query, String start) {
        searchMoveRequest.requestBestData(SearchActivity.this, query, start, new RequestListern() {
            @Override
            public void OnSucess(String string) {
                if (string != null) {
                    dissMissDialog();
                    MoviesBean moviesBean = new Gson().fromJson(string, MoviesBean.class);
                    if (moviesBean != null) {
                        subjects = moviesBean.getSubjects();
                        if (subjects.size() != 0) {
                            if (isFresh) {
                                data.clear();
                                smartRefreshlayout.finishRefresh(1500);
                            }
                            if (isLoadMore) {
                                smartRefreshlayout.finishLoadMore(1500);
                            }
                            data.addAll(subjects);
                            recycleView.setVisibility(View.VISIBLE);
                            noData.setVisibility(View.GONE);
                            adapter.notifyDataSetChanged();
                        }
                        if (moviesBean.getTotal() == 0) {
                            if (!isLoadMore) {
                                recycleView.setVisibility(View.GONE);
                                noData.setVisibility(View.VISIBLE);
                                noData.setText("没有搜索到相关内容....");
                            }
                            if (isLoadMore) {
                                smartRefreshlayout.finishLoadMore(1500);
                                smartRefreshlayout.finishLoadMoreWithNoMoreData();
                            }
                        }
                    }
                }
            }

            @SuppressLint("SetTextI18n")
            @Override
            public void OnError(Exception error) {
                dissMissDialog();
                Log.i("====error", "" + error.getMessage());
                recycleView.setVisibility(View.GONE);
                noData.setVisibility(View.VISIBLE);
                noData.setText("" + error.getMessage());
            }
        });
    }

    @OnClick(R.id.select_layout)
    public void onClick() {
        initPopuper();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshlayout) {
        isFresh = true;
        isLoadMore = false;
        if (isBook) {
            searchBookRequest(q, Config.start);
        }
        if (isMoives) {
            searMoviesRequest(q, Config.start);
        }

    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        isFresh = false;
        start = start + 20;
        isLoadMore = true;
        Config.start = String.valueOf(start);
        if (isMoives) {
            searMoviesRequest(q, Config.start);
        }
        if (isBook) {
            searMoviesRequest(q, Config.start);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_movies:
                isBook = false;
                isMoives = true;
                pw.dismiss();
                //initData();
                break;
            case R.id.search_book:
                isMoives = false;
                isBook = true;
                pw.dismiss();
                //initData();
                break;
        }

    }
}
