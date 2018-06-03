package hello;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface PromotionAppliedRepository extends CrudRepository<PromotionApplied, Long> {


    @Modifying
    @Transactional
    @Query(value = "INSERT IGNORE INTO promotion_applied (promotion_id, num_applied, tmn_id, mobile_no, thai_id) " +
            "VALUES (:promotionId, :numApplied, :tmnId, :mobileNo, :thaiId)", nativeQuery = true)
    public int initialApplied(@Param("promotionId")Long promotionId,
                              @Param("numApplied")Integer numApplied,
                              @Param("tmnId")String tmnId,
                              @Param("mobileNo")String mobileNo,
                              @Param("thaiId")String thaiId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public List<PromotionApplied> findByPromotionIdAndTmnId(Long promotionId, String tmnId);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public List<PromotionApplied> findByPromotionIdAndMobileNo(Long promotionId, String mobileNo);
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public List<PromotionApplied> findByPromotionIdAndThaiId(Long promotionId, String thaiId);

    @Query(value = "select * from promotion_applied  where promotion_id = :promotionId and tmn_id = :tmnId " +
            "UNION " +
           "select * from promotion_applied  where promotion_id = :promotionId and  thai_id = :thaiId " +
            "UNION " +
            "select * from promotion_applied  where promotion_id = :promotionId and  mobile_no = :mobileNo "+
            "FOR UPDATE", nativeQuery = true)
            public List<PromotionApplied> findAllByPromotionId(
                    @Param("promotionId")Long promotionId,
                    @Param("tmnId")String tmnId,
                    @Param("thaiId")String thaiId,
                    @Param("mobileNo")String mobileNo);

//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    public List<PromotionApplied> findByTmnId(String tmnId);
//
//
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    public List<PromotionApplied> findByThaiId(String thaiId);
//
//
//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    public List<PromotionApplied> findByMobileNo(String mobileNo);

}
