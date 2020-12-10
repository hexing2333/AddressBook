package cn.edu.bupt.demo.dao;
import cn.edu.bupt.demo.entity.item;
import org.springframework.data.repository.CrudRepository;

public interface itemRepository extends CrudRepository<item,Long>{
}
