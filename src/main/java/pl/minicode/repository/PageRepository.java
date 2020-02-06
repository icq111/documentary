package pl.minicode.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import pl.minicode.domain.DocumentPage;

@Repository
public interface PageRepository extends PagingAndSortingRepository<DocumentPage, Long> {

}
