import com.gwaysoft.firstappdemo.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  {@link User} {@link Repository}
 */
@Repository
public class UserRepository {
    private final ConcurrentMap<Integer, User> repository = new ConcurrentHashMap<>();
    private final static AtomicInteger idGenerator = new AtomicInteger();
    /**
     *
     * @param user {@link User}
     * @return successful <code>User</code>
     *         false <code>null</code>
     */
    public User save(User user){
        try {
            int id = idGenerator.incrementAndGet();
            user.setId(id);
            repository.putIfAbsent(id, user);
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Collection<User> findAll(){
        return repository.values();
    }
}
