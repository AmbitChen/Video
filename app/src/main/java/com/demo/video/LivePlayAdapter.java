package com.demo.video;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.LivePlay;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

import static android.R.attr.visibility;
import static com.demo.video.R.id.video;

class LivePlayAdapter extends RecyclerView.Adapter<LivePlayAdapter.ViewHolder> {
    private String[] videoUrls =
            {
                    "http://video.jiecao.fm/8/17/bGQS3BQQWUYrlzP1K4Tg4Q__.mp4",
                    "http://video.jiecao.fm/8/17/%E6%8A%AB%E8%90%A8.mp4",
                    "http://video.jiecao.fm/8/18/%E5%A4%A7%E5%AD%A6.mp4",
                    "http://video.jiecao.fm/8/16/%E8%B7%B3%E8%88%9E.mp4",
                    "http://video.jiecao.fm/8/16/%E9%B8%AD%E5%AD%90.mp4",
                    "http://video.jiecao.fm/8/16/%E9%A9%BC%E8%83%8C.mp4",
                    "http://video.jiecao.fm/8/16/%E4%BF%AF%E5%8D%A7%E6%92%91.mp4",
                    "http://video.jiecao.fm/5/1/%E8%87%AA%E5%8F%96%E5%85%B6%E8%BE%B1.mp4",
                    "http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4",
                    "http://video.jiecao.fm/11/23/xu/%E5%A6%B9%E5%A6%B9.mp4",
                    "http://video.jiecao.fm/11/24/xin/-%2024%20-%20.mp4",
                    "http://video.jiecao.fm/11/24/6/%E9%85%92%E9%A9%BE.mp4",
                    "http://video.jiecao.fm/11/23/6/%E7%8B%97.mp4",
                    "http://video.jiecao.fm/11/23/xu/%E7%94%B5%E5%BD%B1.mp4",
                    "http://video.jiecao.fm/11/23/6/%E5%AD%A9%E5%AD%90.mp4",
                    "http://video.jiecao.fm/11/24/xu/%E6%97%A5%E5%8E%86.mp4",
                    "http://video.jiecao.fm/11/26/-iDareX.mp4",
                    "http://video.jiecao.fm/11/24/6/%E5%AD%94%E6%98%8E%E7%81%AF.mp4"
            };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(videoUrls[position]);
    }

    @Override
    public int getItemCount() {
        return videoUrls.length;
    }

    private String curUrl = "";

    class ViewHolder extends RecyclerView.ViewHolder {

        private LivePlay livePlay;

        ViewHolder(View itemView) {
            super(itemView);

            livePlay = (LivePlay) itemView.findViewById(R.id.video);
            LivePlay.SAVE_PROGRESS = false;
            livePlay.setWindowVisibilityChanged(new LivePlay.WindowVisibilityChanged() {
                @Override
                public void onWindowVisibilityChanged(LivePlay livePlay, int visibility, String url) {
                    if (visibility == View.GONE) {
                        livePlay.release();
                    }
                }
            });
        }

        private String url = "";

        void setData(String url) {
            this.url = url;
            livePlay.setUp(
                    url, JCVideoPlayer.SCREEN_LAYOUT_LIST,
                    url);
        }
    }
}


