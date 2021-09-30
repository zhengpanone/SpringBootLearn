package com.zp.dao;

import com.zp.App;
import com.zp.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class UserPagingAndSortingRepositoryTest {
    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    @Test
    public void testPagingAndSortingRepositorySort() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Iterable<User> all = userPagingAndSortingRepository.findAll(sort);
        System.out.println(all);
    }

    @Test
    public void testPagingAndSortingRepositoryPage() {
        PageRequest pageable = PageRequest.of(1, 1);
        Page<User> all = userPagingAndSortingRepository.findAll(pageable);

        System.out.println("总条数" + all.getTotalElements());
        System.out.println("总页数" + all.getTotalPages());
    }

    @Test
    public void testPagingAndSortingRepositorySortAndPage() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable =PageRequest.of(1, 1, sort);
        Page<User> all = userPagingAndSortingRepository.findAll(pageable);

        System.out.println("总条数" + all.getTotalElements());
        System.out.println("总页数" + all.getTotalPages());
        List<User> content = all.getContent();
        for (User user : content) {
            System.out.println(user);
        }
        System.out.println(content);

    }
}
