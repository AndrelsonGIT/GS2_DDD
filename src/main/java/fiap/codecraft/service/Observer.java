package fiap.codecraft.service;

import fiap.codecraft.model.UserEntity;

public interface Observer {
     void update(UserEntity user);
}
