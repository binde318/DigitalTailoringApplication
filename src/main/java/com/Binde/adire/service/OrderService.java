package com.Binde.adire.service;

import com.Binde.adire.dto.request.OrderDTO;
import com.Binde.adire.dto.response.OrderResponse;
import com.Binde.adire.dto.response.PaginationResponse;
import com.Binde.adire.dto.response.Report;
import com.Binde.adire.dto.response.RevenueReportResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Service
public interface OrderService {
    OrderResponse createOrder(OrderDTO requestDTO, HttpServletRequest request);


    RevenueReportResponse getAllRevenueReport(HttpServletRequest request);

    OrderDTO findOrderById(String id);

    List<Report> getMonthlyReport(HttpServletRequest request, Principal principal);

    PaginationResponse<OrderDTO> fetchAllOrders(HttpServletRequest request, int pageNo, int pageSize, String sortBy, String sortDir);

    int countOrders(HttpServletRequest request);
    OrderResponse updateOrder(OrderDTO orderDto, String id);
    void deleteOrder(String id);
}
