package hello;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface PromotionAppliedRepository extends CrudRepository<PromotionApplied, Long> {


    @Modifying
    @Query(value = "INSERT IGNORE INTO PROMOTION_APPLIED (id, promotion_id, num_applied, tmn_id, mobile_no, thai_id) " +
            "VALUES (:promotion_id, :num_applied, :tmn_id, :mobile_no, :thai_id)", nativeQuery = true)
    public int initialApplied(@Param("promotion_id")Long promotion_id,
                              @Param("num_applied")Integer numApplied,
                              @Param("tmn_id")String tmnId,
                              @Param("mobile_no")String mobileNo,
                              @Param("thai_id")String thaiId);

    public List<PromotionApplied> findByPromotionIdAndTmnId(Long promotionId, String tmnId);
    public List<PromotionApplied> findByPromotionIdAndMobileNo(Long promotionId, String mobileNo);
    public List<PromotionApplied> findByPromotionIdAndThaiId(Long promotionId, String thaiId);

    @Query(value = "select * from PROMOTION_APPLIED  where promotion_id = :promotionId and tmn_id = :tmnId " +
            "UNION " +
           "select * from PROMOTION_APPLIED  where promotion_id = :promotionId and  thai_id = :thaiId " +
            "UNION " +
            "select * from PROMOTION_APPLIED  where promotion_id = :promotionId and  mobile_no = :mobileNo ", nativeQuery = true)
            public List<PromotionApplied> findAllByPromotionId(
                    @Param("promotionId")Long promotionId,
                    @Param("tmnId")String tmnId,
                    @Param("thaiId")String thaiId,
                    @Param("mobileNo")String mobileNo);




}
