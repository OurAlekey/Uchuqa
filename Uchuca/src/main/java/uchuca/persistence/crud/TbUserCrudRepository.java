package uchuca.persistence.crud;


import org.springframework.data.repository.CrudRepository;
import uchuca.persistence.entity.TbUser;

public interface TbUserCrudRepository extends CrudRepository<TbUser,Long> {

    TbUser findByUsuEmail (String email);
}
