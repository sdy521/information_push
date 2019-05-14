package com.study.information_push.api;

import com.study.information_push.core.JSONResult;
import com.study.information_push.core.Result;
import com.study.information_push.dto.SystemDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
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
        StringBuilder v_result = new StringBuilder();
        try {
            Runtime rt = Runtime.getRuntime();
            Process process = rt.exec("systemctl status mysqld");
            InputStream is = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                v_result.append(line + "\n");
            }
            process.waitFor();
            is.close();
            bufferedReader.close();
            process.destroy();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return new JSONResult(v_result);
    }
}
