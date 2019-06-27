package com.sias.action;

import com.opensymphony.xwork2.Action;
import com.sias.entity.Address;
import com.sias.entity.User;
import com.sias.service.AddressService;
import com.sias.service.impl.AddressServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 地址页面交互有关的action方法
 */
public class AddressAction {
    /** list:该用户下的所有地址
     * addressId:接收用户选中的地址id
     * address:返回:根据地质所得到的地址对象
     */
    private List<Address> list;
    private String addressId;
    private Address address;

    private AddressService addressService = new AddressServiceImpl();
    /**
     * 通过Userid查询地址
     *
     * @return
     */
    public String selectAddressByUserId() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        if(loginUser!=null){
            list = addressService.selectAddressByUserId();
            return Action.SUCCESS;
        }else{
            return Action.ERROR;
        }
    }

    /**
     * 通过地址id查一个展示出来
     * 并且查询所有该用户的地址
     * @return
     */
    public String selectAddressByAddressId(){
        address = addressService.selectAddressByAddressId(addressId);
        list = addressService.selectAddressByUserId();
        return Action.SUCCESS;
    }

    public List<Address> getList() {
        return list;
    }

    public void setList(List<Address> list) {
        this.list = list;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
