package mach.domain;

import java.util.List;
import mach.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "specs", path = "specs")
public interface SpecRepository extends PagingAndSortingRepository<Spec, Long> {
    List<Spec> findByName(String name);
}
