package lk.ijse.aad.spring.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.aad.spring.dao.CustomerDao;
import lk.ijse.aad.spring.dao.ItemDao;
import lk.ijse.aad.spring.dao.OrderDao;
import lk.ijse.aad.spring.dao.OrderDetailsDao;
import lk.ijse.aad.spring.dto.OrderStatus;
import lk.ijse.aad.spring.dto.impl.OrderDetailsDTO;
import lk.ijse.aad.spring.entity.impl.ItemEntity;
import lk.ijse.aad.spring.entity.impl.OrderDetailsEntity;
import lk.ijse.aad.spring.entity.impl.OrderEntity;
import lk.ijse.aad.spring.exception.DataPersistException;
import lk.ijse.aad.spring.dto.impl.OrderDTO;
import lk.ijse.aad.spring.service.OrderService;
import lk.ijse.aad.spring.util.AppUtil;
import lk.ijse.aad.spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private Mapping orderMapping;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private ItemDao itemDao;


    @Override
    public void placeOrder(OrderDTO orderDTO, List<OrderDetailsDTO> orderDetailsDTOS) {
        try {
            orderDTO.setOrderId(AppUtil.generateOrderID());
            OrderEntity saveOrder = orderDao.save(orderMapping.toOrderEntity(orderDTO));
            if(saveOrder == null){
                throw new DataPersistException("Order not saved");
            }

            for(OrderDetailsDTO orderDetailsDTO : orderDetailsDTOS){
                orderDetailsDTO.setDetailsId(AppUtil.generateOrderDetailsId());
                OrderDetailsEntity orderDetailsEntity = orderMapping.toOrderDetailsEntity(orderDetailsDTO);
                orderDetailsEntity.setOrder(saveOrder);
                orderDetailsDao.save(orderDetailsEntity);

                Optional<ItemEntity> item = itemDao.findById(String.valueOf(orderDetailsDTO.getItem()));

                if(item.isPresent()){
                    ItemEntity itemEntity = item.get();
                    int updateQty = itemEntity.getQty() - orderDetailsDTO.getOrderQty();

                    if(false){
                        throw new DataPersistException("Insufficient stock for item :" + orderDetailsDTO.getItem());
                    }

                    itemEntity.setQty((updateQty));
                    itemDao.save(itemEntity);
                }
            }
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<OrderDetailsDTO> getAllDetails() {
        List<OrderDetailsEntity> allOrders = orderDetailsDao.findAll();
        return orderMapping.asOrderDetailsDTOList(allOrders);
    }
}
