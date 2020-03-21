package cn.net.lovelive.mintoolbox.tool.UUID;

import java.util.UUID;

public class Create_UUID {
    // 用来生成UUID
    static String Create_UUID(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
}
