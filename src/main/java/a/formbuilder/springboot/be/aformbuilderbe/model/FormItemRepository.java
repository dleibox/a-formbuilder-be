package a.formbuilder.springboot.be.aformbuilderbe.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormItemRepository extends JpaRepository<FormItem, Long>{

}