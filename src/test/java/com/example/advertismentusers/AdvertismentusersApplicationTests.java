package com.example.advertismentusers;

import com.example.advertismentusers.data.AdvRepository;
import com.example.advertismentusers.data.Advertisment;
import com.example.advertismentusers.data.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class AdvertismentusersApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void saveUser() {
        var repo = new AdvRepository();

        var user = new User(0, "Gusts2", "Link2", null);

        repo.save(user);
    }

    @Test
    void saveUserWithAdv() {
        var repo = new AdvRepository();

        var user = new User(0, "Gusts6", "Link6", null);

        var adv1 = new Advertisment(0, "New adv from test", user);
        var adv2 = new Advertisment(0, "New adv from test 2", user);

        List<Advertisment> advrs = new ArrayList<>(Arrays.asList(adv1, adv2));

        user.setAdvertisments(advrs);

        repo.save(user);
    }

}
