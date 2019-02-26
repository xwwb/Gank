package xw.gank.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.xw.gank.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jzvd.JZVideoPlayerStandard;

public class IjkPlayerActivity extends MyBaseActivity {
    String url6 = "http://mov.bn.netease.com/open-movie/nos/flv/2017/01/03/SC8U8K7BC_hd.flv";
    @BindView(R.id.playerView)
    JZVideoPlayerStandard jieCaoplayerView;
    @BindView(R.id.exo_playView)
    PlayerView exoPlayView;
    //    @BindView(R.id.video_view)
//    IjkVideoView videoView;
//    @BindView(R.id.playerView)
//    PlayerView playerView;
 //   private String url5 = "http://stream1.grtn.cn/tvs2/sd/live.m3u8?_ts&time=1518428696629";
    private String url5 = "http://cdnxdc.tanzi88.com/XDC/dvideo/2018/02/29/db48634c0e7e3eaa4583aa48b4b3180f.mp4";
    private String title;
    private String videoUrl;
    @Override
    protected void initView() {

    }
    @Override
    protected void setListern() {

    }
    @Override
    protected void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
        videoUrl = intent.getStringExtra("videoUrl");
        // 得到默认合适的带宽
        DefaultBandwidthMeter bandwidthMeter = new DefaultBandwidthMeter();
        // 创建跟踪的工厂
        TrackSelection.Factory videoTrackSelectionFactory = new AdaptiveTrackSelection.Factory(bandwidthMeter);
        // 创建跟踪器
        TrackSelector trackSelector = new DefaultTrackSelector(videoTrackSelectionFactory);
        // 创建player
        SimpleExoPlayer player = ExoPlayerFactory.newSimpleInstance(this, trackSelector);
        // 绑定player
        exoPlayView.setPlayer(player);



// 生成通过其加载媒体数据的DataSource实例
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, Util.getUserAgent(this, "ExoPlayer"), bandwidthMeter);
// 创建要播放的媒体的MediaSource
        MediaSource mediaSource = new ExtractorMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(url5));
        // 准备播放器的MediaSource
        player.prepare(mediaSource);
        // 当准备完毕后直接播放
        player.setPlayWhenReady(true);

//                videoView.setTitle(title); //设置视频标题
//        StandardVideoController controller = new StandardVideoController(this);
//        // controller.setLive();
//        videoView.setVideoController(controller); //设置控制器，如需定制可继承BaseVideoController
//        PlayerConfig playerConfig = new PlayerConfig.Builder()
//                .enableCache() //启用边播边缓存功能
//                .autoRotate() //启用重力感应自动进入/退出全屏功能
////                .enableMediaCodec()//启动硬解码，启用后可能导致视频黑屏，音画不同步
////                .usingSurfaceView() //启用SurfaceView显示视频，不调用默认使用TextureView
////                .savingProgress() //保存播放进度
////                .disableAudioFocus() //关闭AudioFocusChange监听
////                .setLooping() //循环播放当前正在播放的视频
//                .build();
//        videoView.setPlayerConfig(playerConfig);
//        videoView.setUrl(url6); //设置视频地址
//        videoView.start(); //开始播放，不调用则不自动播放
        jieCaoplayerView.setUp(url5, JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, "反反复复");
        // playerView.thumbImageView.
        //playerView.thumbImageView.setImage("http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640");
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_ijk_player;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

}
