package thrift_demo.server;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import thrift_demo.UserService;

/**
 * Created by huyanshi on 2019/03/28.
 */
public class UserServiceImpl implements UserService.Iface {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final static String HUYANSHI = "HUYANSHI";

    @Override
    public String getName(int id) throws TException {
        logger.info("received getName, id = {}:", id);
        return HUYANSHI;
    }

    @Override
    public boolean isExist(String name) throws TException {
        logger.info("receive isExist, name = {}", name);
        return HUYANSHI.equals(name);
    }
}
