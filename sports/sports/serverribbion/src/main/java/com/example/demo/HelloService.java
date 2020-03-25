package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        String simpleName = HystrixCommand.class.getSimpleName();
        return "hi" + name + ",出现了错误，并使用" + simpleName + "返回结果";
    }
/**
 *      GeneratedKeyHolder keyHolder1 = new GeneratedKeyHolder();
 *         StringBuilder builder1 = new StringBuilder();
 *         builder1.append(" update host_threat set DetectTime = ? where HostIp = ?  and DetectDay = ? ");
 *         int update = jdbcTemplate.update(new PreparedStatementCreator() {
 *             @Override
 *             public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
 *                 PreparedStatement preparedStatement = con.prepareStatement(builder1.toString(), new String[]{"HostThreatId"});
 *                 preparedStatement.setString(1, format.format(hostThreat.getDetectTime()));
 *                 preparedStatement.setString(2, hostThreat.getHostIp());
 *                 preparedStatement.setString(3, hostThreat.getDetectDay());
 *                 return preparedStatement;
 *             }
 *         }, keyHolder1);
 *         Number key = keyHolder1.getKey();
 */
}
