package com.study.information_push.api;

import com.study.information_push.core.JSONResult;
import com.study.information_push.core.Result;
import com.study.information_push.dto.SystemDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 系统信息接口
 * @author sdy
 * @date 2019/5/10 14:10
 */
@Component
@RequestMapping("/api")
public class SystemInfo {

    @RequestMapping("/systemInfo")
    @ResponseBody
    public Result systemInfo(){
        SystemDto systemDto = new SystemDto();
        try {
            Runtime rt = Runtime.getRuntime();
            Process process = rt.exec("df -hl");
            InputStreamReader isr = new InputStreamReader(process.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String str = null;
            String[] strArray = null;
            int line = 0;
            while ((str = br.readLine()) != null) {
                line++;
                if (line != 2) {
                    continue;
                }
                int m = 0;
                strArray = str.split(" ");
                for (String para : strArray) {
                    if (para.trim().length() == 0)
                        continue;
                        ++m;
                    if (para.endsWith("G") || para.endsWith("Gi")) {
                        // 目前的服务器
                        if (m == 2) {
                            systemDto.setTotal(para);
                        }
                        if (m == 3) {
                            systemDto.setUsed(para);
                        }
                    }
                    if (para.endsWith("%")) {
                        if (m == 5) {
                            systemDto.setUse_rate(para);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JSONResult(systemDto);
    }
}
