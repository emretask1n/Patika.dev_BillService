package com.emretaskin.BillService.bill;

import java.util.List;

public interface BillService {

    Bill giveOrderAndSaveBill(Bill bill);

    List<Bill> fetchAllBills();

    List<Bill> fetchBillsGreaterThanAmount(Integer amount);

    List<Bill> fetchBillsLowerThanAmount(Integer amount);

    double getAverageAmountOfBillsGreaterThanGivenAmount(Integer amount);

    List<String> fetchDepartmentsOfBillsWhichHasLessTotalAmountThanGivenAmount(Integer amount);

    List<String> fetchListOfTotalAmountsOfCustomersSignedInASpecificMonth(Integer amount);
}
