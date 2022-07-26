package com.test.appA.dao;

import com.test.appA.entity.JProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (JProduct)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-27 15:59:39
 */
public interface JProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JProduct queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param jProduct 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<JProduct> queryAllByLimit(JProduct jProduct, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param jProduct 查询条件
     * @return 总行数
     */
    long count(JProduct jProduct);

    /**
     * 新增数据
     *
     * @param jProduct 实例对象
     * @return 影响行数
     */
    int insert(JProduct jProduct);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<JProduct> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<JProduct> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<JProduct> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<JProduct> entities);

    /**
     * 修改数据
     *
     * @param jProduct 实例对象
     * @return 影响行数
     */
    int update(JProduct jProduct);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    JProduct queryByName(String name);
}

