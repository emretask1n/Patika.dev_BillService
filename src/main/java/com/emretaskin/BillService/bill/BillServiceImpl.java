package com.emretaskin.BillService.bill;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{


    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public Bill giveOrderAndSaveBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public List<Bill> fetchAllBills() {
        return billRepository.findAll();
    }

    @Override
    public List<Bill> fetchBillsGreaterThanAmount(Integer amount) {
        if (amount==null){
            return billRepository.findAll();
        }else {
            return billRepository.findBillsGreaterThanAmount(amount);
        }
    }

    @Override
    public List<Bill> fetchBillsLowerThanAmount(Integer amount) {
        if (amount==null){
            return billRepository.findAll();
        }else {
            return billRepository.findBillsLowerThanAmount(amount);
        }
    }

    @Override
    public double getAverageAmountOfBillsGreaterThanGivenAmount(Integer amount) {
        return  fetchBillsGreaterThanAmount(amount).stream().mapToInt(Bill::getAmount).average().orElse(0.0);
    }

    @Override
    public List<String> fetchDepartmentsOfBillsWhichHasLessTotalAmountThanGivenAmount(Integer amount) {
        if (amount==null){
            return billRepository.findAmountsGroupByDepartments();
        }else{
            return billRepository.findLessAmountsThanGivenAmountAndGroupByDepartments(amount);
        }
    }

    @Override
    public List<String> fetchListOfTotalAmountsOfCustomersSignedInASpecificMonth(Integer amount) {
        if (amount==null){
            return billRepository.findTotalAmountsOfCustomers();
        }else{
            return billRepository.findTotalAmountsOfCustomersSignedInASpecificMonth(amount);
        }
    }


}
