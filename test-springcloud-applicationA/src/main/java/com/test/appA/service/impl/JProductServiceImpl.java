package com.test.appA.service.impl;

import com.test.appA.entity.JProduct;
import com.test.appA.dao.JProductDao;
import com.test.appA.service.JProductService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (JProduct)表服务实现类
 *
 * @author makejava
 * @since 2022-07-27 15:59:53
 */
@Service("jProductService")
public class JProductServiceImpl implements JProductService {
    @Resource
    private JProductDao jProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JProduct queryById(Long id) {
        return this.jProductDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param jProduct 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<JProduct> queryByPage(JProduct jProduct, PageRequest pageRequest) {
        long total = this.jProductDao.count(jProduct);
        return new PageImpl<>(this.jProductDao.queryAllByLimit(jProduct, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param jProduct 实例对象
     * @return 实例对象
     */
    @Override
    public JProduct insert(JProduct jProduct) {
        this.jProductDao.insert(jProduct);
        return jProduct;
    }

    /**
     * 修改数据
     *
     * @param jProduct 实例对象
     * @return 实例对象
     */
    @Override
    public JProduct update(JProduct jProduct) {
        this.jProductDao.update(jProduct);
        return this.queryById(jProduct.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.jProductDao.deleteById(id) > 0;
    }
}
