package com.example.dubbo.Server;

import org.springframework.stereotype.Service;

@Service
public class DubboServiceImpl implements DubboService {
    @Override
    public String sayHello(String name) {
        return "hi: " + name + "你好";
    }
}
