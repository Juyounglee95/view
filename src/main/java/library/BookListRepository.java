package library;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface BookListRepository extends CrudRepository<BookList, Long> {

    @Override
    Optional<BookList> findById(Long aLong);
}