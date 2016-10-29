package com.lgb.wechat.function.admin.article.push.controller;

import com.github.sd4324530.fastweixin.api.MediaAPI;
import com.github.sd4324530.fastweixin.api.MessageAPI;
import com.github.sd4324530.fastweixin.api.enums.MediaType;
import com.github.sd4324530.fastweixin.api.response.GetSendMessageResponse;
import com.github.sd4324530.fastweixin.api.response.UploadMediaResponse;
import com.github.sd4324530.fastweixin.message.MpNewsMsg;
import com.google.common.base.Optional;
import com.lgb.wechat.arc.util.constants.Constants;
import com.lgb.wechat.function.admin.article.Article;
import com.lgb.wechat.function.admin.article.push.service.AdminArticlePushServiceI;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/article/push")
public class AdminArticlePushController {
    private static final String REQUEST_SUFFIX_ACTION = ".action";
    private static final String ADMIN_ARTICLE_PUSH_ROUTE_EDIT = "redirect:/admin/article/push/route/edit/";
    private static final String REDIRECT_ADMIN_PUSH_ARTICLE_LIST = "redirect:/admin/article/push/list.action";

    @Autowired
    private AdminArticlePushServiceI adminArticlePushService;

    /**
     * 查看所有推送文章
     *
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView allPushArticles() {
        List<Document> articles = adminArticlePushService.list();

        ModelAndView mav = new ModelAndView("admin/article/push/list");
        mav.addObject("documents", articles);

        return mav;
    }

    /**
     * 路由到推送文章添加页面
     */
    @RequestMapping("/route/add")
    public String routeAdd() {
        return "admin/article/push/add";
    }

    /**
     * 添加文章
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPushArticle(Article article, @RequestParam("articlePicture") MultipartFile articlePicture,
                                 HttpServletRequest request) {
        String tmpFileName = articlePicture.getOriginalFilename();
        if (tmpFileName == null || tmpFileName.length() == 0) {
            return "redirect:/admin/article/push/route/add.action";
        }

        File uploadImage = save(articlePicture, request);
        String requestURL = request.getRequestURL().toString();

        String serverURL = requestURL.substring(0, requestURL.indexOf("/", 8)) + request.getContextPath();

        Optional<File> optional = Optional.fromNullable(uploadImage);
        if (optional.isPresent()) {
            String articleId = new ObjectId().toString();
            article.setId(articleId);
            article.setArticleUrl(serverURL + "/weixin/article/view/" + Constants.PUSH_ARTICLE_TYPE + "/" + articleId + REQUEST_SUFFIX_ACTION);
            article.setPictureUrl(serverURL + "/static/article/image/" + uploadImage.getName());
            article.setArticleLocalPath(uploadImage.getAbsolutePath());

            adminArticlePushService.add(article);

            return REDIRECT_ADMIN_PUSH_ARTICLE_LIST;
        }


        return "redirect:/admin/article/push/route/add.action";
    }

    /**
     * 保存推送文章图片
     *
     * @param file
     * @param request
     * @return
     */
    private File save(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String targetPath = request.getSession().getServletContext().getRealPath("/static/article/image/");
        String sourceFileName = file.getOriginalFilename();

        String subName = sourceFileName.substring(sourceFileName.lastIndexOf("."));

        if (!subName.equals(".jpg") && !subName.equals(".png")) {
            return null;
        }

        String dateString = DateTime.now().toString("MM-dd-yyyy-HH-mm-ss-SSS");
        String prefixName = sourceFileName.substring(0, sourceFileName.indexOf("."));

        String newName = prefixName + "-" + dateString + subName;

        File targetFile = new File(targetPath, newName);

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        try {
            file.transferTo(targetFile);

            return targetFile;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 查看推送文章
     *
     * @param id
     * @return
     */
    @RequestMapping("/view/push/{id}")
    public ModelAndView viewArticle(@PathVariable("id") String id) {
        Document document = adminArticlePushService.view(Constants.PUSH_ARTICLE_TYPE, id);

        ModelAndView mav = new ModelAndView("admin/article/push/view");
        mav.addObject("document", document);

        return mav;
    }

    /**
     * 路由到文章编辑页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/route/edit/{id}")
    public ModelAndView routeEdit(@PathVariable("id") String id) {
        Document document = adminArticlePushService.view(Constants.PUSH_ARTICLE_TYPE, id);

        ModelAndView mav = new ModelAndView("admin/article/push/edit");
        mav.addObject("document", document);

        return mav;
    }

    /**
     * 保存编辑文章
     *
     * @param article
     * @return
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editArticle(Article article) {
        boolean updated = adminArticlePushService.edit(article);

        if (updated) {
            return REDIRECT_ADMIN_PUSH_ARTICLE_LIST;
        } else {
            return ADMIN_ARTICLE_PUSH_ROUTE_EDIT + article.getId() + REQUEST_SUFFIX_ACTION;
        }
    }

    /**
     * 推送文章
     */
    @RequestMapping(value = "/broadcast/{id}")
    public void broadcastArticle(@PathVariable("id") String id) {
        Document document = adminArticlePushService.view(Constants.PUSH_ARTICLE_TYPE, id);

        MediaAPI mediaAPI = new MediaAPI(Constants.APPCONFIG);
        UploadMediaResponse response = mediaAPI.uploadMedia(MediaType.IMAGE, new File(document.getString("articleLocalPath")));
        String media_id = response.getMediaId();
        com.github.sd4324530.fastweixin.api.entity.Article article = new com.github.sd4324530.fastweixin.api.entity.Article(media_id,
                "文章管理员",
                document.getString("articleTitle"),
                document.getString("articleUrl"),
                document.getString("articleDescription"),
                "文章推送",
                com.github.sd4324530.fastweixin.api.entity.Article.ShowConverPic.YES);
        UploadMediaResponse uploadMediaResponse = mediaAPI.uploadNews(Arrays.asList(article));
        MpNewsMsg mpNewsMsg = new MpNewsMsg();
        mpNewsMsg.setMediaId(uploadMediaResponse.getMediaId());
        MessageAPI messageAPI = new MessageAPI(Constants.APPCONFIG);
        GetSendMessageResponse messageResponse = messageAPI.sendMessageToUser(mpNewsMsg, true, "0", null);

    }
}
