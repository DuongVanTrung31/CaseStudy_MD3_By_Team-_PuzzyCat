package dao;

import model.Product;

import java.util.List;

public interface IProductDao extends IGeneralDao<Product> {
    List<Product> findByKeyword(String keyword);

    @Override
    default boolean update(int id, Product product) {
        return false;
    }

    @Override
    default boolean add(Product product){
        return false;
    };

    boolean add(Product product, int idCategory, int idBrand);
    boolean update(int id, Product product,int categoryID, int brandID);
}
