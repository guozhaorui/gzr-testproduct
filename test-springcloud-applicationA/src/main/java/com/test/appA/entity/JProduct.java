package com.test.appA.entity;

import java.io.Serializable;

/**
 * (JProduct)实体类
 *
 * @author makejava
 * @since 2022-07-27 15:59:41
 */
public class JProduct implements Serializable {
    private static final long serialVersionUID = 106104498665475975L;
    
    private Long id;
    
    private String productName;
    
    private String productImage;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

}

