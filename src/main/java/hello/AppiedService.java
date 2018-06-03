package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class AppiedService {

    @Autowired
    private PromotionAppliedRepository promotionAppliedRepository;

    @Transactional
    public List<PromotionApplied> increaseNum(Long promotionId, String tmnId, String thaiId, String mobileNo) throws InterruptedException {
        System.out.println(Thread.currentThread().getId() + " findByTmnId: " + tmnId);
        List<PromotionApplied> numAppliedByTmnId = promotionAppliedRepository.findByPromotionIdAndTmnId(promotionId, tmnId);
        System.out.println(Thread.currentThread().getId() + " findByThaiId: " + thaiId);
        List<PromotionApplied> numAppliedByMobileNo = promotionAppliedRepository.findByPromotionIdAndThaiId(promotionId, thaiId);
        System.out.println(Thread.currentThread().getId() + " findByMobile: " + mobileNo);
        List<PromotionApplied> numAppliedByThaiId = promotionAppliedRepository.findByPromotionIdAndMobileNo(promotionId, mobileNo);

        numAppliedByTmnId.stream().forEach(c -> System.out.println(Thread.currentThread().getId() + " by tmnid: " + c.getTmnId() + " id: "+ c.getId()));
        numAppliedByMobileNo.stream().forEach(c -> System.out.println(Thread.currentThread().getId() + " by mobile no: " + c.getTmnId() + " id: "+ c.getId()));
        numAppliedByThaiId.stream().forEach(c -> System.out.println(Thread.currentThread().getId() + " by thai id: " + c.getTmnId() + " id: "+ c.getId()));
        System.out.println(Thread.currentThread().getId() + " Exit findByTmnId");

        Supplier<Stream<PromotionApplied>> allNumApplied = () -> Stream.concat(
                Stream.concat(numAppliedByTmnId.stream(), numAppliedByMobileNo.stream()),
                numAppliedByThaiId.stream());

        Integer nextNumApplied = allNumApplied.get()
                .max(Comparator.comparing(c -> c.getNumApplied()))
                .orElse(new PromotionApplied())
                .getNumApplied() + 1;
        System.out.println(Thread.currentThread().getId() + " Next applied " + nextNumApplied);

        System.out.println(Thread.currentThread().getId() + " Start saveAll");
        List<PromotionApplied> applieds = allNumApplied.get()
                .map(c -> c.setNumApplied(nextNumApplied))
                .collect(Collectors.toList());
        promotionAppliedRepository.saveAll(applieds);
        System.out.println(Thread.currentThread().getId() + " Exit saveAll");

        System.out.println(Thread.currentThread().getId() + " Start sleep");
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getId() + " Exit sleep");

        return  applieds;
    }
}
