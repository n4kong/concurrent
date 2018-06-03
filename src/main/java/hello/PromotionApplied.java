package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class PromotionApplied {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long promotionId;

	private Integer numApplied;
	private String tmnId;
	private String thaiId;
	private String mobileNo;

	public void PromotionApplied(){
		this.numApplied = new Integer(0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public Integer getNumApplied() {
		return numApplied;
	}

	public PromotionApplied setNumApplied(Integer numApplied) {
		this.numApplied = numApplied;
		return this;
	}

	public String getTmnId() {
		return tmnId;
	}

	public void setTmnId(String tmnId) {
		this.tmnId = tmnId;
	}

	public String getThaiId() {
		return thaiId;
	}

	public void setThaiId(String thaiId) {
		this.thaiId = thaiId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
}

