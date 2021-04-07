package com.fengwenyi.demouserservicecore.service.impl;

import com.fengwenyi.demouserservicecore.cache.DataCache;
import com.fengwenyi.demouserservicecore.domain.UserModel;
import com.fengwenyi.demouserservicecore.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:fengwenyi@aliyun.com">Erwin Feng</a>
 * @since 2021-04-07
 */
@Service
public class UserServiceImpl implements IUserService {

    @Override
    public List<UserModel> queryAll() {
        List<Object> list = DataCache.get();
        if (CollectionUtils.isEmpty(list)) {
            init();
            list = DataCache.get();
        }
        return list.stream().map(o -> (UserModel) o).collect(Collectors.toList());
    }

    @Override
    public UserModel queryById(Integer id) {
        Object o = DataCache.get(genKey(id));
        if (Objects.isNull(o)) {
            init();
            o = DataCache.get(genKey(id));
        }
        return (UserModel) o;
    }

    @Override
    public boolean updateById(UserModel model) {
        try {
            DataCache.set(genKey(model.getId()), model);
            return true;
        } catch (RuntimeException e) {
            return false;
        }
    }

    private void init() {
        UserModel model = new UserModel()
                .setId(1)
                .setName("Wu Ming")
                .setAge(18)
                .setBalance(new BigDecimal(1000))
                ;
        DataCache.set(genKey(model.getId()), model);
    }

    private String genKey(Integer id) {
        if (Objects.isNull(id)) {
            return null;
        }
        return "u" + id;
    }
}
