package spring_boot.spring_boot.config.Value;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Long>
{
    @Query(nativeQuery = true, value = "SELECT * FROM Car where id >= 0")
    public String showUser(@Param("name") String name, @Param("mark")String mark, @Param("model") String model, @Param("color") String color, @Param("wage") int wage);

    @Query(nativeQuery = true, value = "INSERT INTO Car(String name text,String mark text,String model text,String color text,int wage) VALUES('dssd','eee','xzz','blue',2100) ")
    public List<Car> update(@RequestBody Car car);

}
