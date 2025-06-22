package com.niladri.SpringEcom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.niladri.SpringEcom.model.Product;
import com.niladri.SpringEcom.repo.ProductRepo;

@Service
public class ProductService {
	
@Autowired
	private ProductRepo productrepo;

	public List<Product> getAllProducts() {
		
		return productrepo.findAll();
	}

	public Product getProductById(int id) {
		
		return productrepo.findById(id).orElse(new Product(-1));
	}
	   public Product addOrUpdateProduct(Product product, MultipartFile image) throws IOException {
	        product.setImageName(image.getOriginalFilename());
	        product.setImageType(image.getContentType());
	        product.setImageData(image.getBytes());

	        return productrepo.save(product);
	    }
	   public void deleteProduct(int id) {
	        productrepo.deleteById(id);
	    }

	    public List<Product> searchProducts(String keyword) {
	        return productrepo.searchProducts(keyword);
	    }

}
