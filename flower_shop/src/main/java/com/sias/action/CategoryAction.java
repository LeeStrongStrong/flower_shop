package com.sias.action;

import com.opensymphony.xwork2.Action;
import com.sias.entity.Admin;
import com.sias.entity.Category;
import com.sias.service.CategoryService;
import com.sias.service.impl.CategoryServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

public class CategoryAction {
    private CategoryService categoryService = new CategoryServiceImpl();
    private List<Category> categorys;
    private Category category;
    private String id;
    /**
     * 后台:查询所有类别的Action
     * @return
     */
    public String findAll(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        Admin loginAdmin = (Admin) session.getAttribute("loginAdmin");
        if(loginAdmin==null){
            return Action.ERROR;
        }else{
            categorys = categoryService.selectAll();
            return Action.SUCCESS;
        }
    }

    /**
     * 后台:添加类别的Action
     * @return
     */
    public String addCategory(){
        categoryService.add(category);
        return Action.SUCCESS;
    }
    public String updateCategory(){
        categoryService.update(category);
        return Action.SUCCESS;
    }
    public String removeCategory(){
        try{
            categoryService.removeCategory(id);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
    public String findOne(){
        categoryService.selectOne(id);
        return Action.SUCCESS;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
