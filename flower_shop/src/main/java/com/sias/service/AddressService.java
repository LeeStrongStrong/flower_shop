package com.sias.service;

import com.sias.entity.Address;

import java.util.List;

/**
 * 地址的service业务方法
 */
public interface AddressService {
    /**
     * 根据用户id查询他所有的地址
     */
    List<Address> selectAddressByUserId();

    /**
     * 根据地址的id查询单个的地址
     * @param addressId 地址id
     * @return
     */
    Address selectAddressByAddressId(String addressId);

    /**
     * 添加地址
     * @param address
     */
    void addAddress(Address address);

    /**
     * 更新地址
     * @param address
     */
    void updateAddress(Address address);
}
