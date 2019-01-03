package com.lm.consumer.user;

import com.lm.FeignConfiguration;
import feign.Headers;
import feign.Param;
import feign.Request;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author lming.41032@gmail.com
 * @date 18-12-30 下午11:58
 */
//@FeignClient(name = "microservice-provider-user")
@FeignClient(name = "microservice-provider-user", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    //@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    //@RequestLine("GET user/{id}")
    @Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestMapping("user/{id}")
    User findById(@Param("id") String id);
}
