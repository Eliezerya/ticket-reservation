package com.challange_4.apichallange4.Repository;


import com.challange_4.apichallange4.Entity.CostumerOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CostumerOrderRepo extends JpaRepository<CostumerOrder, Integer> {

}
