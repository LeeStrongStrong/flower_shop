package com.sias.action;

import com.opensymphony.xwork2.Action;
import com.sias.entity.Admin;
import com.sias.entity.Category;
import com.sias.entity.Flower;
import com.sias.service.CategoryService;
import com.sias.service.FlowerService;
import com.sias.service.impl.CategoryServiceImpl;
import com.sias.service.impl.FlowerServiceImpl;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlowerAction {
    private FlowerService flowerService = new FlowerServiceImpl();
    private CategoryService categoryService = new CategoryServiceImpl();
    //类别
    private List<Category> categories;
    /**
     * map下存的是 类别的名称，和装Flower的List
     */
    private Map<String, List<Flower>> map;
    /**
     * recommendFlowers：查询热销的鲜花
     * hotSaleFlowers：查询推荐的鲜花
     * detailFlower：鲜花详情信息
     * flowerId：鲜花的id
     */
    private List<Flower> secRecommendFlowers;
    private List<Flower> recommendFlowers;
    private List<Flower> hotSaleFlowers;
    private Flower detailFlower;
    private String flowerId;
    private List<Flower> flowers;
    private Flower flower;
    private String key;
    private String content;
    /**
     * 图片和图片的名称
     */
    private File cover;
    private String coverFileName;
    /**
     * 展示首页时候需要做：展示所有类别，和类别下所有的鲜花，查询热销的鲜花，查询推荐的鲜花
     * 前台查询所有的类别 并查询每个类别下所有的鲜花
     */
    public String findAllCategoryAndFlower() {
        map = new HashMap<>(16);
        //查询所有的类别
        categories = categoryService.selectAll();
        //左栏展示
        for (Category category : categories) {
            List<Flower> flowers = flowerService.selectFlowerByCategoryId(category.getId());
            map.put(category.getName(), flowers);
        }
        //推荐鲜花和热销鲜花
        recommendFlowers = flowerService.selectFlowerByRecommend();
        secRecommendFlowers = flowerService.selectFlowerByRecommend();
        hotSaleFlowers = flowerService.selectBySale();
        return Action.SUCCESS;
    }

    /**
     * 根据id查询鲜花的详情
     */
    public String findDetail(){
       detailFlower = flowerService.selectOne(flowerId);
        System.out.println(detailFlower);
       return Action.SUCCESS;
    }

    /****************************************************************************/
    /**
     * 后台:查询所有鲜花的Action
     * @return
     */
    public String findAll(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        if(loginAdmin==null){
            return Action.ERROR;
        }else{
            flowers =flowerService.selectAll();
            return Action.SUCCESS;
        }
    }

    /**
     * 后台:查询一个鲜花的同时查询所有的类别
     */
    public String selectOneAndCategory(){
        detailFlower = flowerService.selectOne(flowerId);
        categories = categoryService.selectAll();
        return Action.SUCCESS;
    }
    /**
     * 后台:添加鲜花的时候先查询类别
     */
    public String selectAllCategory(){
        categories = categoryService.selectAll();
        return Action.SUCCESS;
    }
    /**
     * 更新：更新鲜花信息
     */
    public String updateFlower(){
        flower.setImage(coverFileName);
        flowerService.update(flower);
        return Action.SUCCESS;
    }


    /**
     * 后台:删除鲜花信息
     * @return
     */
    public String remove(){
        Flower flower = flowerService.selectOne(flowerId);
        String newName = flower.getName();
        //0.根据相对路径获取绝对路径
        HttpServletRequest request = ServletActionContext.getRequest();
        String realPath = request.getSession().getServletContext().getRealPath("/back/images/img");
        File file = new File(realPath+"/"+newName);
        file.delete();
        flowerService.delete(flowerId);
        return Action.SUCCESS;
    }
    /**
     * 后台：模糊查询
     */
    public String findBySth(){
        flowers = flowerService.findBySth(key,content);
        return Action.SUCCESS;
    }

    /**
     * 后台：添加鲜花
     * @return
     * @throws IOException
     */
    public String add() throws IOException {
        //获取文件输入流
        FileInputStream is = new FileInputStream(cover);
        //根据img文件夹的相对路径获取绝对路径
        String realPath = ServletActionContext.getServletContext().getRealPath("/back/images/img");
        //拿到文件的类型
        String type = coverFileName.substring(coverFileName.indexOf("."));
        //新的文件名以时间戳为名
        String fileName = String.valueOf(System.currentTimeMillis()) + type;
        File file = new File(realPath,fileName);
        //复制流
        FileOutputStream os = new FileOutputStream(file);
        IOUtils.copy(is,os);
        IOUtils.closeQuietly(os);
        IOUtils.closeQuietly(is);
        flower.setImage(fileName);
        flowerService.add(flower);
        return Action.SUCCESS;
    }

    public List<Flower> getSecRecommendFlowers() {
        return secRecommendFlowers;
    }

    public void setSecRecommendFlowers(List<Flower> secRecommendFlowers) {
        this.secRecommendFlowers = secRecommendFlowers;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Map<String, List<Flower>> getMap() {
        return map;
    }

    public void setMap(Map<String, List<Flower>> map) {
        this.map = map;
    }

    public List<Flower> getRecommendFlowers() {
        return recommendFlowers;
    }

    public void setRecommendFlowers(List<Flower> recommendFlowers) {
        this.recommendFlowers = recommendFlowers;
    }

    public List<Flower> getHotSaleFlowers() {
        return hotSaleFlowers;
    }

    public void setHotSaleFlowers(List<Flower> hotSaleFlowers) {
        this.hotSaleFlowers = hotSaleFlowers;
    }

    public Flower getDetailFlower() {
        return detailFlower;
    }

    public void setDetailFlower(Flower detailFlower) {
        this.detailFlower = detailFlower;
    }

    public String getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(String flowerId) {
        this.flowerId = flowerId;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public File getCover() {
        return cover;
    }

    public void setCover(File cover) {
        this.cover = cover;
    }

    public String getCoverFileName() {
        return coverFileName;
    }

    public void setCoverFileName(String coverFileName) {
        this.coverFileName = coverFileName;
    }
}