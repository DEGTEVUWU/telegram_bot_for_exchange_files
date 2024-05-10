package spring_project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_project.entity.RawData;

@Repository
public interface RawDataDAO extends JpaRepository<RawData, Long> {

}
