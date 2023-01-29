package com.emretaskin.BillService.bill;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
public class BillController {


    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/bills")
    public ResponseEntity<Bill> giveOrderAndSaveBill(@RequestBody Bill bill) { return  new ResponseEntity<>(billService.giveOrderAndSaveBill(bill), OK); }

    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> fetchAllBills() { return new ResponseEntity<>(billService.fetchAllBills(),OK); }

    @GetMapping("/bills/greater")
    public ResponseEntity<List<Bill>> fetchBillsGreaterThanAmount(@RequestParam(value = "amount", required = false) Integer amount){
        return new ResponseEntity<>(billService.fetchBillsGreaterThanAmount(amount),OK);
    }

    @GetMapping("/bills/average/greater")
    public ResponseEntity<String> getAverageAmountOfBillsGreaterThanGivenAmount(@RequestParam(value = "amount", required = false) Integer amount){
        return new ResponseEntity<>("Average amount of bills greater than given amount" + billService.getAverageAmountOfBillsGreaterThanGivenAmount(amount),OK);
    }

    @GetMapping("/bills/lower")
    public ResponseEntity<List<Bill>> fetchBillsLowerThanAmount(@RequestParam(value = "amount", required = false) Integer amount){
        return new ResponseEntity<>(billService.fetchBillsLowerThanAmount(amount),OK);
    }

    @GetMapping("/bills/departments/lower")
    public ResponseEntity<List<String>> fetchBillLowerThanAmount(@RequestParam(value = "amount", required = false) Integer amount){
        return new ResponseEntity<>(billService.fetchDepartmentsOfBillsWhichHasLessTotalAmountThanGivenAmount(amount),OK);
    }

    @GetMapping("/bills/total")
    public ResponseEntity<List<String>> fetchListOfTotalAmountsOfCustomersSignedInASpecificMonth(@RequestParam(value = "month", required = false) Integer amount){
        return new ResponseEntity<>(billService.fetchListOfTotalAmountsOfCustomersSignedInASpecificMonth(amount),OK);
    }





}
