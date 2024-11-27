package com.garyrio.service;

import com.garyrio.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Service
@Transactional(timeout = 3)
public class UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 添加事务：@Transactional
     * 方法或者类上
     *
     * 1.只读模式：提升查询事务的效率
     *      (readOnly = true) 默认false
     *      一般情况下，在类上添加事务，类下的所有方法都有事务，给查询重新添加设置readOnly，提高效率
     * 2.超时时间
     *      默认不超时 -1
     *      设置 timeout = 秒数  超过时间，就会回滚事务并释放异常
     *      方法上的注解会覆盖类的注解
     * 3.指定异常回滚
     *      默认情况下，发生运行时异常，事务才会回滚（例如IO异常，不会回滚）
     *      可以指定发生任何异常，都会回滚
     *      (rollbackFor = Exception.class)
     *      (noRollbackFor = ) //指定某个异常不会滚
     * 4.隔离级别设置
     *      推荐设置第二个隔离级别
     *      isolation = Isolation.READ_COMMITTED
     */

    @Transactional(rollbackFor = Exception.class, isolation = Isolation.READ_COMMITTED)
    public void changeInfo() throws FileNotFoundException {
        userDao.updateNameById("zhangsan", 1);
        new FileInputStream("xxxx");
        userDao.updatePasswordById("test1", 1);
    }

    @Transactional(readOnly = true)
    public void getInfo() {

    }

    /**
     * 5.事务传播行为
     *      propagation = Propagation.REQUIRED 父方法有事务，就加入到父方法的事务
     *      默认值 推荐
     *      propagation = Propagation.REQUIRES_NEW 不管父方法是否有事务，都是独立的事务
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName() {
        userDao.updateNameById("zhangsan", 1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void changePassword() {
        userDao.updatePasswordById("123123", 1);
        int i = 1/0;
    }
}
