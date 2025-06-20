package com.bmcho.simplebank.service;

import com.bmcho.simplebank.Exception.BasicException;
import com.bmcho.simplebank.Exception.ErrorCode;
import com.bmcho.simplebank.model.Customer;
import com.bmcho.simplebank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserService {

    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Customer registerUser(Customer customer) {
        try {
            String hashPwd = bCryptPasswordEncoder.encode(customer.getPwd());
            customer.setPwd(hashPwd);
            Customer saveCustomer = customerRepository.save(customer);

            if (saveCustomer.getId() < 1) {
                throw new BasicException(ErrorCode.USER_REGISTRATION_FAILED);
            }

            return customer;
        } catch (Exception ex) {
            log.info("registerUser Error: {}", ex.getMessage());
            throw new BasicException(ErrorCode.EXCEPTION_OCCURRED);
        }
    }
}
