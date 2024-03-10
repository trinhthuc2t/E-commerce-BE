package ecommerce.service.implement;

import ecommerce.entity.OrderDetail;
import ecommerce.repository.IOrderDetailRepo;
import ecommerce.service.IAccountService;
import ecommerce.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    IOrderDetailRepo orderDetailRepo;
    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return orderDetailRepo.save(orderDetail);
    }
}
