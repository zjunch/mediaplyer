package cn.jzvd;

public class ZVideoManager {
    public static  FullScreenBackType  videoType=FullScreenBackType.CLOSE_VIDEO;

    public static  void  setFullScreenBackType(FullScreenBackType type){
           videoType=type;
    }

    public enum  FullScreenBackType{
        //全屏返回关闭 ，返回继续播放
        CLOSE_VIDEO, CONTINUE_PLAY
    }
}
