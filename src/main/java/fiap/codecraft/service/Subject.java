package fiap.codecraft.service;

import fiap.codecraft.model.UserEntity;

public interface Subject {

    void notifyObservers(UserEntity user);


}
