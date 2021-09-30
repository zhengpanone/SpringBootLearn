package com.zp.dao;

import com.zp.App;
import com.zp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)

public class UserRepositorySpecificationTest {
    @Autowired
    private UserRepositorySpecification userRepositorySpecification;

    /**
     * 单条件
     */
    @Test
    public void testJpaSpecificationExecutor1() {
        Specification<User> spec = new Specification<User>() {
            /**
             *
             * @param root 查询对象属性的封装
             * @param criteriaQuery 封装了要执行的查询的各个部分的信息
             * @param criteriaBuilder 查询条件的构造器
             * @return
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * 参数一: 查询条件属性
                 * 参数二: 条件的值
                 */
                Predicate predicate = criteriaBuilder.equal(root.get("name"), "张三");
                return predicate;
            }
        };
        List<User> all = userRepositorySpecification.findAll(spec);
        for (User user : all) {
            System.out.println(user);
        }


    }

    /**
     * 多条件
     */
    @Test
    public void testJpaSpecificationExecutor2() {
        Specification<User> spec = new Specification<User>() {
            /**
             *
             * @param root 查询对象属性的封装
             * @param criteriaQuery 封装了要执行的查询的各个部分的信息
             * @param criteriaBuilder 查询条件的构造器
             * @return
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * 参数一: 查询条件属性
                 * 参数二: 条件的值
                 */
                List<Predicate> list = new ArrayList<>();
                list.add(criteriaBuilder.equal(root.get("name"), "张三"));
                list.add(criteriaBuilder.equal(root.get("age"), "20"));
                Predicate[] arr = new Predicate[list.size()];

                return criteriaBuilder.and(list.toArray(arr));
            }
        };
        List<User> all = userRepositorySpecification.findAll(spec);
        for (User user : all) {
            System.out.println(user);
        }


    }

    /**
     * 多条件
     */
    @Test
    public void testJpaSpecificationExecutor3() {
        Specification<User> spec = new Specification<User>() {
            /**
             *
             * @param root 查询对象属性的封装
             * @param criteriaQuery 封装了要执行的查询的各个部分的信息
             * @param criteriaBuilder 查询条件的构造器
             * @return
             */
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                /**
                 * 参数一: 查询条件属性
                 * 参数二: 条件的值
                 */

                return criteriaBuilder.and(criteriaBuilder.equal(
                        root.get("name"), "张三"),
                        criteriaBuilder.equal(root.get("age"), "20"));
            }
        };
        List<User> all = userRepositorySpecification.findAll(spec);
        for (User user : all) {
            System.out.println(user);
        }


    }
}
