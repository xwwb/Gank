package xw.gank.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.video.GSYADVideoPlayer;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.xw.gank.R;

import java.util.List;

import xw.gank.info.FirstVideoBean;
import xw.gank.info.VideoBean;

/**
 * Created by Administrator on 2018/4/27.
 */

public class FirstVideoRecycleViewAdapter extends BaseQuickAdapter<FirstVideoBean.DataBean, BaseViewHolder> {
    private Context context;
    public FirstVideoRecycleViewAdapter(Context context, List<FirstVideoBean.DataBean> data) {
        super(R.layout.firstvideo_recycleview_item, data);
        this.context = context;
    }
    @Override
    protected void convert(BaseViewHolder helper, FirstVideoBean.DataBean videoBean) {

        final StandardGSYVideoPlayer gsyVideoPlayer = helper.itemView.findViewById(R.id.ijk_player);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      //  String url = "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/02/29/db48634c0e7e3eaa4583aa48b4b3180f.mp4";
        GSYVideoOptionBuilder gsyVideoOptionBuilder = new GSYVideoOptionBuilder();
        gsyVideoOptionBuilder
                        .setIsTouchWiget(false)
                .setThumbImageView(imageView)
                .setUrl(videoBean.getVideouri())
                .setVideoTitle(videoBean.getText())
                .setCacheWithPlay(false)
                .setRotateViewAuto(true)
                .setLockLand(true)
                .setPlayTag(TAG)
               // .setBottomShowProgressBarDrawable()
              //  .setMapHeadData(header)
                .setShowFullAnimation(true)
                .setNeedLockFull(true)
             //   .setPlayPosition(position)
                .setVideoAllCallBack(new GSYSampleCallBack() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        if (!gsyVideoPlayer.isIfCurrentIsFullscreen()) {
                            //静音
                            GSYVideoManager.instance().setNeedMute(true);
                        }

                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        //全屏不静音
                        GSYVideoManager.instance().setNeedMute(true);
                    }

                    @Override
                    public void onEnterFullscreen(String url, Object... objects) {
                        super.onEnterFullscreen(url, objects);
                        GSYVideoManager.instance().setNeedMute(false);
                        gsyVideoPlayer.getCurrentPlayer().getTitleTextView().setText((String)objects[0]);
                    }
                }).build(gsyVideoPlayer);
        //设置全屏按键功能
        gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resolveFullBtn(gsyVideoPlayer);
            }
        });

        //url6= "http://mov.bn.netease.com/open-movie/nos/flv/2015/12/31/SBB7M663L_hd.flv";
        int widthPixels = context.getResources().getDisplayMetrics().widthPixels;
        //ijkVideoView.setLayoutParams(new LinearLayout.LayoutParams(widthPixels, widthPixels * 9 / 16 + 1));
//        StandardVideoController controller = new StandardVideoController(context);
//        PlayerConfig config = new PlayerConfig.Builder()
//                .enableCache()
//                .autoRotate()
//                .addToPlayerManager()//required
////                        .savingProgress()
//                .build();

        Glide.with(context).load(videoBean.getBimageuri()).crossFade().placeholder(R.color.white).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
//        ijkVideoView.setPlayerConfig(config);
//        Log.i("======videoBean",""+videoBean.getUrl()+"====="+videoBean.getTitle());
//
//       // ijkVideoView.setUrl(url6);
//         ijkVideoView.setUrl(videoBean.getUrl());
//        ijkVideoView.setTitle(videoBean.getTitle());
//        ijkVideoView.setVideoController(controller);
      //  ImageView profile_Image = helper.itemView.findViewById(R.id.profile_image);
        TextView title = helper.itemView.findViewById(R.id.title_text);
       // String text = videoBean.getTitle();
       // Log.i("======text",""+text);
        title.setText(videoBean.getText());
      //  TextView name = helper.itemView.findViewById(R.id.name);
      //  TextView playCount = helper.itemView.findViewById(R.id.playcount);
       // name.setText(dataBean.getName());
//        if (dataBean.getPlaycount()==null){
//            playCount.setVisibility(View.GONE);
//        }else {
//            playCount.setVisibility(View.VISIBLE);
//            playCount.setText(String.format("播放量:%s", dataBean.getPlaycount()));
//        }

       // Glide.with(context).load(dataBean.getProfile_image()).error(R.mipmap.ic_load_fail).diskCacheStrategy(DiskCacheStrategy.ALL).into(profile_Image);
//        String url = item.getUrl();
//        photoIv.setOriginalSize(item.getWidth(), item.getHeight());

//
//                Picasso.with(context).load(url)
//                .placeholder(R.mipmap.img_default_meizi)
//                .error(R.mipmap.ic_load_fail).into(photoIv);
//
    }
    /**
     * 全屏幕按键处理
     */
    private void resolveFullBtn(final StandardGSYVideoPlayer standardGSYVideoPlayer) {
        standardGSYVideoPlayer.startWindowFullscreen(context, true, true);
    }
}
