package com.test.appA;

import com.test.appA.dao.JProductDao;
import com.test.appA.entity.JProduct;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {
    @Resource
    private JProductDao productDao;
    private ExecutorService executorService = Executors.newFixedThreadPool(20);

  //  @Test
    public void test() throws Exception {
        CountDownLatch c = new CountDownLatch(20);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> {
                while (true) {
                    List<JProduct> productList = new ArrayList<>();
                    int ii = 0;
                    while (ii < 100) {
                        JProduct j = new JProduct();
                        j.setProductImage("image");
                        j.setProductName("测试商品" + System.currentTimeMillis() + ii);
                        productList.add(j);
                        ii++;
                    }
                    productDao.insertBatch(productList);
                    System.out.println("当前线程:" + Thread.currentThread().getName());
                }
            });
        }
        c.await();
    }


    public static void main(String[] args) {
    }
}
