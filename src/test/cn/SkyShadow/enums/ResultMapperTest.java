package cn.SkyShadow.enums;

import cn.SkyShadow.base.SpringBase;
import org.junit.Test;

/**
 * 测试读取
 * Created by Richard on 16/9/20.
 */
public class ResultMapperTest extends SpringBase{
    @Test
    public void test(){
        System.out.println(ResultMapper.SUCCESS.name());
        System.out.println(SessionNameEnum.user.getInfo());
    }
}