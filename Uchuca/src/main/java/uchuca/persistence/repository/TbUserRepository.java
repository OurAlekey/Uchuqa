package uchuca.persistence.repository;


import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbUser;

public interface TbUserRepository  extends CrudRepository<TbUser,Long> {

    TbUser findByUsuEmail (String email);
}
