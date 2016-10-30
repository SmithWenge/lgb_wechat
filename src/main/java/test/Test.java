package test;

import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.enums.MediaType;
import com.github.sd4324530.fastweixin.api.response.UploadMediaResponse;
import com.lgb.wechat.arc.util.constants.Constants;

import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception {
        MediaAPI mediaAPI = new MediaAPI(Constants.APPCONFIG);
        UploadMediaResponse response = mediaAPI.uploadMedia(MediaType.IMAGE, new File("lgb_query.png"));
        String media_id = response.getMediaId();
        System.out.println(media_id);
    }
}
