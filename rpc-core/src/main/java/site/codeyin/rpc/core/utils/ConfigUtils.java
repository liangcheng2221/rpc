package site.codeyin.rpc.core.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import cn.hutool.setting.yaml.YamlUtil;

/**
 * 配置操作类
 *
 * @author yinjie
 * @date 2024-07-21 10:37
 */
public class ConfigUtils {

    /**
     * 加载配置对象
     *
     * @param tClass 配置类的字节码对象
     * @param prefix 配置文件中的前缀
     * @param <T>    配置类的类型
     * @return 返回配置类
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix) {
        return loadConfig(tClass, prefix, "");
    }

    /**
     * 加载配置对象，支持区分环境
     *
     * @param tClass      配置类的字节码对象
     * @param prefix      配置文件中的前缀
     * @param environment 配置文件的环境（dev、prod）
     * @param <T>         配置类的类型
     * @return 返回配置类
     */
    public static <T> T loadConfig(Class<T> tClass, String prefix, String environment) {
        StringBuilder configFileBuilder = new StringBuilder("application");
        if (StrUtil.isNotBlank(environment)) {
            configFileBuilder.append("-").append(environment);
        }
        // 读取配置文件优先 properties
        if (FileUtil.exist(configFileBuilder + ".properties")) {
            configFileBuilder.append(".properties");
        } else if (FileUtil.exist(configFileBuilder + ".yml")) {
            configFileBuilder.append(".yml");
            // todo 读取对应配置
        } else if (FileUtil.exist(configFileBuilder + ".yaml")) {
            configFileBuilder.append(".yaml");
            // todo 读取对应配置
        } else {
            configFileBuilder.append(".properties");
        }

        // 默认是 ISO-8859-1 ，要识别中文需要UTF-8编码格式
        Props props = new Props(configFileBuilder.toString(), CharsetUtil.UTF_8);
        // 配置文件的自动监听加载实现
//        props.autoLoad(true);
        return props.toBean(tClass, prefix);
    }
}
