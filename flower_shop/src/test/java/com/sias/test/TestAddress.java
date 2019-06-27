package com.sias.test;

import com.sias.dao.AddressDao;
import com.sias.entity.Address;
import com.sias.util.MybatisUtil;
import org.junit.Test;

import java.util.List;

/**
 * 测试地址
 */
public class TestAddress {
    /**
     * 测试根据用户id查询他所有的地址信息
     */
    @Test
    public void testSelectAddressByUserId(){
        AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
        List<Address> addresses = addressDao.selectAddressByUserId("001");
        for (Address address : addresses) {
            System.out.println(address);
        }
    }

    /**
     * 测试根据地址的id查询单个的地址信息
     */
    @Test
    public void testSelectAddressByAddressId(){
        AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
        Address address = addressDao.selectAddressByAddressId("001");
        System.out.println(address);
    }
    /**
     * 测试添加新地址信息
     */
    @Test
    public void testAddAddress(){
        AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
        Address address = new Address("003","11","11","11","11","001");
        addressDao.addAddress(address);
        MybatisUtil.commit();
    }

    /**
     * 测试更新地址信息
     */
    @Test
    public void testUpdateAddress(){
        AddressDao addressDao = MybatisUtil.getSqlSession().getMapper(AddressDao.class);
        Address address = new Address("003","00","11","11","11","001");
        addressDao.updateAddress(address);
        MybatisUtil.commit();
    }

}
