package ecommerce.controller;

import ecommerce.entity.Account;
import ecommerce.entity.Oder;
import ecommerce.entity.OrderDetail;
import ecommerce.entity.ProductDetail;
import ecommerce.entity.Req.CartReq;
import ecommerce.service.IAccountService;
import ecommerce.service.IOderService;
import ecommerce.service.IOrderDetailService;
import ecommerce.service.IProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OderController {
    private final IOderService oderService;
    private final IOrderDetailService orderDetailService;
    private final IAccountService accountService;
    private final IProductDetailService productDetailService;

    @PostMapping("/save/{id}")
    public ResponseEntity<?> save(@PathVariable Long id, @RequestBody CartReq cartReq) {
        Account account = accountService.findById(id);
        Oder order = new Oder();
        order.setAccount(account);
        order.setTotal(cartReq.getTotal());
        order.setOrderDate(cartReq.getOrderDate());
        order.setStatus(cartReq.getStatus());
        order.setShippingAddress(cartReq.getShippingAddress());
        order.setCreatedAt(cartReq.getCreatedAt());
        Oder savedOrder = oderService.save(order);
        for (ProductDetail productDetail : cartReq.getProducts()) {
            ProductDetail productDetail1 = productDetailService.findById(productDetail.getId()).get();
            OrderDetail orderDetail = new OrderDetail(productDetail.getQuantity(), productDetail1, savedOrder);

            orderDetailService.save(orderDetail);
        }
        return ResponseEntity.ok(savedOrder);
    }

}
