package com.cybersoft.Service;

import com.cybersoft.Entity.Promotion;
import com.cybersoft.Repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    public List<Promotion> getAllPromotions() {
        // Sử dụng repository để lấy danh sách khuyến mãi từ cơ sở dữ liệu.
        return promotionRepository.findAll();
    }
}
