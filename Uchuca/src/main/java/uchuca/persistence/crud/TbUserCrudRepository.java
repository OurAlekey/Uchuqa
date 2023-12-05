package uchuca.persistence.crud;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import uchuca.persistence.entity.TbUser;

public interface TbUserCrudRepository extends CrudRepository<TbUser,Long> {

    TbUser findByUsuEmail (String email);

    @Query(value = "SELECT * FROM bd_uchuqa.tb_usuario " +
            "WHERE :primNombre = '0' OR LOWER(usu_nombre) LIKE LOWER(concat('%', :primNombre, '%')) ORDER BY id_usuario ASC",
            countQuery = "SELECT count(*) FROM bd_uchuqa.tb_usuario " +
                    "WHERE :primNombre = '0' OR LOWER(usu_nombre) LIKE LOWER(concat('%', :primNombre, '%')) ORDER BY id_usuario ASC",
            nativeQuery = true)
    Page<TbUser> findByNamePageable(@Param("primNombre")  String nombre, Pageable pageable );
}
