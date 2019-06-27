package com.sias.test;
/**
 * 测试连接是否成功
 */
import com.sias.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

public class TestConnection {
    /**
     * 测试连接
     */
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        System.out.println(sqlSession);
    }
}

