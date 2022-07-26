package com.test.appA.service;

import com.test.appA.entity.JProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (JProduct)表服务接口
 *
 * @author makejava
 * @since 2022-07-27 15:59:49
 */
public interface JProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JProduct queryById(Long id);

    /**
     * 分页查询
     *
     * @param jProduct 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<JProduct> queryByPage(JProduct jProduct, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param jProduct 实例对象
     * @return 实例对象
     */
    JProduct insert(JProduct jProduct);

    /**
     * 修改数据
     *
     * @param jProduct 实例对象
     * @return 实例对象
     */
    JProduct update(JProduct jProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
