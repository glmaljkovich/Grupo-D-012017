package grupod.desapp.unq.edu.ar.persistence;

import grupod.desapp.unq.edu.ar.model.shoppinglist.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by gabriel on 09/05/17.
 */
@Transactional
public interface ProductDAO extends PagingAndSortingRepository<Product, Integer> {
    public Product findById(int id);
    public List<Product> findByCategory(String category);
    public Page<Product> findProductsByNameContainingOrBrandContainingAllIgnoreCase(String name, String brand, Pageable page);
}
