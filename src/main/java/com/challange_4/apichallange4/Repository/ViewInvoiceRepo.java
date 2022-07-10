package com.challange_4.apichallange4.Repository;

import com.challange_4.apichallange4.Entity.ViewInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewInvoiceRepo extends JpaRepository<ViewInvoice, Integer> {
    public List<ViewInvoice> findByIdUsers(Integer idUsers);
}
