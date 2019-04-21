package com.study.information_push.util;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisUtil {

    private static RedisTemplate<String,Object> redisTemplate;

    //在类被加载的时候执行且仅会被执行一次，一般用来初始化静态变量和调用静态方法
    static {
        redisTemplate = (RedisTemplate<String, Object>) SpringContextUtil.getBean("redisTemplate");
    }

    /***
     * 普通缓存放入并设置时间
     * @param key 键
     * @param value 值
     * @param time 时间(秒) time要大于0 如果time小于等于0 将设置无限期
     */
    public static boolean SET(String key,Object value,long time){
        try {
            if(time>0){
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            }else{
                redisTemplate.opsForValue().set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Object GET(String key){
        return redisTemplate.opsForValue().get(key);
    }

    /***
     * 检查是否存有key
     * @param key
     * @return
     */
    public static boolean HASKEY(String key){
        return redisTemplate.hasKey(key);
    }

    /***
     * 添加set集合
     * @param key
     * @param set
     * @return
     */
    public static Long ADDSET(String key, Set<Object> set){
        return redisTemplate.opsForSet().add(key,set);
    }

    /***
     * 根据key查看集合中是否存在指定数据
     * @param key
     * @param value
     * @return
     */
    public static boolean ISMEMBER(String key,Object value){
        return redisTemplate.opsForSet().isMember(key,value);
    }

    /***
     * 根据key获取set集合
     * @param key
     * @return
     */
    public static Set<Object> MEMBERS(String key){
        return redisTemplate.opsForSet().members(key);
    }

    /***
     * 根据key删除缓存
     * @param key
     * @return
     */
    public static boolean DEL(String key){
        return redisTemplate.delete(key);
    }
}
