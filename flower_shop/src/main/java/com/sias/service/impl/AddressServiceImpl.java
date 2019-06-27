package com.sias.service.impl;

import com.sias.dao.AddressDao;
import com.sias.entity.Address;
import com.sias.entity.User;
import com.sias.service.AddressService;
import com.sias.util.MybatisUtil;
import org.apache.struts2.ServletActionContext;

import java.util.List;

/**
 * 地址service业务方法的实现层
 */
public class AddressServiceImpl implements AddressService {
    /**
     * 根据用户id查询他所有的地址
     */
    @Override
    public List<Address> selectAddressByUserId() {
        try{
            User loginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
            AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
            return addressDao.selectAddressByUserId(loginUser.getId());
        }finally{
            MybatisUtil.close();
        }
    }

    /**
     * 根据地址的id查询单个地址的信息
     * @param addressId 地址id
     * @return
     */
    @Override
    public Address selectAddressByAddressId(String addressId) {
        try{
            AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
            return addressDao.selectAddressByAddressId(addressId);
        }finally{
            MybatisUtil.close();
        }
    }

    /**
     * 添加新的地址
     * @param address
     */
    @Override
    public void addAddress(Address address) {
        try{
            AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
            addressDao.addAddress(address);
            MybatisUtil.commit();
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
            throw new RuntimeException("添加失败~");
        }
    }

    /**
     * 更新地址
     * @param address
     */
    @Override
    public void updateAddress(Address address) {
        try{
            AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
            addressDao.updateAddress(address);
            MybatisUtil.commit();
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();
            throw new RuntimeException("更新失败~");
        }
    }
}
