package com.Binde.adire.service;

import com.Binde.adire.dto.request.CustomerDTO;
import com.Binde.adire.dto.response.CustomerResponseDTO;
import com.Binde.adire.dto.response.PaginationResponse;
import com.Binde.adire.entity.Designer;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface CustomerService {
    PaginationResponse getAllCustomers(HttpServletRequest request, String searchTerm, int pageNo, int pageSize, String sortBy, String sortDir);
    CustomerResponseDTO editCustomerById(String Id, CustomerDTO customerDto);

    CustomerResponseDTO getCustomerById(String Id) throws RuntimeException;
    CustomerResponseDTO getCustomerByEmail(String email);

    void deleteCustomer(String Id);
    int countCustomers(HttpServletRequest request);
    CustomerResponseDTO createCustomer(CustomerDTO requestDTO, HttpServletRequest request);
    Designer getDesignerProfile(HttpServletRequest request);
}
