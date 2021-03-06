package com.springapp.mvc.repositories;

import com.springapp.mvc.models.Product;
import com.springapp.mvc.models.Vendor;
import com.springapp.mvc.utils.HibernateUtil;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class VendorRepository {
    private SessionFactory sessionFactory;
    private Session session;

    public VendorRepository() {
        sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
    }

    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = session.createQuery("from Vendor").list();
        return vendors;
    }

    public List<Product> getAllProductsByVendorId(int vendorId) {
        Query query = session.createQuery("from Product P WHERE P.vendorId = :vendorId");
        query.setParameter("vendorId", vendorId);
        List<Product> products = query.list();

        return products;
    }
}
