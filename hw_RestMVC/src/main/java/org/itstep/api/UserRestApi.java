package org.itstep.api;

import org.itstep.domain.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/api/users")
public class UserRestApi extends RestApi<PageInfo> {
    private final String GET_USERS = "https://reqres.in/api/users?per_page=100";
    @Autowired
    public UserRestApi(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    @GetMapping
    public PageInfo getAllUsers() {
        PageInfo pageInfo = restTemplate.getForObject(GET_USERS,PageInfo.class);
        System.out.println(pageInfo);
        return pageInfo;
    }
}
